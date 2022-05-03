package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Show;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShowMapper extends BaseMapper<Show> {
    @Select("select * from tb_show where show_site = #{showSite}")
    List<Show> selectByShowSite(String showSite);

    @Select("select * from tb_show where show_type = #{showType}")
    List<Show> selectByShowType(String showType);

    @Select("select * from tb_show where show_name = #{showName}")
    List<Show> selectByShowName(String showName);

    @Select("select count(*) from tb_show where show_name=#{showName}")
    public int countByShowName(String showName);

    @Select("select max(show_id) from tb_seat")
    Integer getMaxId();

}
