package com.wechat.manager.entity.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:42
 * @Description: 基础事件
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEvent {
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
     * 消息类型
     */
    private String MsgType;
    /**
     * 事件类型
     */
    private String Event;



}
