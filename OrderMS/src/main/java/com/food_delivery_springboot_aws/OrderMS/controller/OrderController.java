package com.food_delivery_springboot_aws.OrderMS.controller;

import com.food_delivery_springboot_aws.OrderMS.dto.OrderDTO;
import com.food_delivery_springboot_aws.OrderMS.dto.OrderDTOFromFE;
import com.food_delivery_springboot_aws.OrderMS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails) {
        OrderDTO orderSavedInDB = orderService.saveOrderDv(orderDetails);
        return new ResponseEntity<>(orderSavedInDB, HttpStatus.OK);
    }

}
