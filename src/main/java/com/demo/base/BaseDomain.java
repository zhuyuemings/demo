package com.demo.base;

import java.util.Date;

/**
 * 顶层实体类
 *
 * @author ymzhu
 */
public class BaseDomain {
    /**
     * 主键
     */
    private String id;
    /**
     * 状态（0：删除，1启用，2禁用）
     */
    private Byte status;
    /**
     * 创建时间
     */
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BaseDomain{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }

    /**
     * 状态枚举
     */
    public enum Status {
        DELETE((byte) 0, "删除"), ENABLED((byte) 1, "正常"), DISABLED((byte) 2, "禁用");
        private Byte code;
        private String name;

        Status(Byte code, String name) {
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

    public enum YesOrNo {
        YES((byte) 1, "否"), NO((byte) 0, "否");

        private byte code;
        private String name;

        YesOrNo(byte code, String name) {
            this.code = code;
            this.name = name;
        }

        public byte getCode() {
            return code;
        }

        public void setCode(byte code) {
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

