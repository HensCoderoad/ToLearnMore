package com.spring.cloud.util;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
/**
 * ①在输出前端页面的时候调用TokenTools.createToken方法，会把本次生成的token放入session中。
 *
 * ②然后在前端页面提交数据时从session中获取token，然后添加到要提交的数据中。
 *
 * ③服务端接受数据后调用judgeTokenIsEqual方法判断两个token是否一致，如果不一致则返回，不进行处理。
 *
 * 备注：tokenClientkey和tokenServerkey自定义，调用judgeTokenIsEqual方法时的tokenClientkey一定要与前端页面的key一致。
 * token通用工具类
 * @author : Hens
 * @date : 2019/9/29 17:56
 */
public class TokenTools {

    public static void createToken(HttpServletRequest request, String tokenServerkey){
        String token = TokenProccessor.getInstance().makeToken();
        request.getSession().setAttribute(tokenServerkey, token);
    }
    /**
     * 移除token
     * @param request
     * @param tokenServerkey
     */
    public static void removeToken(HttpServletRequest request,String tokenServerkey){
        request.getSession().removeAttribute(tokenServerkey);
    }

    /**
     * 判断请求参数中的token是否和session中一致
     * @param request
     * @param tokenClientkey
     * @param tokenServerkey
     * @return
     */
    public static boolean judgeTokenIsEqual(HttpServletRequest request,String tokenClientkey,String tokenServerkey){
        String token_client = request.getParameter(tokenClientkey);
        if(StringUtils.isEmpty(token_client)){
            return false;
        }
        String token_server = (String) request.getSession().getAttribute(tokenServerkey);
        if(StringUtils.isEmpty(token_server)){
            return false;
        }

        if(!token_server.equals(token_client)){
            return false;
        }

        return true;
    }

}
