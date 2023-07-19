package com.yuri.second_car.mapper;

import com.yuri.second_car.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface carsMapper {
    // 返回所有车辆
    @Select("select * from cars")
    List<Cars> allCar();

    // 返回所有用户
    @Select("select * from users")
    List<Users> allUser();

    // 返回所有品牌
    @Select("select * from car_brand")
    List<CarBrand> allBrand();

    // 返回所有车型
    @Select("select * from car_model")
    List<CarModel> allModel();

    // 返回所有收藏
    @Select("select * from collect")
    List<Collect> allCollect();

    // 返回所有汽车信息
    @Select("select * from view_CarsInfo")
    List<CarInfo> allCarInfo();

    // 根据id 查询汽车信息
    @Select("select * from view_CarsInfo where id = #{id}")
    CarInfo carInfo(int id);

    // 根据id查询收藏信息
    @Select("select * from view_CarsInfo where (id in (select car_id from collect where user_id = #{id}))")
    List<CarInfo> allCollectInfo(int id);

    // 根据id查询仓库信息
    @Select("select * from view_CarsInfo where (id in (select car_id from storehouse where user_id = #{id}))")
    List<CarInfo> allStorehouse(int id);

    @Insert("insert into collect (user_id, car_id) values(#{user_id},#{car_id})")
    public int addCollect(Collect collect);

    @Select("select * from collect where user_id = #{user_id} and car_id = #{car_id}")
    public Collect collect(Collect collect);

    @Delete("delete from collect where user_id = #{user_id} and car_id = #{car_id}")
    public int delCollect(Collect collect);

    @Insert("insert into storehouse (user_id, car_id) values(#{user_id},#{car_id})")
    public int addStorehouse(Storehouse storehouse);

    @Select("select * from storehouse where user_id = #{user_id} and car_id = #{car_id}")
    public Storehouse storehouse(Storehouse storehouse);

    @Delete("delete from storehouse where user_id = #{user_id} and car_id = #{car_id}")
    public int delStorehouse(Storehouse storehouse);

    @Insert("insert into car_brand (name, remark) values(#{name}, #{remark})")
    public int addBrand(CarBrand carBrand);

    @Select("select * from car_brand where name = #{name}")
    public CarBrand brand(CarBrand carBrand);

    @Insert("insert into car_model (brand_id, name) values (#{brand_id}, #{name})")
    public int addModule(CarModel carModel);

    @Select("select * from car_model where name = #{name} and brand_id = #{brand_id}")
    public CarModel module(CarModel carModel);

    @Insert("insert into cars (displacement, registration_date, price, mileage, type_of_clutch, release_date, model_id) values (#{displacement}, #{registration_date}, #{price}, #{mileage}, #{type_of_clutch}, #{release_date}, #{model_id})")
    public int addCars(Cars cars);

    @Delete("delete from car_brand where id = #{id}")
    public int delBrand(int id);

    @Delete("delete from car_model where id = #{id}")
    public int delModel(int id);

    @Select("select * from car_model where id = #{id}")
    public CarModel modelById(int id);

}
