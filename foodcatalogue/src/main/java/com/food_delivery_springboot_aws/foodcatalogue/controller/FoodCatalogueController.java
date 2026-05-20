package com.food_delivery_springboot_aws.foodcatalogue.controller;

import com.food_delivery_springboot_aws.foodcatalogue.repo.FoodItemRepo;
import com.food_delivery_springboot_aws.foodcatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    @Autowired
    FoodCatalogueService foodCatalogueService;


}
