package com.visa.hackathon.virtualQueueAndOffers.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles.UserDAO;
import com.visa.hackathon.virtualQueueAndOffers.Enum.UserType;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.User;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.UserProfile;

@Service
public class LoginService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private CustomerService customerService;

    public UserProfile authenticateUser(String username, String password) {
        User userDetails = userDAO.findByUsername(username);
        if(userDetails== null)
        	return null;
        else if(userDetails.getPassword().equals(password)){
        	if(userDetails.getUserType().equals(UserType.MERCHANT))
        		return merchantService.getMerchantByUser(userDetails);
        	else 
        		return customerService.getCustomerByUser(userDetails);
        }
        else
        	return null;
    }
	
	
}
