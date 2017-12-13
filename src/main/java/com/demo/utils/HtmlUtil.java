package com.demo.utils;

import org.springframework.web.util.HtmlUtils;

public class HtmlUtil {

    public static void main(String[] args) {
        String html = "<script>alert(1)</script>";
        String eHtml = HtmlUtils.htmlEscape(html);
        System.out.println(eHtml);
        String ueHtml = HtmlUtils.htmlUnescape(eHtml);
        System.out.println(ueHtml);
    }
}
