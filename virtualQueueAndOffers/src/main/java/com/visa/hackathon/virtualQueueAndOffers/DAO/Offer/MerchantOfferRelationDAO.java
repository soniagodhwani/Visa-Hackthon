package com.visa.hackathon.virtualQueueAndOffers.DAO.Offer;

import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.MerchantOfferRelation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantOfferRelationDAO extends JpaRepository<MerchantOfferRelation, Long> {

	public List<MerchantOfferRelation> findAllByMerchantId(long merchantId);
}

