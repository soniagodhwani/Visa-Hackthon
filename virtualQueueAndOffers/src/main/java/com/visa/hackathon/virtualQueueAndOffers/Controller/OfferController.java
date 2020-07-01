package com.visa.hackathon.virtualQueueAndOffers.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.OfferResponse;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.RegisterResponse;
import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.Offer;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import com.visa.hackathon.virtualQueueAndOffers.Service.OfferService;

@RestController
public class OfferController {

	@Autowired 
	OfferService offerService;
	
	@RequestMapping("/retrieveOffers/{merchantId}")
	public OfferResponse retrieveOffers(@PathVariable long merchantId){
		List<Offer> lstOffer= offerService.getOffers(merchantId);
		if(lstOffer==null)
			return new OfferResponse(null, ResponseStatus.FAILURE, "Error retrieving offers");
		else if(lstOffer.isEmpty())
			return new OfferResponse(null, ResponseStatus.SUCCESS, "No offers are available for this merchant");
		else
			return new OfferResponse(lstOffer, ResponseStatus.SUCCESS, "Offers fetched successfully");

	}

	@PostMapping("/createOffer")
	public OfferResponse createOffer(@RequestBody Offer offer){
		List<Offer> lstOffer= new ArrayList<Offer>();
		String message= offerService.createOffer(offer);
		if(!message.contains("success"))
			return new OfferResponse(null, ResponseStatus.FAILURE, message);
		else
			return new OfferResponse(null, ResponseStatus.SUCCESS, message);
	}
	
	
}
