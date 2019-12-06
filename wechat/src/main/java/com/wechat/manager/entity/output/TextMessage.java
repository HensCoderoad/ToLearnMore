package com.wechat.manager.entity.output;

import com.wechat.manager.conts.MessageType;
import com.wechat.manager.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:56
 * @Description: 回复文本消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TextMessage extends BaseOutMessage{
    /**
     * 文本消息
     */
    private String Content;

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_TEXT;
    }
}
