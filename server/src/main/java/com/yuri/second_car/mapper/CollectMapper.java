package com.yuri.second_car.mapper;

import com.yuri.second_car.entity.Collect;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectMapper {
    // 返回所有收藏
    @Select("select * from collect")
    List<Collect> allCollect();

    @Insert("insert into collect (user_id, car_id) values(#{user_id},#{car_id})")
    public int addCollect(Collect collect);

    @Select("select * from collect where user_id = #{user_id} and car_id = #{car_id}")
    public Collect collect(Collect collect);

    @Delete("delete from collect where user_id = #{user_id} and car_id = #{car_id}")
    public int delCollect(Collect collect);
}
