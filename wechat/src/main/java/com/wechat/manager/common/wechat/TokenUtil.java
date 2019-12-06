package com.wechat.manager.common.wechat;

import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.wechat.manager.common.wechat.HttpRequestUtil;
import sun.reflect.annotation.ExceptionProxy;

/**
 * @author: Hens
 * @DateTime: 2019/12/4 9:12
 * @Description: 获取token
 */
@Component
public class TokenUtil {
    /**
     * 小程序appid
     */
    @Value("${paramter.appid}")
    private String APPID;
    /**
     * 小程序appSecrect
     */
    @Value("${paramter.appsecrect}")
    private String APP_SECRECT;
    /**
     * 获取地址
     */
    @Value("${paramter.tokenUrl}")
    private String ACCESS_TOKEN_URL;

    Logger logger = LoggerFactory.getLogger(TokenUtil.class);

    public AccessToken getToken() {
        String url = ACCESS_TOKEN_URL + "?grant_type=client_credential&appid="+APPID+"&secret="+APP_SECRECT;
        JSONObject json = HttpRequestUtil.httpsRequest(url, "GET", null);
        AccessToken token = null;
        if(json != null){
            try {
                token = new AccessToken();
                token.setAccess_token(json.getString("access_token"));
                token.setExpires_in(json.getLong("expires_in"));
            }catch (Exception e){
                token = null;
                logger.error("发起请求获取微信token异常");
            }
        }else {
            token = null;
            logger.error("获取token失败");
        }
        return token;
    }
}
