package com.visa.hackathon.virtualQueueAndOffers.Model.Queue;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private long queueId;

    @OneToOne
    @JoinColumn(name = "MERCHANT_ID",referencedColumnName = "USER_ID")
    private Merchant merchant;

    @OneToMany(mappedBy = "queue")
    @JsonManagedReference
    private List<CustomerQueueRelation> customerQueueRelations;

    // start with avgTime a person spends in the queue for that store
    @Column(columnDefinition = "float default 10")
    private Float waitTimeInMins;

    @Column(columnDefinition = "int default 0")
    private Integer currentCountInStore;

    private Integer queueLen;

}
