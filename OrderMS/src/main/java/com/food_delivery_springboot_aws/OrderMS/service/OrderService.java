package com.food_delivery_springboot_aws.OrderMS.service;

import com.food_delivery_springboot_aws.OrderMS.dto.OrderDTO;
import com.food_delivery_springboot_aws.OrderMS.dto.OrderDTOFromFE;
import com.food_delivery_springboot_aws.OrderMS.dto.UserDTO;
import com.food_delivery_springboot_aws.OrderMS.entity.Order;
import com.food_delivery_springboot_aws.OrderMS.mapper.OrderMapper;
import com.food_delivery_springboot_aws.OrderMS.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.food_delivery_springboot_aws.OrderMS.service.SequenceGenerator;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderDv(OrderDTOFromFE orderDetails) {

        Integer newOrderID = sequenceGenerator.generateNextOrderId();

        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());

        Order orderToBeSaved = new Order(
                newOrderID,
                orderDetails.getFoodItemDTOList(),
                orderDetails.getRestaurant(),
                userDTO);

        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrdertoOrderDTO(orderToBeSaved);

    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
    return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }

}
