package com.wechat.manager.entity.message;

import com.wechat.manager.conts.MessageType;
import com.wechat.manager.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:29
 * @Description: 普通文本消息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TextMessage extends BaseMessage {
    /**
     * 文本消息内容
     */
    private String Content;

    @Override
    public String getMsgType() {
        return MessageType.TEXT_MESSAGE;
    }
}
