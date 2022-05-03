package com.example.demo.service;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    public User validateLogin(String userId) {
        User user = null;
        try {
            user = userMapper.selectById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


    public List<User> getUserList() {
        return userMapper.selectList(null);
    }


    public User getUserById(String userId) {
        return userMapper.selectById(userId);
    }

    @Transactional
    public boolean addUser(User user) {
        if (user.getUserId() != null && !" ".equals(user.getUserId())) {
            try {
                int effectedNum = userMapper.insert(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入用户信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入用户信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户信息不能为空");
        }
    }


    @Transactional
    public boolean register(User user) throws Exception {
        if (user.getUserId() != null && !" ".equals(user.getUserId())) {
            try {
                if (userMapper.selectById(user.getUserId()) != null) {
                    throw new RuntimeException(user.getUserId() + "用户已存在");
                }
                int effectedNum = userMapper.registerUser(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入用户信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入用户信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("用户信息不能为空");
        }
    }


    public boolean modifyUser(User user) {
        if (user.getUserId() != null) {
            try {
                int effectedNum = userMapper.updateById(user);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新用户信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新用户信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("用户信息不能为空！");
        }
    }

    public boolean deleteUser(String userId) {
        if (userId != null) {
            try {
                int effectedNum = userMapper.deleteById(userId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除用户信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除用户信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户ID不能为空！");
        }
    }

    public PageInfo<User> pageQuery(String userId, String nickname, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        if (userId != null && !userId.isEmpty()) {
            map.put("user_id", userId);
        }
        if (nickname != null && !nickname.isEmpty()) {
            map.put("nickname", nickname);
        }
        List<User> all = userMapper.selectByMap(map);
        return new PageInfo<>(all);
    }


}
