package com.demo.system.parameter;

import javax.validation.constraints.NotBlank;

/**
 * 用户接受参数实体类
 */
public class UserParam {

    /**
     * 用户名
     */
    @NotBlank(groups = {Login.class}, message = "用户名不能为空！")
    private String username;
    /**
     * 密码
     */
    @NotBlank(groups = {Login.class}, message = "密码不能为空！")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public interface Login {

    }
}
