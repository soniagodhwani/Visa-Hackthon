package com.visa.hackathon.virtualQueueAndOffers.DAO.Queue;

import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.Queue;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueDAO extends JpaRepository<Queue, Long> {

	public Queue findByMerchant(Merchant merchant);
}
