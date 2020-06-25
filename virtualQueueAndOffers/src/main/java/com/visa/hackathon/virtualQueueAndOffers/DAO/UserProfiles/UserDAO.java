package com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles;

import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Long> {
}
