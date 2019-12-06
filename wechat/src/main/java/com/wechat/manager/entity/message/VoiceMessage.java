package com.wechat.manager.entity.message;

import com.wechat.manager.conts.MessageType;
import com.wechat.manager.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:31
 * @Description: 语音消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VoiceMessage extends BaseMessage {
    /**
     * 语音消息媒体id
     */
    private String MediaId;
    /**
     * 语音格式
     */
    private String Format;
    /**
     * 语音识别结果
     */
    private String Recognition;

    @Override
    public String getMsgType() {
        return MessageType.VOICE_MESSAGE;
    }
}
