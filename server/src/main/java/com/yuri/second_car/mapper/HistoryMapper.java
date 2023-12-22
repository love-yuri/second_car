package com.yuri.second_car.mapper;

import com.yuri.second_car.entity.History;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HistoryMapper {
    @Select("select * from history where user_id = #{user_id}")
    List<History> allHistory(Integer user_id);

    @Insert("insert into history (user_id, tag) values (#{user_id}, #{tag})")
    int addHistory(History history);

    @Delete("delete from history where id = #{id}")
    int delHistory(int id);
}
