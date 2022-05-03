package com.example.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectMapper extends BaseMapper<Select> {
    List<Select> getSelectById(String userId);
}
