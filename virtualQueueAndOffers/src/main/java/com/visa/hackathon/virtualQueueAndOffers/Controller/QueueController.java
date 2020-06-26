package com.visa.hackathon.virtualQueueAndOffers.Controller;

import com.visa.hackathon.virtualQueueAndOffers.Enum.CustomerQStatus;
import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.QueuingResponse;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;
import com.visa.hackathon.virtualQueueAndOffers.Service.QueingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    QueingService queingService;

    @PostMapping("/join/{customer_id}/{queue_id}")
    public QueuingResponse joinQ(@PathVariable("customer_id") long customer_id,
                                 @PathVariable("queue_id") long queue_id){
        CustomerQueueRelation relation  = queingService.joinQueue(customer_id,queue_id);
        if(relation == null){
            return new QueuingResponse(null, ResponseStatus.FAILURE,"You are already present in the queue");
        }else if(relation.getCustomerQStatus() == CustomerQStatus.ENTRY_AVAILABLE_IMMEDIATELY){
            return new QueuingResponse(relation,ResponseStatus.SUCCESS,"Entry available immediately. Do you want to check in ?");
        }
        else{
            return new QueuingResponse(relation,ResponseStatus.SUCCESS,"You are now added to the queue");
        }
    }

    @PostMapping("/leave/{customer_queue_relation_id}")
    public QueuingResponse leaveQ(@PathVariable("customer_queue_relation_id") long customer_queue_relation_id){
        CustomerQueueRelation relation  = queingService.leaveQueue(customer_queue_relation_id);
        if(relation == null){
            return new QueuingResponse(null, ResponseStatus.FAILURE,"You were not present in the queue");
        }else{
            return new QueuingResponse(relation,ResponseStatus.SUCCESS,"You are now removed from the queue");
        }
    }

    @PostMapping("/checkin/{customer_queue_relation_id}")
    public QueuingResponse checkInStore(@PathVariable("customer_queue_relation_id") long customer_queue_relation_id){
        CustomerQueueRelation relation  = queingService.checkIn(customer_queue_relation_id);
        if(relation == null){
            return new QueuingResponse(null, ResponseStatus.FAILURE,"You were not present in the queue");
        }
        else if(relation.getCustomerQStatus() == CustomerQStatus.JOINED){
            return new QueuingResponse(relation, ResponseStatus.FAILURE,"WAIT IN QUEUE FOR SOME MORE TIME! STORE IS FULL RIGHT NOW!");
        }
        else if(relation.getCustomerQStatus() == CustomerQStatus.ENTRY_AVAILABLE_IMMEDIATELY){
            return new QueuingResponse(relation, ResponseStatus.FAILURE,"THE STORE BECAME FULL, PLEASE TRY JOINING THE QUEUE AGAIN.");

        }
        else{
            return new QueuingResponse(relation,ResponseStatus.SUCCESS,"You are now removed from the queue");
        }
    }

    @PostMapping("/checkout/{customer_queue_relation_id}")
    public QueuingResponse checkOutStore(@PathVariable("customer_queue_relation_id") long customer_queue_relation_id){
        CustomerQueueRelation relation  = queingService.checkOut(customer_queue_relation_id);
        if(relation == null){
            return new QueuingResponse(null, ResponseStatus.FAILURE,"You were not present in the queue");
        }
        else if(relation.getCustomerQStatus() != CustomerQStatus.CHECKOUT){
            return new QueuingResponse(relation, ResponseStatus.FAILURE,"You are not check in to be check out");
        }
        else{
            return new QueuingResponse(relation,ResponseStatus.SUCCESS,"You can now leave the store");
        }
    }


    //get a customer queue for specific merchant
    //get all queues for a customer


}
