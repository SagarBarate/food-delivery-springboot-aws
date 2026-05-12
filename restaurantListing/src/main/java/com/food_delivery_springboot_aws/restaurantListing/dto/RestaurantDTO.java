package com.food_delivery_springboot_aws.restaurantListing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDTO {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
