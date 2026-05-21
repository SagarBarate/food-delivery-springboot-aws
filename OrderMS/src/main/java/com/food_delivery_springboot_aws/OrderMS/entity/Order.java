package com.food_delivery_springboot_aws.OrderMS.entity;

import com.food_delivery_springboot_aws.OrderMS.dto.FoodItemDTO;
import com.food_delivery_springboot_aws.OrderMS.dto.Restaurant;
import com.food_delivery_springboot_aws.OrderMS.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemDTOList;
    private Restaurant restaurant;
    private UserDTO userDTO;

}
