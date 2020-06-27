package com.visa.hackathon.virtualQueueAndOffers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.RegisterResponse;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Customer;
import com.visa.hackathon.virtualQueueAndOffers.Service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerRegistrationController {


	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/registerCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public RegisterResponse registerCustomer(@RequestBody Customer customer){
		String message = customerService.registerCustomer(customer);
		if(!message.contains("SUCCESS"))
			return new RegisterResponse(null, ResponseStatus.FAILURE, message);
		else
			return new RegisterResponse(customer, ResponseStatus.SUCCESS, "Registration successful!");
	}
	
}
