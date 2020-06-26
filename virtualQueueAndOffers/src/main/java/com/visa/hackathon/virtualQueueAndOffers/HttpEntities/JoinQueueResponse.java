package com.visa.hackathon.virtualQueueAndOffers.HttpEntities;

import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JoinQueueResponse {

    private CustomerQueueRelation customerQueueRelation;
    private ResponseStatus responseStatus;
    private String message;

}
