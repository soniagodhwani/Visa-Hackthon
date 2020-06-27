package com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles;

import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Customer;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer,Long> {
	
	public Customer findByUser(User user);
	public Customer findById(long id);
	public boolean existsByPhone(String phone);
	public boolean existsByEmail(String email);
}
