package com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles;

import com.sun.istack.NotNull;
import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.MerchantOfferRelation;
import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.Offer;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
public class Merchant{

    @Id
    private long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    @MapsId
    private User user;

    @NotNull
    private String visaNerchantId;

    @NotNull
    private String visaStoreId;

    @NotNull
    private Integer maxStoreCpacity;

    @NotNull
    private  Integer maxAllowingCapacity;

    private Float avgCustomerTime;


    @OneToMany(mappedBy = "merchant")
    private List<MerchantOfferRelation> merchantOfferRelations;

}
