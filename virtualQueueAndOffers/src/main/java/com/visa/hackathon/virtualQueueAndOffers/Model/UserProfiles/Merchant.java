package com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.MerchantOfferRelation;
import com.visa.hackathon.virtualQueueAndOffers.Model.Offer.Offer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Merchant implements UserProfile{

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    @MapsId
    private User user;

    @NotNull
    private String visaMerchantId;
    
    @Transient
    private String merchantName;
    
    @Transient
    private List<String> merchantCategoryCode;
    
    @Transient
    private long queueId;
    

    @Transient
    private String latitude;

    @Transient
    private String longitude;

    @NotNull
    private String visaStoreId;

    @NotNull
    private Integer maxStoreCapacity;

    @NotNull
    private  Integer maxAllowingCapacity;

	private Float avgCustomerWaitTime;
	

    @OneToMany(mappedBy = "merchant")
    @JsonBackReference
    private List<MerchantOfferRelation> merchantOfferRelations;

}
