package com.yuri.second_car.mapper;

import com.yuri.second_car.entity.CarModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ModuleMapper {
    @Insert("insert into car_model (brand_id, name) values (#{brand_id}, #{name})")
    public int addModule(CarModel carModel);

    @Select("select * from car_model where name = #{name} and brand_id = #{brand_id}")
    public CarModel module(CarModel carModel);
}
