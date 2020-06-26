package com.visa.hackathon.virtualQueueAndOffers.DAO.Queue;

import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerQueueRelationDAO extends JpaRepository<CustomerQueueRelation,Long> {

    boolean existsByCustomer_IdAndQueue_QueueIdAndIsValid(long customer_id, long queue_id,boolean isValid);
}
