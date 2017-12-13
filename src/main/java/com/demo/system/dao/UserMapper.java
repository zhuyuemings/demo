package com.demo.system.dao;

import com.demo.base.BaseMapper;
import com.demo.system.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    User getEnabledUserByUserName(@Param("username") String username);
}
