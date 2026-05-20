package com.food_delivery_springboot_aws.foodcatalogue.mapper;

import com.food_delivery_springboot_aws.foodcatalogue.dto.FoodItemDTO;
import com.food_delivery_springboot_aws.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
    FoodItem mapFoodItemDTOtoFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodItemtoFoodItemDTO(FoodItem foodItem);
}
