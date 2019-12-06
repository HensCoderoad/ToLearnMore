package com.wechat.manager.common.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Hens
 * @DateTime: 2019/12/4 9:10
 * @Description: 定时获取token
 */
@Component
public class WechatAccessTokenTask {

    private Logger logger = LoggerFactory.getLogger(WechatAccessTokenTask.class);

    public AccessToken getToken(String appid, String appSecrect){
        AccessToken token = null;

        return null;
    }
}
