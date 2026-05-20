package com.food_delivery_springboot_aws.foodcatalogue.repo;

import com.food_delivery_springboot_aws.foodcatalogue.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {
}
