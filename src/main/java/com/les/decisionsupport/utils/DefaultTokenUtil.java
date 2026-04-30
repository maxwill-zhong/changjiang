package com.les.decisionsupport.utils;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 用来后台静默登录的工具类，1天刷新一次token
 */
@Slf4j
@Component
public class DefaultTokenUtil {
    private volatile static String token = null;
    private volatile static HttpHeaders headers = null;
    private static String username;
    private static String password;
    private static RestTemplate restTemplate;

    public synchronized static HttpHeaders getDefaultHeader() {
        if (headers == null) {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.set("OAuth", DefaultTokenUtil.getToken());
            headers = requestHeaders;
        }
        return headers;
    }

    public synchronized static String getToken() {
        try {
            if (token == null) {
                JSONObject jsonObject = JSON.parseObject(restTemplate.postForObject("http://zuul/oauth/?username={1}&password={2}", null, String.class, username, password));
                if (jsonObject != null && jsonObject.getBooleanValue("success")) {
                    token = jsonObject.getString("data");
                    log.info("后台静默登录获取token: " + token);
                }
            }
            return token;
        } catch (Exception e) {
            log.error(ExceptionUtils.getRootCauseMessage(e));
            ExceptionUtils.getRootCause(e).printStackTrace();
        }
        return null;
    }

    @Value("${default.username:admin}")
    public void setUsername(String username) {
        DefaultTokenUtil.username = username;
    }

    @Value("${default.password:111111}")
    public void setPassword(String password) {
        DefaultTokenUtil.password = password;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        DefaultTokenUtil.restTemplate = restTemplate;
    }

    @Scheduled(cron = "${refreshRate:0 0 0 * * ?}")
    public synchronized void clearToken() {
        if (token != null) {
            token = null;
            headers = null;
            log.info("定时清除token缓存");
        }
    }
}
