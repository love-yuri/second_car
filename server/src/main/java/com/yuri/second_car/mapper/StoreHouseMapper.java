package com.yuri.second_car.mapper;

import com.yuri.second_car.entity.Storehouse;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StoreHouseMapper {
    @Insert("insert into storehouse (user_id, car_id) values(#{user_id},#{car_id})")
    public int addStorehouse(Storehouse storehouse);

    @Select("select * from storehouse where user_id = #{user_id} and car_id = #{car_id}")
    public Storehouse storehouse(Storehouse storehouse);

    @Delete("delete from storehouse where user_id = #{user_id} and car_id = #{car_id}")
    public int delStorehouse(Storehouse storehouse);


}
