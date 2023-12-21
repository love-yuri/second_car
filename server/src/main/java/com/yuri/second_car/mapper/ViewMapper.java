package com.yuri.second_car.mapper;

import com.yuri.second_car.entity.CarInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ViewMapper {
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


}
