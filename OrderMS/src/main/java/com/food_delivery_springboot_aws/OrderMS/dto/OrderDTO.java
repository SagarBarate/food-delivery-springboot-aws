package com.food_delivery_springboot_aws.OrderMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private List<FoodItemDTO> foodItemDTOList;
    private String userId;
    private Restaurant restaurant;
}
