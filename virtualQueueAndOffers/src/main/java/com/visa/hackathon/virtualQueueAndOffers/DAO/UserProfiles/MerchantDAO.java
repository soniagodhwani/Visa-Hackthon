package com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles;

import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantDAO extends JpaRepository<Merchant,Long> {
}
