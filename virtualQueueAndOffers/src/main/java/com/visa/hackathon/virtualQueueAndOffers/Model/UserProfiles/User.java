package com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles;


import com.sun.istack.NotNull;
import com.visa.hackathon.virtualQueueAndOffers.Enum.UserType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NonNull
    private  String username;

    @NonNull
    private  String password;

    private UserType userType;

}
	