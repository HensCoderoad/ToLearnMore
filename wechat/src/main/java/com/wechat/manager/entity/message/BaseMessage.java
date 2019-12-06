package com.wechat.manager.entity.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:21
 * @Description: 消息实体基础类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseMessage {
    /**
     * 开发者微信号
     */
    private String ToUserName;
    /**
     * 发送方账号,即OpenID
     */
    private String FromUserName;
    /**
     * 消息创建时间
     */
    private Long CreateTime;
    /**
     * 消息id
     */
    private Long MsgId;

    public abstract String getMsgType();

}
