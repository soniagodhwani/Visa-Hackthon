package com.visa.hackathon.virtualQueueAndOffers.HttpEntities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantLocatorResponse {
	@Autowired
	private ResponseStatus responseStatus;
	
    private String message;
    
    @Autowired
    private List<MerchantObjectResponse> lstMerchant;

	public MerchantLocatorResponse(List<MerchantObjectResponse> lstMerchant, ResponseStatus responseStatus, String message) {
		super();
		this.responseStatus = responseStatus;
		this.message = message;
		this.lstMerchant = lstMerchant;
	}
    
}
