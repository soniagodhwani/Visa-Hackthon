package com.visa.hackathon.virtualQueueAndOffers.Model.Offer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Offer {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long offerId;

    @OneToMany(mappedBy = "offer", cascade = {CascadeType.PERSIST},orphanRemoval = true)
    @JsonManagedReference
    private List<MerchantOfferRelation> merchantOfferRelations;

    @NotNull
    private String name;
    
    @NotNull
    private Integer visaOfferId;
    
    @NotNull 
    private String description;
    
    @NotNull
    private String endDate;
    
    @NotNull
    private String startDate;
    
}
