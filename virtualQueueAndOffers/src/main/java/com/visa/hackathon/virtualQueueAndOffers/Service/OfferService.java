package com.visa.hackathon.virtualQueueAndOffers.Service;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.developer.sample.offers_api.ApiClient;
import com.visa.developer.sample.offers_api.api.VopOffersApi;
import com.visa.developer.sample.offers_api.model.ActivateOfferpostPayload;
import com.visa.developer.sample.offers_api.model.ActivateOfferpostResponse;
import com.visa.developer.sample.offers_api.model.CreateOfferpostPayload;
import com.visa.developer.sample.offers_api.model.CreateOfferpostResponse;
import com.visa.hackathon.virtualQueueAndOffers.DAO.Offer.MerchantOfferRelationDAO;
import com.visa.hackathon.virtualQueueAndOffers.DAO.Offer.OfferDAO;
import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.RegisterResponse;
import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.MerchantOfferRelation;
import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.Offer;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
@Service
public class OfferService {

	@Autowired
	OfferDAO offerDAO;
	
	@Autowired 
	MerchantOfferRelationDAO merchantOFferRelationDAO;
	
	@Autowired
	com.visa.hackathon.virtualQueueAndOffers.Model.Api.ApiClient api;
	
	public List<Offer> getOffers(long merchantId) {
		try{
			
			List<MerchantOfferRelation> lstMerchantOfferRelation= merchantOFferRelationDAO.findAllByMerchantId(merchantId);
			List<Offer> lstOffer = new ArrayList<Offer>();
			if(lstMerchantOfferRelation!=null && !lstMerchantOfferRelation.isEmpty()){
				for(MerchantOfferRelation mor: lstMerchantOfferRelation){
					DateTime startDate = DateTime.parse(mor.getOffer().getStartDate(), DateTimeFormat.forPattern("MM/dd/yyyy"));
					DateTime endDate = DateTime.parse(mor.getOffer().getEndDate(), DateTimeFormat.forPattern("MM/dd/yyyy"));
					if((startDate.isEqualNow() || startDate.isBeforeNow()) && (endDate.isEqualNow() || endDate.isAfterNow()))
						lstOffer.add(mor.getOffer());
				}
			}
			return lstOffer;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public String createOffer(Offer offer){
		try{
			String message = invokeCreateOfferAPI(offer);
			if(message==null)
				return "Error in offer creation. Try again later";
		}
		catch(Exception e){
			e.printStackTrace();
			return "Error in offer creation. Try again later";
		}
		
		try{
			offerDAO.save(offer);
		}
		catch(Exception e){
			return "Error in offer creation. Try again later";
		}
		
		try{
			String message = activateOffer(offer);
			if(message==null)
				return "Error in offer creation. Try again later";
		}
		catch(Exception e){
			return "Error in offer creation. Try again later";
		}
		return "Offer saved and activated successfully";
	}
	
	private String activateOffer(Offer offer) {
		try{
			ApiClient apiClient = new ApiClient();
	        apiClient.setUsername(api.getUsername());
	        apiClient.setPassword(api.getPassword());
	        apiClient.setKeystorePath(api.getKeystorePath());
	        apiClient.setKeystorePassword(api.getKeystorePassword());
	        apiClient.setPrivateKeyPassword(api.getPrivateKeyPassword());
	        Offer latestOffer = offerDAO.findFirstByOrderByOfferIdDesc();
	        
	        ActivateOfferpostPayload body = new ActivateOfferpostPayload();
	        body.setCommunityCode("PB001CL");
	        body.setOfferId(String.valueOf(offer.getVisaOfferId()));
	        body.setOperationStatus("all");
	        body.setFromDate(DateTime.parse(offer.getStartDate(), DateTimeFormat.forPattern("MM/dd/yyyy")).toString().substring(0,23)+"Z");
	        body.setToDate(DateTime.parse(offer.getEndDate(), DateTimeFormat.forPattern("MM/dd/yyyy")).toString().substring(0,23)+"Z");
	        body.setPageSize(2);
	        body.setStartIndex(0);
	        VopOffersApi vopOffersApi = new VopOffersApi(apiClient);
	        ActivateOfferpostResponse response = vopOffersApi.postactivateOffer(body);
	        ObjectMapper object = new ObjectMapper();
	        if(response==null || !response.getResponseStatus().getCode().equals("SUCCESS")){
	        	return null;

	        }
	        return "SUCCESS";
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
        
	}

	
	public String invokeCreateOfferAPI(Offer offer) {

		try{
	        ApiClient apiClient = new ApiClient();
	        apiClient.setUsername(api.getUsername());
	        apiClient.setPassword(api.getPassword());
	        apiClient.setKeystorePath(api.getKeystorePath());
	        apiClient.setKeystorePassword(api.getKeystorePassword());
	        apiClient.setPrivateKeyPassword(api.getPrivateKeyPassword());
	        
	        CreateOfferpostPayload body = new CreateOfferpostPayload();
	        body.setCommunityCode("PB001CL");
	        body.setName(offer.getName());
	        Offer latestOffer = offerDAO.findFirstByOrderByOfferIdDesc();
	        if(latestOffer ==null)
	        	body.setCorrelationId(String.valueOf("VIRTUALQUEUEANDOFFERS"+1));
	        else
	        	body.setCorrelationId(String.valueOf("VIRTUALQUEUEANDOFFERS"+latestOffer.getOfferId()+1));
	        String startDate = DateTime.parse(offer.getStartDate(), DateTimeFormat.forPattern("MM/dd/yyyy")).toString().substring(0,23)+"Z";
	        body.setStartDate(startDate);
	        String endDate = DateTime.parse(offer.getEndDate(), DateTimeFormat.forPattern("MM/dd/yyyy")).toString().substring(0,23)+"Z";
	        body.setEndDate(endDate);
	        VopOffersApi vopOffersApi = new VopOffersApi(apiClient);
	        CreateOfferpostResponse response = vopOffersApi.postcreateOffer(body);
	        ObjectMapper object = new ObjectMapper();
	        if(!response.getResponseStatus().getCode().equals("SUCCESS"))
	        	return null;
	        
	        offer.setVisaOfferId(response.getOfferId());
	        return "SUCCESS";
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	
	
}