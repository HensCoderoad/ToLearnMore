package com.wechat.manager.common.wechat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author: Hens
 * @DateTime: 2019/12/4 9:37
 * @Description: 定时获取token
 */
@Component
public class AccessTokenTask {
    Logger logger = LoggerFactory.getLogger(AccessTokenTask.class);
    @Autowired
    private TokenUtil tokenUtil;

    @Scheduled(initialDelay = 1000, fixedDelay = 7000*1000)
    public void getAccessToken(){
        try{
            String token = tokenUtil.getToken().getAccess_token();
            logger.info("获取到的微信access_token:{}",token);
            // token存储到中控服务器

        }catch(Exception e){
            logger.error("获取微信access_token出错,信息如下");
            e.printStackTrace();
            this.getAccessToken();
        }

    }
}
