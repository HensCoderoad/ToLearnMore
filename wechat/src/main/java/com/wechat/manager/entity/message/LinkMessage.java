package com.wechat.manager.entity.message;

import com.wechat.manager.conts.MessageType;
import com.wechat.manager.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:40
 * @Description: 链接消息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkMessage extends BaseMessage {
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息描述
     */
    private String Description;
    /**
     * 消息链接
     */
    private String Url;

    @Override
    public String getMsgType() {
        return MessageType.LINK_MESSAGE;
    }
}
