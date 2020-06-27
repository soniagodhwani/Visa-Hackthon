package com.visa.hackathon.virtualQueueAndOffers.Service;

import org.h2.engine.SysProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Customer getCustomerByUser(User user){
		return customerDAO.findByUser(user);
	}
	
	public String registerCustomer(Customer customer){
		if(!this.isUniqueUsername(customer.getUser().getUsername()))
			return "Username already present";
		if(!this.isUniqueEmail(customer.getEmail()))
			return "Email already present";
		if(!this.isUniquePhone(customer.getPhone()))
			return "Phone number already present";
		
		try{
			if(customer.getCards()!=null){
				for(VisaCard card: customer.getCards()){
					card.setCustomer(customer);
				}
			}
			customerDAO.save(customer);
			return "SUCCESS";
		}
		catch(Exception e){
			return e.getMessage();
		}		
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
}
