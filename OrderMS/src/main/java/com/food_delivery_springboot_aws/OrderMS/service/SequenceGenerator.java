package com.food_delivery_springboot_aws.OrderMS.service;

import com.food_delivery_springboot_aws.OrderMS.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateNextOrderId(){

       Sequence counter= mongoOperations.findAndModify(
                query(Criteria.where("_id").is("sequence")),
                new Update().inc("sequence",1),
                options().returnNew(true).upsert(true),
                Sequence.class
        );
        return counter.getSequence();
    }
}
