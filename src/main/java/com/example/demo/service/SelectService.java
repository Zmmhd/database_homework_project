package com.example.demo.service;

import com.example.demo.Mapper.SelectMapper;
import com.example.demo.entity.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectService {
    @Autowired
    private SelectMapper selectMapper;

    public List<Select> getSelectById(String userId) {
        return selectMapper.getSelectById(userId);
    }
}
