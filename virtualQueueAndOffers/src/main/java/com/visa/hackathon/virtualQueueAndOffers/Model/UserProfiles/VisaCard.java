package com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VisaCard {

    @Id
    @NotNull
    private String cardNumber;

    @NotNull
    private String cvv;
    
    @NotNull
    private String billingZipCode;
    
    @NotNull
    private Integer expirationMonth;
    
    @NotNull
    private Integer expirationYear;
    
    @NotNull
    private String nameOnCard;
    
    @NotNull
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "CUSTOMER_ID",referencedColumnName = "USER_ID")
    private Customer customer;

}
