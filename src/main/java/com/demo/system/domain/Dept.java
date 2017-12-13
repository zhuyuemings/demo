package com.demo.system.domain;

import com.demo.base.BaseDomain;

/**
 * 部门实体类
 *
 * @author ymzhu
 */
public class Dept extends BaseDomain {
    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门主键
     */
    private String parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
