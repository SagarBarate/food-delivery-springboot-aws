package com.food_delivery_springboot_aws.foodcatalogue.service;

import com.food_delivery_springboot_aws.foodcatalogue.dto.FoodItemDTO;
import com.food_delivery_springboot_aws.foodcatalogue.entity.FoodItem;
import com.food_delivery_springboot_aws.foodcatalogue.mapper.FoodItemMapper;
import com.food_delivery_springboot_aws.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodCatalogueService {
    @Autowired
    FoodItemRepo foodItemRepo;

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
       FoodItem foodItemsaved= foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOtoFoodItem(foodItemDTO));
       return FoodItemMapper.INSTANCE.mapFoodItemtoFoodItemDTO(foodItemsaved);
    }
}
