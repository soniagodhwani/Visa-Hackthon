package com.visa.hackathon.virtualQueueAndOffers.DAO.Offer;

import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferDAO extends JpaRepository<Offer, Long> {

}
