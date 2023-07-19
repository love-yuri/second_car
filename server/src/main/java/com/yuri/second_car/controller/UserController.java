package com.yuri.second_car.controller;

import com.yuri.second_car.entity.Users;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.yuri.second_car.mapper.userMapper;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    private final userMapper userMapper;

    public UserController(com.yuri.second_car.mapper.userMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public Users login(@RequestBody Users user) {
        return userMapper.queryByUserName(user.getUsername());
    }

    @PostMapping("/updateMoney")
    public int updateMoney(@RequestBody Users users) {
        return userMapper.updateMoney(users);
    }

    @PostMapping("/addUsers")
    public int addUsers(@RequestBody Users users) {
        Users users1 = userMapper.queryByUserName(users.getUsername());
        if(users1 != null) {
            return -1;
        }
        return userMapper.addUsers(users);
    }
}
