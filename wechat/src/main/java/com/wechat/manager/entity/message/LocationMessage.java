package com.wechat.manager.entity.message;

import com.wechat.manager.conts.MessageType;
import com.wechat.manager.util.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:38
 * @Description: 定位消息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class LocationMessage extends BaseMessage {
    /**
     * 地理位置维度
     */
    private String Location_X;
    /**
     * 经度
     */
    private String Location_Y;
    /**
     * 缩放大小
     */
    private Long Scale;
    /**
     * 位置信息
     */
    private String Label;

    @Override
    public String getMsgType() {
        return MessageType.POSOTION_MESSAGE;
    }
}
