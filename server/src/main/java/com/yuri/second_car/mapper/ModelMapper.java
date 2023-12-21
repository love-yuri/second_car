package com.yuri.second_car.mapper;

import com.yuri.second_car.entity.CarModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ModelMapper {
    // 返回所有车型
    @Select("select * from car_model")
    List<CarModel> allModel();

    @Delete("delete from car_model where id = #{id}")
    public int delModel(int id);

    @Select("select * from car_model where id = #{id}")
    public CarModel modelById(int id);

    @Insert("insert into car_model (brand_id, name) values (#{brand_id}, #{name})")
    public int addModule(CarModel carModel);

    @Select("select * from car_model where name = #{name} and brand_id = #{brand_id}")
    public CarModel model(CarModel carModel);

}
