package com.wechat.manager.entity.output;

import com.wechat.manager.conts.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 23:07
 * @Description: 回复视频消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoOutputMessage extends BaseOutMessage {

    private Video video;

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_VIDEO;
    }
}
