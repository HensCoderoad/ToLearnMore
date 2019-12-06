package com.wechat.manager.util;

import com.wechat.manager.conts.MessageType;
import com.wechat.manager.entity.output.Articles;
import com.wechat.manager.entity.output.ArticlesOutputMessage;
import com.wechat.manager.entity.output.TextMessage;

import java.util.*;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 23:27
 * @Description: 事件和消息分发
 */
public class DistributeUtil {
    // 处理微信发来的请求 map 消息业务处理分发
    public static String parseMessage(Map<String, String> map) {
        String respXml = null;
        try {
            // 发送方帐号
            String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            // 取得消息类型
            String MsgType = map.get("MsgType");
            // 发现直接把要返回的信息直接封装成replyMap集合，然后转换成 xml文件，是不是实体类可以不用了
            Map<String, String> replyMap = new HashMap<String, String>();
            replyMap.put("ToUserName", fromUserName);
            replyMap.put("FromUserName", toUserName);
            replyMap.put("CreateTime", String.valueOf(System.currentTimeMillis()));
            if (MsgType.equals(MessageType.TEXT_MESSAGE)) {
                // 封装文本返回消息
                TextMessage textMessage = new TextMessage();
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setContent("您发送的是文本消息");
                textMessage.getMsgType();
//                 respXml = ReplyMessageUtil.sendTextMessage(textMessage);

                // 用map集合封装
                replyMap.put("MsgType", MessageType.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是文本消息");
                respXml = XmlUtil.xmlFormat(replyMap, true);

            } else if (MsgType.equals(MessageType.IMAGE_MESSAGE)) {
                // 这里回复图片 或者图文消息 以图文消息为例
                ArticlesOutputMessage message = new ArticlesOutputMessage();
                message.setToUserName(fromUserName);
                message.setFromUserName(toUserName);
                message.setCreateTime(System.currentTimeMillis());
                message.getMsgType();

                Articles article = new Articles();
                // 图文消息的描述
                article.setDescription("图文消息 ");
                // 图文消息图片地址
                article.setPicUrl("https://p4.ssl.cdn.btime.com/dmfd/192_108_/t019d0b65e33000f8a0.jpg?size=458x240");
                // 图文消息标题
                article.setTitle("图文消息 ");
                // 图文 url 链接
                article.setUrl("http://www.baidu.com");
                List<Articles> list = new ArrayList<Articles>();
                // 这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个
                list.add(article);
                // Articles！
                message.setArticleCount(list.size());
                message.setArticles(list);
                respXml = ReplyMessageUtil.sendImageTextMessage(message);
            } else if (MsgType.equals(MessageType.VOICE_MESSAGE)) {
                // 以下方式根据需要来操作
                replyMap.put("MsgType", MessageType.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是语音消息");
                respXml = XmlUtil.xmlFormat(replyMap, true);
            } else if (MsgType.equals(MessageType.VIDEO_MESSAGE)) {
                replyMap.put("MsgType", MessageType.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是视频消息");
                respXml = XmlUtil.xmlFormat(replyMap, true);
            } else if (MsgType.equals(MessageType.SHORTVIDEO_MESSAGE)) {
                replyMap.put("MsgType", MessageType.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是小视频消息");
                respXml = XmlUtil.xmlFormat(replyMap, true);
            } else if (MsgType.equals(MessageType.POSOTION_MESSAGE)) {
                replyMap.put("MsgType", MessageType.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是地理位置消息");
                respXml = XmlUtil.xmlFormat(replyMap, true);
            } else if (MsgType.equals(MessageType.LINK_MESSAGE)) {
                replyMap.put("MsgType", MessageType.RESP_MESSAGE_TYPE_TEXT);
                replyMap.put("Content", "您发送的是链接消息");
                respXml = XmlUtil.xmlFormat(replyMap, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }

    // 事件消息业务分发
    public static String parseEvent(Map<String, String> map) {
        String respXml = null;
        try {
            // 发送方帐号
            String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            // 取得消息类型
            String MsgType = map.get("MsgType");
            //获取事件类型
            String eventType = map.get("Event");
            // 发现直接把要返回的信息直接封装成replyMap集合，然后转换成 xml文件，是不是实体类可以不用了
            Map<String, String> replyMap = new HashMap<String, String>();
            replyMap.put("ToUserName", fromUserName);
            replyMap.put("FromUserName", toUserName);
            replyMap.put("CreateTime", String.valueOf(System.currentTimeMillis()));
            // 关注
            if (eventType.equals(MessageType.EVENT_TYPE_SUBSCRIBE)) {
                // 用map集合封装
                replyMap.put("MsgType", MessageType.RESP_MESSAGE_TYPE_TEXT);
//                replyMap.put("Content", MessageType.menuText());
                respXml = XmlUtil.xmlFormat(replyMap, true);
            }
            // 取消关注
            if (eventType.equals(MessageType.EVENT_TYPE_UNSUBSCRIBE)) {

            }
            // 用户已关注时的扫描带参数二维码
            if (eventType.equals(MessageType.EVENT_TYPE_SCAN)) {

            }
            // 上报地理位置
            if (eventType.equals(MessageType.EVENT_TYPE_LOCATION)) {

            }
            // 自定义菜单
            if (eventType.equals(MessageType.EVENT_TYPE_CLICK)) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }
}
