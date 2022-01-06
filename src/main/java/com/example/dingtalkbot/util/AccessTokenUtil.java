package com.example.dingtalkbot.util;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.example.dingtalkbot.constant.AppConstant;
import com.example.dingtalkbot.constant.UrlConstant;
import com.taobao.api.ApiException;

public class AccessTokenUtil {

    public static String getAccessToken() throws ApiException {
        DefaultDingTalkClient client = new DefaultDingTalkClient(UrlConstant.GET_ACCESS_TOKEN_URL);
        OapiGettokenRequest request = new OapiGettokenRequest();

        request.setAppkey(AppConstant.APP_KEY);
        request.setAppsecret(AppConstant.APP_SECRET);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);

        return response.getAccessToken();
    }
}
