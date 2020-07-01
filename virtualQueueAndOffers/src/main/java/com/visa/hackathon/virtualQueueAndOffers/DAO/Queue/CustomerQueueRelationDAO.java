package com.visa.hackathon.virtualQueueAndOffers.DAO.Queue;

import com.visa.hackathon.virtualQueueAndOffers.Enum.CustomerQStatus;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerQueueRelationDAO extends JpaRepository<CustomerQueueRelation,Long> {

    boolean existsByCustomer_IdAndQueue_QueueIdAndIsValid(long customer_id, long queue_id,boolean isValid);

    List<CustomerQueueRelation> findAllByQueue_QueueIdAndQueuePositionIsGreaterThanAndCustomerQStatus(long queue_id, int queuePosition, CustomerQStatus customerQStatus);

    List<CustomerQueueRelation> findAllByCustomerAndIsValid(long customer_id,boolean isValid);

}
