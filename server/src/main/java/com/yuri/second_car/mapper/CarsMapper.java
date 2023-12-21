package com.yuri.second_car.mapper;

import com.yuri.second_car.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarsMapper {
    // 返回所有车辆
    @Select("select * from cars")
    List<Cars> allCar();

    @Insert("insert into cars (displacement, registration_date, price, mileage, type_of_clutch, release_date, model_id) values (#{displacement}, #{registration_date}, #{price}, #{mileage}, #{type_of_clutch}, #{release_date}, #{model_id})")
    public int addCars(Cars cars);
}
