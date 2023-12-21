package com.yuri.second_car.controller;

import com.yuri.second_car.entity.Users;
import com.yuri.second_car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Users login(@RequestBody Users user) {
        return userService.login(user);
    }

    @PostMapping("/updateMoney")
    public int updateMoney(@RequestBody Users users) {
        return userService.updateMoney(users);
    }

    @PostMapping("/addUsers")
    public int addUsers(@RequestBody Users users) {
        return userService.addUsers(users);
    }
}
