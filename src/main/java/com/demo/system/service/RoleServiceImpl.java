package com.demo.system.service;

import com.demo.base.BaseService;
import com.demo.system.dao.RoleMapper;
import com.demo.system.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements BaseService<Role> {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role queryById(Serializable id) {
        return roleMapper.queryById(id);
    }

    @Override
    public List<Role> queryByOffset(Serializable offset, Serializable limit) {
        return roleMapper.queryByOffset(offset, limit);
    }

    @Override
    public List<Role> queryByObject(Role role) {
        return roleMapper.queryByObject(role);
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int insertSelective(Role role) {
        return roleMapper.insertSelective(role);
    }

    @Override
    public int updateById(Role role) {
        return roleMapper.updateById(role);
    }

    @Override
    public int updateByIdSelective(Role role) {
        return roleMapper.updateByIdSelective(role);
    }

    @Override
    public int deleteById(Serializable id) {
        return roleMapper.deleteById(id);
    }
}
