package com.demo.base;

import com.alibaba.fastjson.JSONObject;

/**
 * 顶层控制器
 *
 * @author ymzhu
 */
public class BaseController {

    public static final String STATUS = "status";
    public static final String MESSAGE = "message";

    protected String getJsonResult(byte code, String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(STATUS, code);
        jsonObject.put(MESSAGE, msg);
        return jsonObject.toJSONString();
    }

    protected String getJsonResult(byte code) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(STATUS, code);
        return jsonObject.toJSONString();
    }

    /**
     * 返回码枚举
     */
    protected enum Status {
        EXCEPTION((byte) -1, "异常"), SUCCESS((byte) 0, "成功"), FAILED((byte) 1, "失败"), DATA_ERROR((byte) 2, "错误");
        private byte code;
        private String name;

        Status(byte code, String name) {
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

    protected interface AccessPrefix {
        public static final String SYSTEM = "/system";
    }
}
