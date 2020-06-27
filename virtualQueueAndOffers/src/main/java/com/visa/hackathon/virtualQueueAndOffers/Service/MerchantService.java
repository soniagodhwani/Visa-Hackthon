package com.visa.hackathon.virtualQueueAndOffers.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.hackathon.virtualQueueAndOffers.DAO.Queue.QueueDAO;
import com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles.MerchantDAO;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.Queue;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.User;

@Service
public class MerchantService {

	@Autowired
	private MerchantDAO merchantDAO;
	
	@Autowired 
	private QueueDAO queueDAO;
	
	public Merchant getMerchantByUser(User user){
		return merchantDAO.findByUser(user);
	}
	
	public String registerMerchant(Merchant merchant){
		//call API to check valid merchant
		
		if(!this.isUniqueVisaStoreId(merchant.getVisaStoreId())){
			return "StoreId already present";
		}
		else{
			try{
				merchantDAO.save(merchant);
				Queue queue = new Queue(merchant, new ArrayList<CustomerQueueRelation>(), merchant.getAvgCustomerWaitTime(), 0, 0);
				queueDAO.save(queue);
				return "SUCCESS";
			}
			catch(Exception e){				
				return e.getMessage();
			}
		}
	}
	
	public boolean isUniqueVisaStoreId(String visaStoreId){
		return !merchantDAO.existsByVisaStoreId(visaStoreId);
	}
	
}
