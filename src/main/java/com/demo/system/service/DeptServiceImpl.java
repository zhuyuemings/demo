package com.demo.system.service;

import com.demo.system.dao.DeptMapper;
import com.demo.system.domain.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Dept queryById(Serializable id) {
        return deptMapper.queryById(id);
    }

    @Override
    public List<Dept> queryByOffset(Serializable offset, Serializable limit) {
        return deptMapper.queryByOffset(offset, limit);
    }

    @Override
    public List<Dept> queryByObject(Dept dept) {
        return deptMapper.queryByObject(dept);
    }

    @Override
    public int insert(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public int insertSelective(Dept dept) {
        return deptMapper.insertSelective(dept);
    }

    @Override
    public int updateById(Dept dept) {
        return deptMapper.updateById(dept);
    }

    @Override
    public int updateByIdSelective(Dept dept) {
        return deptMapper.updateByIdSelective(dept);
    }

    @Override
    public int deleteById(Serializable id) {
        return deptMapper.deleteById(id);
    }
}
