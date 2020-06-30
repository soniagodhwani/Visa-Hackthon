package com.visa.hackathon.virtualQueueAndOffers.Model.Queue;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.visa.hackathon.virtualQueueAndOffers.Enum.CustomerQStatus;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Customer;
import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerQueueRelation {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerQueueRelationId;

    @NotNull
    @ManyToOne
    @JoinColumn(name= "CUSTOMER_ID",referencedColumnName = "USER_ID")
    @JsonBackReference
    private Customer customer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "QUEUE_ID")
    @JsonBackReference
    private Queue queue;

    @NotNull
    private Integer initialQposition;

    private Integer queuePosition;

    private Float waitTimeInMins;

    @NotNull
    private Boolean isValid;

    private LocalDateTime joinTime;

    //private Float estimateStoreTimeInMins;

    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    @NotNull
    private CustomerQStatus customerQStatus;


    public CustomerQueueRelation(Customer customer,Queue queue,int initialQposition,int queuePosition,float waitTimeInMins,Boolean isValid,LocalDateTime joinTime,CustomerQStatus customerQStatus) {

        this.customer = customer;
        this.queue = queue;
        this.initialQposition = initialQposition;
        this.queuePosition = queuePosition;
        this.waitTimeInMins = waitTimeInMins;
        this.isValid = isValid;
        this.joinTime = joinTime;
        this.customerQStatus = customerQStatus;
    }
}
