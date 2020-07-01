package com.visa.hackathon.virtualQueueAndOffers.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visa.developer.sample.merchant_locator_api.model.ResponseValues;
import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.LoginResponse;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.MerchantLocatorResponse;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.QueuingResponse;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.User;
import com.visa.hackathon.virtualQueueAndOffers.Service.MerchantLocatorService;

	@RestController
	public class MerchantLocatorController {
	
		@Autowired
		MerchantLocatorService merchantLocatorService;
	
		 @RequestMapping("/locateAllMerchant/{latitude}/{longitude}")
	    public MerchantLocatorResponse locateAllMerchant(@PathVariable("latitude") String latitude,
	                                 @PathVariable("longitude") String longitude){
		 List<Merchant> lstMerchants = merchantLocatorService.getAllMerchants(latitude, longitude);
		 if(!lstMerchants.isEmpty()){
			 return new MerchantLocatorResponse(lstMerchants, ResponseStatus.SUCCESS, "Merchants located successfully");
		 }
		 else
			return new MerchantLocatorResponse(null, ResponseStatus.FAILURE, "No merchant found");
	 }
	 
	 @RequestMapping("/locateMerchantByDistance/{latitude}/{longitude}/{distance}")
	    public MerchantLocatorResponse locateMerchantByDistance(@PathVariable("latitude") String latitude,
	                                 @PathVariable("longitude") String longitude,
	                                 @PathVariable("distance") long distance){
		 List<Merchant> lstMerchants = merchantLocatorService.getMerchantsByDistance(latitude, longitude, distance);
		 if(!lstMerchants.isEmpty()){
			 return new MerchantLocatorResponse(lstMerchants, ResponseStatus.SUCCESS, "Merchants located successfully");
		 }
		 else
			return new MerchantLocatorResponse(null, ResponseStatus.FAILURE, "No merchant found");
	 }
	 
	 @RequestMapping("/locateMerchantByCategory/{latitude}/{longitude}/{category}")
	    public MerchantLocatorResponse locateMerchantByDistance(@PathVariable("latitude") String latitude,
	                                 @PathVariable("longitude") String longitude,
	                                 @PathVariable("category") String category){
		 String[] arrCategory = category.split(",");
		 List<String> lstCategory = new ArrayList<>();
	     Collections.addAll(lstCategory, arrCategory);
		 List<Merchant> lstMerchants = merchantLocatorService.getMerchantsByCategory(latitude, longitude, lstCategory);
		 if(!lstMerchants.isEmpty()){
			 return new MerchantLocatorResponse(lstMerchants, ResponseStatus.SUCCESS, "Merchants located successfully");
		 }
		 else
			return new MerchantLocatorResponse(null, ResponseStatus.FAILURE, "No merchant found");
	 }
}
