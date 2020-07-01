package com.visa.hackathon.virtualQueueAndOffers.Model.Offer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Merchant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class MerchantOfferRelation {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long merchantOfferRelationId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "MERCHANT_ID", referencedColumnName="USER_ID")
    private Merchant merchant;

    @NotNull
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "OFFER_ID")
    private Offer offer;

  /*  @NotNull
    private LocalDateTime activatedOn;

    @NotNull
    private Boolean isActivated;*/
}
