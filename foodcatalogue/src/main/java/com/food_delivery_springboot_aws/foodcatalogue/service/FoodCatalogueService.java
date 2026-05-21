package com.food_delivery_springboot_aws.foodcatalogue.service;

import com.food_delivery_springboot_aws.foodcatalogue.dto.FoodCataloguePage;
import com.food_delivery_springboot_aws.foodcatalogue.dto.FoodItemDTO;
import com.food_delivery_springboot_aws.foodcatalogue.dto.Restaurant;
import com.food_delivery_springboot_aws.foodcatalogue.entity.FoodItem;
import com.food_delivery_springboot_aws.foodcatalogue.mapper.FoodItemMapper;
import com.food_delivery_springboot_aws.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {
    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
       FoodItem foodItemsaved= foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOtoFoodItem(foodItemDTO));
       return FoodItemMapper.INSTANCE.mapFoodItemtoFoodItemDTO(foodItemsaved);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItem> foodItemList = fetchFoodItems(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurant(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }


    private List<FoodItem> fetchFoodItems(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }

    private Restaurant fetchRestaurantDetailsFromRestaurant(Integer restaurantId) {
        return restTemplate.getForObject(
                "http://RESTAURANT-SERVICE/restaurant/fetchById/" + restaurantId,
                Restaurant.class);
    }

}
