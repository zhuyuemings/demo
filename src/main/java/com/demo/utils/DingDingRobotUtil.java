package com.demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class DingDingRobotUtil {

    private final static String UTF8 = "utf-8";

    private final static String DING_TALK_ROBOT_URL = "https://oapi.dingtalk.com/robot/send?access_token=ACCESS_TOKEN";

    private final static String MSG_TYPE = "msgtype";

    private final static String MSG_TYPE_TEXT = "text";

    private final static String CONTENT = "content";

    private final static String TEXT = "text";

    /**
     * 发送钉钉机器人消息
     *
     * @param accessToken 访问凭据
     * @param msg         消息内容
     * @return String 返回结果
     */
    public static String sendDingTalk(String accessToken, String msg) {
        String result = null;
        HttpClient httpClient = HttpClients.createDefault();
        String url = DING_TALK_ROBOT_URL.replace("ACCESS_TOKEN", accessToken);
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        StringEntity stringEntity = new StringEntity(getMsgJsonBody(msg), UTF8);
        httpPost.setEntity(stringEntity);
        try {
            HttpResponse httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 获取消息体Json字符串
     *
     * @param msg 消息内容
     * @return String 消息体Json字符串
     */
    private static String getMsgJsonBody(String msg) {
        JSONObject text = new JSONObject();
        text.put(CONTENT, msg);
        JSONObject obj = new JSONObject();
        obj.put(MSG_TYPE, MSG_TYPE_TEXT);
        obj.put(TEXT, text);
        return obj.toJSONString();
    }

    /**
     * Main方法
     *
     * @param args
     */
    public static void main(String[] args) {
        String accessToken = "330097df6bc937f721446d94572aae84d243b4ecb7aea94fac6e1f6ce25efd3d";
        String msg = "hey,you!";
        System.out.println(sendDingTalk(accessToken, msg));
    }
}
