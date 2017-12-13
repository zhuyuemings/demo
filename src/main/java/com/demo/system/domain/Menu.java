package com.demo.system.domain;

import com.demo.base.BaseDomain;

/**
 * 菜单实体类
 *
 * @author ymzhu
 */
public class Menu extends BaseDomain {

    /**
     * 菜单编码
     */
    private String code;
    /**
     * 父菜单编码
     */
    private String parentCode;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单地址
     */
    private String url;
    /**
     * 菜单级别
     */
    private Byte level;
    /**
     * 菜单排序
     */
    private Byte sort;
    /**
     * 创建人主键
     */
    private String creator;
    /**
     * 创建人名称
     */
    private String creatorName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
}
