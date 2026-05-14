package com.food_delivery_springboot_aws.userInfo.service;

import com.food_delivery_springboot_aws.userInfo.dto.UserDTO;
import com.food_delivery_springboot_aws.userInfo.entity.User;
import com.food_delivery_springboot_aws.userInfo.mapper.UserMapper;
import com.food_delivery_springboot_aws.userInfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOtoUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
    }

    public ResponseEntity<UserDTO> fetchUser(Long userId) {
        Optional<User> fetchedUser = userRepo.findById(userId);
        if(fetchedUser.isPresent()){
            return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
