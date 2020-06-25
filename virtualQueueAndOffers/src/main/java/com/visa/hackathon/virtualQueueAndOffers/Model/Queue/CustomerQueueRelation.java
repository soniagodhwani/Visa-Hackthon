package com.visa.hackathon.virtualQueueAndOffers.Model.Queue;


import com.sun.istack.NotNull;
import com.visa.hackathon.virtualQueueAndOffers.Enum.CustomerQStatus;
import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.Offer;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Customer;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class CustomerQueueRelation {


    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerQueueRelationId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "QUEUE_ID")
    private Queue queue;

    private Integer queuePosition;

    private Float waitTimeInMins;

    @NotNull
    private Boolean isValid;

    private LocalDateTime joinTime;

    private Float estimateStoreTimeInMins;

    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    private CustomerQStatus customerQStatus;
}
