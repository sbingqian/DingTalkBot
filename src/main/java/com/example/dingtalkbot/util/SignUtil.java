package com.example.dingtalkbot.util;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;

public class SignUtil {

    public static String sign(Long timestamp, String secret) throws Exception{
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)),"UTF-8");
        System.out.println(sign);
        return sign;
    }

    public static String signWithSessionWebhook(String sessionWebhook,Long timestamp, String secret) throws Exception{
        return   sessionWebhook
                + "&timestamp="+timestamp
                + "&sign="+ SignUtil.sign(timestamp,"SECc4338480fd2c47cfed9587964dc824353d1aed52042da484f72eb3876327b213");

    }
}
