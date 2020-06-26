package com.visa.hackathon.virtualQueueAndOffers.Model.Queue;

import com.sun.istack.NotNull;
import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.MerchantOfferRelation;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Queue {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long qeueId;

    @OneToOne
    @JoinColumn(name = "MERCHANT_ID",referencedColumnName = "USER_ID")
    private Merchant merchant;

    @OneToMany(mappedBy = "queue")
    private List<CustomerQueueRelation> customerQueueRelations;

    private Float waitTimeInMins;

    private Integer queueLen;

}
