package com.wechat.manager.entity.message;

import com.wechat.manager.conts.MessageType;
import com.wechat.manager.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.awt.*;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:30
 * @Description: 图片消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ImageMessage extends BaseMessage {
    /**
     * 图片链接
     */
    private String PicUrl;
    /**
     * 图片消息媒体id
     */
    private String MediaId;

    @Override
    public String getMsgType() {
        return MessageType.IMAGE_MESSAGE;
    }
}
