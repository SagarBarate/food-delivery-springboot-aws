package com.food_delivery_springboot_aws.userInfo.repo;

import com.food_delivery_springboot_aws.userInfo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
