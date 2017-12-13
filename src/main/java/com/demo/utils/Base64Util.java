package com.demo.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64加密解密工具
 */
public class Base64Util {
    /**
     * 使用UTF8编码
     */
    private static final String UTF8 = "utf-8";

    /**
     * 加密字符串
     *
     * @param str 需要加密的字符串
     * @return String 加密后的字符串
     * @since 1.8
     */
    public static String encodeStr(String str) {
        if (null == str || str.equals("")) {
            return null;
        }
        try {
            return new String(Base64.getEncoder().encode(str.getBytes(UTF8)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密字符串
     *
     * @param str 需要解密的字符串
     * @return String 解密后的字符串
     * @since 1.8
     */
    public static String decodeStr(String str) {
        if (null == str || str.equals("")) {
            return null;
        }
        try {
            return new String(Base64.getDecoder().decode(str.getBytes(UTF8)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(encodeStr(str));
        System.out.println(decodeStr(encodeStr(str)));
    }

}
