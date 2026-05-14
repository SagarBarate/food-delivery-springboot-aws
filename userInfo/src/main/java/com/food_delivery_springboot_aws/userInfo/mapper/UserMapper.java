package com.food_delivery_springboot_aws.userInfo.mapper;

import com.food_delivery_springboot_aws.userInfo.dto.UserDTO;
import com.food_delivery_springboot_aws.userInfo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User mapUserDTOtoUser(UserDTO userDTO);
    UserDTO mapUserToUserDTO(User user);
}
