package com.visa.hackathon.virtualQueueAndOffers.Service;

import java.security.Principal;
import java.util.Random;
import java.util.UUID;

import org.bouncycastle.eac.EACException;
import org.h2.engine.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.visa.developer.sample.offers_api.api.VopOffersApi;
import com.visa.developer.sample.offers_api.model.ActivateUserpostPayload;
import com.visa.developer.sample.offers_api.model.ActivateUserpostResponse;
import com.visa.developer.sample.users_api.ApiClient;
import com.visa.developer.sample.users_api.api.VopUsersApi;
import com.visa.developer.sample.users_api.model.Card;
import com.visa.developer.sample.users_api.model.SaveCardpostPayload;
import com.visa.developer.sample.users_api.model.SaveCardpostResponse;
import com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles.CustomerDAO;
import com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles.UserDAO;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Customer;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.User;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.VisaCard;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private UserDAO userDAO;	
	
	@Autowired
	com.visa.hackathon.virtualQueueAndOffers.Model.Api.ApiClient api;
	
	
	public String registerCustomer(Customer customer){
		if(!this.isUniqueUsername(customer.getUser().getUsername()))
			return "Username already present";
		
		if(!this.isUniqueEmail(customer.getEmail()))
			return "Email already present";
		
		if(!this.isUniquePhone(customer.getPhone()))
			return "Phone number already present";
		
		if(customer.getCards()!=null){
			for(VisaCard card: customer.getCards()){
				card.setCustomer(customer);
			}
		}
		
		try{
			saveCustomerDetails(customer);
		}
		catch(Exception e){
			e.printStackTrace();
			return "Error saving customer details";
		}
		
		if(customer.getHasVisaCard()){
			//save customer card details
			try{
				saveCustomerCardDetails(customer);
			}
			catch(Exception e){
				e.printStackTrace();
				return "Customer saved successfully, error in saving customer card details, try again";
			}
			//Activate customer to all offers
			try{
				activateCustomerToOffers(customer);
			}
			catch(Exception e){
				e.printStackTrace();
				return "Customer and card details saved successfully, error in error in activating users to offers, try again";
			}
			
		}	
		return "Customer and card details saved successfully, customer has been activated for all offers";			
	}
	
	private void activateCustomerToOffers(Customer customer) throws Exception{
		try{
			ActivateUserpostPayload body = new ActivateUserpostPayload();
			body.setCommunityCode("GAP");
			body.setUserKey(String.valueOf(customer.getId()));
			body.setOperationStatus("all");
			
			com.visa.developer.sample.offers_api.ApiClient apiClient = new com.visa.developer.sample.offers_api.ApiClient();
			apiClient.setUsername(api.getUsername());
	        apiClient.setPassword(api.getPassword());
	        apiClient.setKeystorePath(api.getKeystorePath());
	        apiClient.setKeystorePassword(api.getKeystorePassword());
	        apiClient.setPrivateKeyPassword(api.getPrivateKeyPassword());
	        VopOffersApi vopOffersApi = new VopOffersApi(apiClient);
	        ActivateUserpostResponse response = vopOffersApi.postactivateUser(body);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		}
		
	}

	private void saveCustomerCardDetails(Customer customer) throws Exception {
		
		for(VisaCard visaCard: customer.getCards()){
			try{
				SaveCardpostPayload body = new SaveCardpostPayload();
		        
		        Card card = new Card();
		        card.setExpirationMonth(visaCard.getExpirationMonth());
		        card.setExpirationYear(visaCard.getExpirationYear());
		        card.setCvv2(visaCard.getCvv());
		        card.setBillingZipCode(visaCard.getBillingZipCode());
		        card.setCardNumber(visaCard.getCardNumber());
		        card.setNameOnCard(visaCard.getNameOnCard());
		        
		        body.setCard(card);
		        body.setCommunityCode("GAP");
		        body.setUserKey(String.valueOf(customer.getId()));
		        
		        ApiClient apiClient = new ApiClient();
		        apiClient.setUsername(api.getUsername());
		        apiClient.setPassword(api.getPassword());
		        apiClient.setKeystorePath(api.getKeystorePath());
		        apiClient.setKeystorePassword(api.getKeystorePassword());
		        apiClient.setPrivateKeyPassword(api.getPrivateKeyPassword());
		
		        VopUsersApi vopUsersApi = new VopUsersApi(apiClient);
		        SaveCardpostResponse response = vopUsersApi.postsaveCard(body);
		        if(!response.getResponseStatus().getCode().equals("SUCCESS")){
					throw new Exception("Error in API");
		        }
		     }
			catch(Exception e){
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
			
	}

	private void saveCustomerDetails(Customer customer) {
		customerDAO.save(customer);
	}

	public boolean isUniqueUsername(String username){
		return !(userDAO.existsByUsername(username));
	}
	public boolean isUniqueEmail(String email){
		return !(customerDAO.existsByEmail(email));
	}
	public boolean isUniquePhone(String phone){
		return !(customerDAO.existsByPhone(phone));
	}
	public Customer getCustomerByUser(User user){
		return customerDAO.findByUser(user);
	}
}
