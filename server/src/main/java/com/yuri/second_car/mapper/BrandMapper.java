package com.yuri.second_car.mapper;

import com.yuri.second_car.entity.CarBrand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BrandMapper {
    // 返回所有品牌
    @Select("select * from car_brand")
    List<CarBrand> allBrand();

    @Insert("insert into car_brand (name, remark) values(#{name}, #{remark})")
    public int addBrand(CarBrand carBrand);

    @Select("select * from car_brand where name = #{name}")
    public CarBrand brand(CarBrand carBrand);

    @Delete("delete from car_brand where id = #{id}")
    public int delBrand(int id);
}
