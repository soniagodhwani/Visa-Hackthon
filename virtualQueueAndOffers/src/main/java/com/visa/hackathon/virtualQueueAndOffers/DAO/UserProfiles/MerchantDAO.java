package com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles;

import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantDAO extends JpaRepository<Merchant,Long> {
	
	public Merchant findByUser(User user);
	public boolean existsByVisaStoreId(String visaStoreId);
	public Merchant findByVisaStoreId(String visaStoreId);

}
