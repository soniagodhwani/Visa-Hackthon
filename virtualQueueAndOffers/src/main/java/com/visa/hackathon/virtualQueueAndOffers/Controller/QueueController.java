package com.visa.hackathon.virtualQueueAndOffers.Controller;

import com.visa.hackathon.virtualQueueAndOffers.Enum.ResponseStatus;
import com.visa.hackathon.virtualQueueAndOffers.HttpEntities.JoinQueueResponse;
import com.visa.hackathon.virtualQueueAndOffers.Model.Queue.CustomerQueueRelation;
import com.visa.hackathon.virtualQueueAndOffers.Service.QueingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    QueingService queingService;

    @PostMapping("/join/{customer_id}/{queue_id}")
    public JoinQueueResponse joinQ(@PathVariable("customer_id") long customer_id,
                                       @PathVariable("queue_id") long queue_id){
        CustomerQueueRelation relation  = queingService.joinQueue(customer_id,queue_id);
        if(relation == null){
            return new JoinQueueResponse(null, ResponseStatus.FAILURE,"You are already present in the queue");
        }else{
            return new JoinQueueResponse(relation,ResponseStatus.SUCCESS,"You are now added to the queue");
        }
    }
}
