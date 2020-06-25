package com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles;

import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.VisaCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDAO extends JpaRepository<VisaCard,Long> {
}
