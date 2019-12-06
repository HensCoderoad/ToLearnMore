package com.wechat.manager.entity.output;

import com.wechat.manager.conts.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 23:04
 * @Description: 语音回复消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VoiceOutputMessage extends BaseOutMessage {

    private Voice voice;

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_VOICE;
    }
}
