package com.demo.system.domain;

import com.demo.base.BaseDomain;

/**
 * 角色实体类
 *
 * @author ymzhu
 */
public class Role extends BaseDomain {
    /**
     * 角色名称
     */
    private String name;

    /**
     * 标记超级管理员（0否，1是）
     */
    private byte isSuperAdmin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getIsSuperAdmin() {
        return isSuperAdmin;
    }

    public void setIsSuperAdmin(byte isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                '}';
    }
}
