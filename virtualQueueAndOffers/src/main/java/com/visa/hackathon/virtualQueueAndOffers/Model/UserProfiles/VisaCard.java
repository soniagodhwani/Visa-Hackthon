package com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class VisaCard {

    @Id
    @NotNull
    private String cardNumber;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

}
