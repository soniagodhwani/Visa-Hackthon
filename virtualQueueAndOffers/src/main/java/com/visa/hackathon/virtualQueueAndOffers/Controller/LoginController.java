package com.visa.hackathon.virtualQueueAndOffers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.Enum.UserType;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.LoginResponse;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.User;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.UserProfile;
import com.visa.hackathon.virtualQueueAndOffers.Service.CustomerService;
import com.visa.hackathon.virtualQueueAndOffers.Service.LoginService;
import com.visa.hackathon.virtualQueueAndOffers.Service.MerchantService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/login")
	public LoginResponse authenticateUser(@RequestBody User user){
		
		User loggedUser = loginService.authenticateUser(user.getUsername(), user.getPassword());
		
		if(loggedUser!=null){
			if(loggedUser.getUserType().equals(UserType.MERCHANT)){
			UserProfile userProfile = merchantService.getMerchantByUser(loggedUser);
			return new LoginResponse(userProfile, ResponseStatus.SUCCESS, "Logged in successfully");
			}
			else if(loggedUser.getUserType().equals(UserType.CUSTOMER)){
				UserProfile userProfile = customerService.getCustomerByUser(loggedUser);
				return new LoginResponse(userProfile, ResponseStatus.SUCCESS, "Logged in successfully");
	
			}
		}
		return new LoginResponse(null, ResponseStatus.FAILURE, "Incorrect UserName or Password");

	}
	
}
