package com.visa.hackathon.virtualQueueAndOffers.HttpEntities;

import java.util.List;

import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.Offer;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferResponse {
	
    
    private List<Offer> lstOffer;
	private ResponseStatus responseStatus;
    private String message;


}

