package com.food_delivery_springboot_aws.OrderMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
    private Long id;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private String price;
    private Integer restaurantId;
    private Integer quantity;
}
