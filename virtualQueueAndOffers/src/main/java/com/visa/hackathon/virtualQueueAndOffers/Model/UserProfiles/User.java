package com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private  String username;

    @NonNull
    private  String password;
    @OneToOne(mappedBy = "user", optional = false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
