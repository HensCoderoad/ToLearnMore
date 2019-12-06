package com.wechat.manager.entity.message;

import com.wechat.manager.conts.MessageType;
import com.wechat.manager.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:35
 * @Description: 视频消息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VideoMessage extends BaseMessage {
    /**
     * 视频消息媒体Id
     */
    private String MediaId;
    /**
     * 视频消息
     */
    private String ThumbMediaId;

    @Override
    public String getMsgType() {
        return MessageType.VOICE_MESSAGE;
    }
}
