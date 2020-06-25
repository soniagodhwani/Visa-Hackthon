package com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles;

import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer,Long> {
}
