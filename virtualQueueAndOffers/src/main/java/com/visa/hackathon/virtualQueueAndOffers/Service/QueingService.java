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
import java.util.List;

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
        Customer customer = customerDAO.findById(customerId);
        Integer currCount = queue.getCurrentCountInStore();
        Integer maxAllowingCap = queue.getMerchant().getMaxAllowingCapacity();

        if(currCount < maxAllowingCap){
            CustomerQueueRelation relation = new CustomerQueueRelation(customer, queue, 0, 0, 0, true, LocalDateTime.now(), CustomerQStatus.ENTRY_AVAILABLE_IMMEDIATELY);
            customerQueueRelationDAO.save(relation);
            return relation;
        }

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

    public CustomerQueueRelation leaveQueue(long customer_queue_relation_id){

        CustomerQueueRelation customerQueueRelation = customerQueueRelationDAO.findById(customer_queue_relation_id).orElse(null);

        if(customerQueueRelation == null){
            return null;
        }


        Queue queue = customerQueueRelation.getQueue();
        Float merchantAvgWaitTime = queue.getMerchant().getAvgCustomerWaitTime();

        List<CustomerQueueRelation> relationsTobeUpdated= customerQueueRelationDAO.findAllByQueue_QueueIdAndQueuePositionIsGreaterThanAndCustomerQStatus(queue.getQueueId(),customerQueueRelation.getQueuePosition(),CustomerQStatus.JOINED);

        customerQueueRelation.setCustomerQStatus(CustomerQStatus.CANCELLED);
        customerQueueRelation.setIsValid(false);
        customerQueueRelationDAO.save(customerQueueRelation);
        for (CustomerQueueRelation cqr : relationsTobeUpdated) {
            cqr.setQueuePosition(cqr.getQueuePosition() - 1 );
            cqr.setWaitTimeInMins(cqr.getWaitTimeInMins() - merchantAvgWaitTime);
            customerQueueRelationDAO.save(cqr);
        }

        queue.setWaitTimeInMins(queue.getWaitTimeInMins() - merchantAvgWaitTime);
        queue.setQueueLen(queue.getQueueLen() - 1);
        queueDAO.save(queue);
        // code to publish to other users about change in their queue position
        return customerQueueRelation;
    }


    public CustomerQueueRelation checkIn(long customer_queue_relation_id) {
        CustomerQueueRelation customerQueueRelation = customerQueueRelationDAO.findById(customer_queue_relation_id).orElse(null);


        if(customerQueueRelation == null){
            return null;
        }
        Queue queue = customerQueueRelation.getQueue();
        Integer maxCapacity = queue.getMerchant().getMaxAllowingCapacity();
        if(customerQueueRelation.getCustomerQStatus() == CustomerQStatus.ENTRY_AVAILABLE_IMMEDIATELY && queue.getCurrentCountInStore() < maxCapacity){
            queue.setCurrentCountInStore(queue.getCurrentCountInStore()+1);
            customerQueueRelation.setCustomerQStatus(CustomerQStatus.CHECKEDIN);
            customerQueueRelation.setCheckInTime(LocalDateTime.now());
            customerQueueRelationDAO.save(customerQueueRelation);
            return customerQueueRelation;
        }else if(customerQueueRelation.getCustomerQStatus() == CustomerQStatus.ENTRY_AVAILABLE_IMMEDIATELY && queue.getCurrentCountInStore() >= maxCapacity){
            customerQueueRelation.setIsValid(false);
            return customerQueueRelation;
        }
        else if(customerQueueRelation.getQueuePosition() > 1 || (queue.getCurrentCountInStore() >= maxCapacity)){
            return customerQueueRelation;
        }


        Float merchantAvgWaitTime = queue.getMerchant().getAvgCustomerWaitTime();

        List<CustomerQueueRelation> relationsTobeUpdated= customerQueueRelationDAO.findAllByQueue_QueueIdAndQueuePositionIsGreaterThanAndCustomerQStatus(queue.getQueueId(),customerQueueRelation.getQueuePosition(),CustomerQStatus.JOINED);

        customerQueueRelation.setQueuePosition(0);
        customerQueueRelation.setCheckInTime(LocalDateTime.now());
        customerQueueRelation.setCustomerQStatus(CustomerQStatus.CHECKEDIN);
        customerQueueRelationDAO.save(customerQueueRelation);

        for (CustomerQueueRelation cqr : relationsTobeUpdated) {
            cqr.setQueuePosition(cqr.getQueuePosition() - 1 );
            cqr.setWaitTimeInMins(cqr.getWaitTimeInMins() - merchantAvgWaitTime);
            customerQueueRelationDAO.save(cqr);
        }

        queue.setCurrentCountInStore(queue.getCurrentCountInStore()+1);
        queue.setWaitTimeInMins(queue.getWaitTimeInMins() - merchantAvgWaitTime);
        queue.setQueueLen(queue.getQueueLen() - 1);
        queueDAO.save(queue);
        // code to publish to other users about change in their queue position
        return customerQueueRelation;

    }

    public CustomerQueueRelation checkOut(long customer_queue_relation_id) {

        CustomerQueueRelation customerQueueRelation = customerQueueRelationDAO.findById(customer_queue_relation_id).orElse(null);


        if(customerQueueRelation == null ){
            return null;
        }
        if (customerQueueRelation.getCustomerQStatus() != CustomerQStatus.CHECKEDIN){
            return customerQueueRelation;
        }
        Queue queue = customerQueueRelation.getQueue();

        customerQueueRelation.setCheckOutTime(LocalDateTime.now());
        customerQueueRelation.setCustomerQStatus(CustomerQStatus.CHECKOUT);
        customerQueueRelationDAO.save(customerQueueRelation);

        queue.setCurrentCountInStore(queue.getCurrentCountInStore() - 1);
        queueDAO.save(queue);

        // code to publish to other users about change in their queue position and especially to queue poition 1 to enter the store
        return customerQueueRelation;
    }
}
