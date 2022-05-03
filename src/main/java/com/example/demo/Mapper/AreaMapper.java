package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Area;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaMapper extends BaseMapper<Area> {
    @Select("select max(area_id) from tb_area")
    Integer getMaxId();
}
