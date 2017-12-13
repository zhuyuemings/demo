package com.demo.system.service;

import com.demo.system.dao.UserMapper;
import com.demo.system.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User queryById(Serializable id) {
        return userMapper.queryById(id);
    }

    @Override
    public List<User> queryByOffset(Serializable offset, Serializable limit) {
        return userMapper.queryByOffset(offset, limit);
    }

    @Override
    public List<User> queryByObject(User user) {
        return userMapper.queryByObject(user);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int insertSelective(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int updateByIdSelective(User user) {
        return userMapper.updateByIdSelective(user);
    }

    @Override
    public int deleteById(Serializable id) {
        return userMapper.deleteById(id);
    }

    @Override
    public User getEnabledUserByUserName(String username) {
        return userMapper.getEnabledUserByUserName(username);
    }
}
