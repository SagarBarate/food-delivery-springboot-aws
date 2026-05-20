package com.food_delivery_springboot_aws.foodcatalogue.service;

import com.food_delivery_springboot_aws.foodcatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodCatalogueService {
    @Autowired
    FoodItemRepo foodItemRepo;
}
