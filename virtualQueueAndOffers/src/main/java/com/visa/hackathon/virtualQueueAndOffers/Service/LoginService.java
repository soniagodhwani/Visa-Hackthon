package com.visa.hackathon.virtualQueueAndOffers.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles.UserDAO;
import com.visa.hackathon.virtualQueueAndOffers.Enum.UserType;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.User;

@Service
public class LoginService {

	@Autowired
	UserDAO userDAO;

    public User authenticateUser(String username, String password) {
        User userDetails = userDAO.findByUsername(username);
        if(userDetails== null)
        	return null;
        else if(userDetails.getPassword().equals(password)){  
        	return userDetails;
        }
        else
        	return null;
    }
	
	
}
