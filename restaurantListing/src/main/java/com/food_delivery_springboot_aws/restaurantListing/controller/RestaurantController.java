package com.food_delivery_springboot_aws.restaurantListing.controller;

import com.food_delivery_springboot_aws.restaurantListing.dto.RestaurantDTO;
import com.food_delivery_springboot_aws.restaurantListing.entity.Restaurant;
import com.food_delivery_springboot_aws.restaurantListing.repo.RestaurantRepo;
import com.food_delivery_springboot_aws.restaurantListing.service.RestaurantService;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
        List<RestaurantDTO> allRestaurants = restaurantService.findAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatusCode.valueOf(HttpStatus.SC_OK));
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantAdded, HttpStatusCode.valueOf(HttpStatus.SC_CREATED));
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable Long id) {
        return restaurantService.fetchRestaurantById(Math.toIntExact(id));
    }
}

