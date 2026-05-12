package com.food_delivery_springboot_aws.restaurantListing.service;

import com.food_delivery_springboot_aws.restaurantListing.dto.RestaurantDTO;
import com.food_delivery_springboot_aws.restaurantListing.entity.Restaurant;
import com.food_delivery_springboot_aws.restaurantListing.mapper.RestaurantMapper;
import com.food_delivery_springboot_aws.restaurantListing.repo.RestaurantRepo;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurants(){
        List<Restaurant> allRestaurants = restaurantRepo.findAll();
        List<RestaurantDTO> restaurantDTOList = allRestaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
        return restaurantDTOList;
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
       Restaurant savedRestaurant= restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
       return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
    }

    public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if(restaurant.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()), HttpStatusCode.valueOf(HttpStatus.SC_OK));
        }
        return new ResponseEntity<>(null,HttpStatusCode.valueOf(HttpStatus.SC_NOT_FOUND));

    }
}
