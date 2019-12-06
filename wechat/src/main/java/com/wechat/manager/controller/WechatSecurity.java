package com.wechat.manager.controller;

import com.wechat.manager.conts.MessageType;
import com.wechat.manager.util.DistributeUtil;
import com.wechat.manager.util.MessageUtil;
import com.wechat.manager.util.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


/**
 * @author: Hens
 * @DateTime: 2019/12/3 20:35
 * @Description: 验证服务
 */
@Controller
@RequestMapping("/wechat")
public class WechatSecurity {
    private static Logger logger = Logger.getLogger(WechatSecurity.class);

    @RequestMapping(value = "security", method = RequestMethod.GET)
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse response,
                      @RequestParam(value = "signature", required = true) String signature,
                      @RequestParam(value = "timestamp", required = true) String timestamp,
                      @RequestParam(value = "nonce", required = true) String nonce,
                      @RequestParam(value = "echostr", required = true) String echostr){
            try {
                if(SignUtil.checkSignature(signature, timestamp, nonce)){
                    PrintWriter out = response.getWriter();
                    out.print(echostr);
                    out.close();
                }else {
                    logger.info("验证到非法请求");
                }
            } catch (IOException e) {
                logger.error(e, e);
            }
    }

    @RequestMapping(value = "security", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        // 确认请求来自微信服务器，不是则返回
        if(!SignUtil.checkSignature(signature,timestamp,nonce)){
            response.getWriter().write("");
            return;
        }
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            Map<String, String> map = MessageUtil.parseXML(request);
            String msgType = map.get("MsgType");
            String xml = null;
            if(MessageType.REQ_MESSAGE_TYPE_EVENT.equals(msgType)){
                xml = DistributeUtil.parseEvent(map);
            }else{
                xml = DistributeUtil.parseMessage(map);
            }
            response.getWriter().write(xml);
        } catch (Exception e) {
            response.getWriter().write("");
            logger.error(e, e);
        }
    }
}
