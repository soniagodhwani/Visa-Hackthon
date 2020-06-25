package com.visa.hackathon.virtualQueueAndOffers.Model.Offer;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Offer {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long offerId;

    @OneToMany(mappedBy = "offer")
    private List<MerchantOfferRelation> merchantOfferRelations;

    // To do other details about an offer based on VOP
}
