package com.yuri.second_car.mapper;

import com.yuri.second_car.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users where username = #{username}")
    Users queryByUserName(String username);

    @Update("update users set money = #{money} where username = #{username}")
    public int updateMoney(Users users);

    @Insert("insert into users (username, password) values(#{username}, #{password})")
    public int addUsers(Users users);

    // 返回所有用户
    @Select("select * from users")
    List<Users> allUser();


}
