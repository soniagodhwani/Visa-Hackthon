package com.visa.hackathon.virtualQueueAndOffers.Service;


import com.visa.hackathon.virtualQueueAndOffers.DAO.Queue.CustomerQueueRelationDAO;
import com.visa.hackathon.virtualQueueAndOffers.DAO.Queue.QueueDAO;
import com.visa.hackathon.virtualQueueAndOffers.DAO.UserProfiles.CustomerDAO;
import com.visa.hackathon.virtualQueueAndOffers.Enum.CustomerQStatus;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.Queue;
import com.visa.hackathon.virtualQueueAndOffers.Model.UserProfiles.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
public class QueingService {

    @Autowired
    private QueueDAO queueDAO;

    @Autowired
    private CustomerQueueRelationDAO customerQueueRelationDAO;

    @Autowired
    private CustomerDAO customerDAO;

    public CustomerQueueRelation joinQueue(long customerId, long queueId){

        if(customerQueueRelationDAO.existsByCustomer_IdAndQueue_QueueIdAndIsValid(customerId,queueId,true)){
            return null;
        }

        Queue queue = queueDAO.findById(queueId).orElse(null);
        Customer customer = customerDAO.findById(customerId).orElse(null);


        Integer customerInitialPostion = queue.getQueueLen() + 1;
        Float expectedWaittime = queue.getWaitTimeInMins();
        Float merchantAvgWaitTime = queue.getMerchant().getAvgCustomerWaitTime();
        CustomerQueueRelation customerQueueRelation= new CustomerQueueRelation(customer,queue,customerInitialPostion,customerInitialPostion,expectedWaittime,true,LocalDateTime.now(), CustomerQStatus.JOINED);
        customerQueueRelationDAO.save(customerQueueRelation);
        queue.setQueueLen(customerInitialPostion);
        queue.setWaitTimeInMins(expectedWaittime + merchantAvgWaitTime);
        queueDAO.save(queue);
        return customerQueueRelation;
    }

}
