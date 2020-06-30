package com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements UserProfile{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST},orphanRemoval = true)
    @JsonManagedReference
    private List<VisaCard> cards;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST},orphanRemoval = true)
    @JsonManagedReference
    private List<CustomerQueueRelation> customerQueueRelations;
    
    public void addCard(VisaCard visaCard) {
    	if(this.getCards()==null)
    		cards = new ArrayList<VisaCard>();
        this.getCards().add(visaCard);
        visaCard.setCustomer(this);
     }
    public void removeCard(VisaCard visaCard) {
    	cards.remove(visaCard);
        visaCard.setCustomer(null);
    }
	   
}
