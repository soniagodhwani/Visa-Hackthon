package com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {


    @Id
    private long id;

    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    @MapsId
    private User user;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NotNull
    private String phone;

    @NotNull
    private Boolean hasVisaCard;

    @OneToMany(mappedBy = "customer")
    private List<VisaCard> cards;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<CustomerQueueRelation> customerQueueRelations;
}
