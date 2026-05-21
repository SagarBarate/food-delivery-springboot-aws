package com.food_delivery_springboot_aws.OrderMS.mapper;


import com.food_delivery_springboot_aws.OrderMS.dto.OrderDTO;
import com.food_delivery_springboot_aws.OrderMS.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOtoOrder(OrderDTO orderDTO);
    OrderDTO mapOrdertoOrderDTO(Order order);

}
