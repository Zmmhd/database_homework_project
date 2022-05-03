package com.example.demo.service;

import com.example.demo.Mapper.AdminMapper;
import com.example.demo.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public Admin getAdminById(String adminId) {
        Admin admin = null;
        try{
            admin = adminMapper.selectById(adminId);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
//        return adminDao.queryAdminById(adminId);
    }
}
