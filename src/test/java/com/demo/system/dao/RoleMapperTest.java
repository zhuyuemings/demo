package com.demo.system.dao;

import com.demo.base.BaseMapperTest;
import com.demo.base.BaseTest;
import com.demo.system.domain.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleMapperTest extends BaseTest implements BaseMapperTest {

    public static final String roleId = "38c4ee1a-dee1-11e7-ada5-87fd61eb7a9e";
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void testQueryById() {
        testQueryById(roleMapper, roleId);
    }

    @Test
    public void testQueryByOffset() {
        int offset = 0;
        int limit = 10;
        testQueryByOffset(roleMapper, offset, limit);
    }

    @Test
    public void testQueryByObject() {
        Role role = new Role();
        role.setName("超级管理员");
        testQueryByObject(roleMapper, role);
    }

    @Test
    public void testInsert() {
        Role role = new Role();
        role.setName("普通用户");
        role.setStatus(Role.Status.ENABLED.getCode());
        testInsert(roleMapper, role);
    }

    @Test
    public void testInsertSelective() {
        Role role = new Role();
        role.setName("普通用户");
        testInsertSelective(roleMapper, role);
    }

    @Test
    public void testUpdateById() {
        Role role = roleMapper.queryById(roleId);
        role.setStatus(Role.Status.DISABLED.getCode());
        testUpdateById(roleMapper, role);
    }

    @Test
    public void testUpdateByIdSelective() {
        Role role = new Role();
        role.setId(roleId);
        role.setName("普通用户");
        testUpdateByIdSelective(roleMapper, role);
    }

    @Test
    public void testDeleteById() {
        testDeleteById(roleMapper, roleId);
    }
}
