package com.food_delivery_springboot_aws.restaurantListing.repo;

import com.food_delivery_springboot_aws.restaurantListing.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

}
