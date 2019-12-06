package com.wechat.manager.common.wechat;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Hens
 * @DateTime: 2019/12/4 8:49
 * @Description: 系统参数
 */
@Component
@Data
public class Parameter {
    /**
     * 小程序appid
     */
    @Value("${paramter.appid}")
    private static String APPID;
    /**
     * 小程序appSecrect
     */
    @Value("${paramter.appsecrect}")
    private static String APP_SECRECT;
    /**
     * 获取地址
     */
    @Value("${paramter.tokenUrl}")
    private static String ACCESS_TOKEN_URL;
}
