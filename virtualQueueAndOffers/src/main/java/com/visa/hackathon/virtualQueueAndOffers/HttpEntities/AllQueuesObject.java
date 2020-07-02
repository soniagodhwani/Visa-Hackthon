package com.visa.hackathon.virtualQueueAndOffers.HttpEntities;

import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.Queue;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllQueuesObject {
    private Queue q;
    private Merchant m;
    private CustomerQueueRelation cqr;

}
