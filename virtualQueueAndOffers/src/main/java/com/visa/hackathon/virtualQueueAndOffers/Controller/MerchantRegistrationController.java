package com.visa.hackathon.virtualQueueAndOffers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.RegisterResponse;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import com.visa.hackathon.virtualQueueAndOffers.Service.MerchantService;

@RestController
public class MerchantRegistrationController {
	
	@Autowired
	private MerchantService merchantService;

	@PostMapping("/registerMerchant")
	public RegisterResponse registerCustomer(@RequestBody Merchant merchant){
		String message= merchantService.registerMerchant(merchant);
		if(!message.contains("SUCCESS"))
			return new RegisterResponse(null, ResponseStatus.FAILURE, "Merchant details already present");
		else
			return new RegisterResponse(merchant, ResponseStatus.SUCCESS, "Registration successful!");
	}
}
