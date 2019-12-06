package com.wechat.manager.entity.message;

import com.wechat.manager.conts.MessageType;
import com.wechat.manager.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:37
 * @Description: 小视频消息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ShortVideoInputMessage extends BaseMessage {
    /**
     * 视频消息媒体id
     */
    private String MediaId;
    /**
     * 视频消息
     */
    private String ThumbMediaId;

    @Override
    public String getMsgType() {
        return MessageType.SHORTVIDEO_MESSAGE;
    }
}
