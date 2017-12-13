package com.demo.system.service;

import com.demo.base.BaseService;
import com.demo.system.domain.User;

public interface UserService extends BaseService<User> {
    User getEnabledUserByUserName(String username);
}
