package com.visa.hackathon.virtualQueueAndOffers.DAO.Queue;

import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.Queue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueueDAO extends JpaRepository<Queue, Long> {
}
