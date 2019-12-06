package com.wechat.manager.entity.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:49
 * @Description: 回复消息基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseOutMessage {
    /**
     * 接收方账号OpenId
     */
    private String ToUserName;
    /**
     * 开发者微信号
     */
    private String FromUserName;
    /**
     * 创建时间
     */
    private Long CreateTime;

    public abstract String getMsgType();
}
