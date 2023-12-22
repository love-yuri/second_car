package com.yuri.second_car.service;

import com.yuri.second_car.entity.Users;
import com.yuri.second_car.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<Users> getAllUsers() {
        List<Users> users = userMapper.allUser();
        if(users.isEmpty()) {
            System.out.println("用户数量为0\n");
        }
        return users;
    }

    public Users login(Users user) {
        return userMapper.queryByUserName(user.getUsername());
    }

    public int updateMoney(Users users) {
        return userMapper.updateMoney(users);
    }

    public int addUsers(Users users) {
        Users users1 = userMapper.queryByUserName(users.getUsername());
        if(users1 != null) {
            return -1;
        }
        return userMapper.addUsers(users);
    }

    public Users findUserByUsername(String username) {
        return userMapper.queryByUserName(username);
    }
}
