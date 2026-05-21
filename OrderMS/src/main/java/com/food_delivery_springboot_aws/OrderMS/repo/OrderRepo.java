package com.food_delivery_springboot_aws.OrderMS.repo;


import com.food_delivery_springboot_aws.OrderMS.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends MongoRepository<Order, Integer> {

}
