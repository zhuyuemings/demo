package com.demo.system.dao;

import com.demo.base.BaseMapperTest;
import com.demo.base.BaseTest;
import com.demo.system.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapperTest extends BaseTest implements BaseMapperTest {
    private static final String userId = "887e2f92-dcc1-11e7-92f1-0fc096afab4d";
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryById() {
        testQueryById(userMapper, userId);
    }

    @Test
    public void testQueryByOffset() {
        int offset = 0;
        int limit = 10;
        testQueryByOffset(userMapper, offset, limit);
    }

    @Test
    public void testQueryByObject() {
        User user = new User();
        user.setTruename("其");
        testQueryByObject(userMapper, user);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSex(User.Sex.MALE.getCode());
        user.setTruename("测试");
        user.setStatus(User.Status.ENABLED.getCode());
        user.setTel("12200009876");
        testInsert(userMapper, user);
    }

    @Test
    public void testInsertSelective() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setStatus(User.Sex.MALE.getCode());
        user.setTruename("测试");
        user.setStatus(User.Status.ENABLED.getCode());
        testInsertSelective(userMapper, user);
    }

    @Test
    public void testUpdateById() {
        User user = userMapper.queryById(userId);
        user.setSex(User.Sex.FEMALE.getCode());
        testUpdateById(userMapper, user);
    }

    @Test
    public void testUpdateByIdSelective() {
        User user = new User();
        user.setId(userId);
        user.setUsername("test");
        testUpdateByIdSelective(userMapper, user);
    }

    @Test
    public void testDeleteById() {
        testDeleteById(userMapper, userId);
    }
}
