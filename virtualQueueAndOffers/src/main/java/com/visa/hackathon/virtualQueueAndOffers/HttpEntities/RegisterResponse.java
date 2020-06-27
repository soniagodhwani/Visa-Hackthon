package com.visa.hackathon.virtualQueueAndOffers.HttpEntities;

import org.springframework.beans.factory.annotation.Autowired;

import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.UserProfile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {

	@Autowired
	private ResponseStatus responseStatus;
	
    private String message;
    
    @Autowired
    private UserProfile userProfile;

	public RegisterResponse(UserProfile userProfile, ResponseStatus responseStatus, String message) {
		super();
		this.responseStatus = responseStatus;
		this.message = message;
		this.userProfile = userProfile;
	}
    
}
