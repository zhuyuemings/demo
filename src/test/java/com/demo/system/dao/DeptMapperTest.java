package com.demo.system.dao;

import com.demo.base.BaseMapperTest;
import com.demo.base.BaseTest;
import com.demo.system.domain.Dept;
import com.demo.system.domain.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DeptMapperTest extends BaseTest implements BaseMapperTest {

    public static final String deptId = "2f6f6b8a-df02-11e7-ada5-87fd61eb7a9e";
    @Autowired
    private DeptMapper deptMapper;

    @Test
    public void testQueryById() {
        testQueryById(deptMapper, deptId);
    }

    @Test
    public void testQueryByOffset() {
        int offset = 0;
        int limit = 10;
        testQueryByOffset(deptMapper, offset, limit);
    }

    @Test
    public void testQueryByObject() {
        Dept dept = new Dept();
        dept.setName("研发部");
        testQueryByObject(deptMapper, dept);
    }

    @Test
    public void testInsert() {
        Dept dept = new Dept();
        dept.setName("测试部");
        dept.setStatus(Dept.Status.ENABLED.getCode());
        testInsert(deptMapper, dept);
    }

    @Test
    public void testInsertSelective() {
        Dept dept = new Dept();
        dept.setName("测试部");
        testInsertSelective(deptMapper, dept);
    }

    @Test
    public void testUpdateById() {
        Dept dept = deptMapper.queryById(deptId);
        dept.setStatus(Role.Status.DISABLED.getCode());
        testUpdateById(deptMapper, dept);
    }

    @Test
    public void testUpdateByIdSelective() {
        Dept dept = new Dept();
        dept.setId(deptId);
        dept.setName("测试部");
        testUpdateByIdSelective(deptMapper, dept);
    }

    @Test
    public void testDeleteById() {
        testDeleteById(deptMapper, deptId);
    }
}
