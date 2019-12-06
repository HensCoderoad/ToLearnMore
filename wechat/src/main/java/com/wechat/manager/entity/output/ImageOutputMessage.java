package com.wechat.manager.entity.output;

import com.wechat.manager.conts.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 23:02
 * @Description: 图片内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ImageOutputMessage extends BaseOutMessage {

    private Image image;

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_IMAGE;
    }
}
