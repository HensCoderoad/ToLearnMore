package com.wechat.manager.entity.output;

import com.wechat.manager.conts.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 23:09
 * @Description: 回复音乐消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MusicOutputMessage extends BaseOutMessage {

    private Music music;

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_MUSIC;
    }
}
