package com.visa.hackathon.virtualQueueAndOffers.HttpEntities;

import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantObjectResponse {

    private Merchant merchant;
    private Float current_waitTime;

}
