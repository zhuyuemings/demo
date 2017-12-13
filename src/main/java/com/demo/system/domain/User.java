package com.demo.system.domain;

import com.demo.base.BaseDomain;

/**
 * 用户实体类
 *
 * @author ymzhu
 */
public class User extends BaseDomain {

    /**
     * 用户名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户真实姓名
     */
    private String truename;
    /**
     * 用户性别
     */
    private Byte sex;
    /**
     * 用户手机号
     */
    private String tel;

    public User() {
    }

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

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", truename='" + truename + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                '}';
    }

    /**
     * 用户性别枚举
     */
    public enum Sex {
        UNKNOWN((byte) 0, "未知"), MALE((byte) 1, "男"), FEMALE((byte) 1, "女");
        private Byte code;
        private String name;

        Sex(Byte code, String name) {
            this.code = code;
            this.name = name;
        }

        public Byte getCode() {
            return code;
        }

        public void setCode(Byte code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
