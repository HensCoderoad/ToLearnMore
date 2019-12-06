package com.wechat.manager.entity.output;

import com.wechat.manager.conts.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 23:12
 * @Description: 图文回复消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticlesOutputMessage extends BaseOutMessage {
    /**
     * 图文消息个数，限制10
     */
    private int ArticleCount;
    /**
     * 多条图文，默认第一个为大图
     */
    private List<Articles> Articles;

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_NEWS;
    }
}
