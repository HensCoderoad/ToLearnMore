package com.wechat.manager.common.wechat;

import lombok.Data;

/**
 * @author: Hens
 * @DateTime: 2019/12/4 8:54
 * @Description: 小程序token
 */
@Data
public class AccessToken {

    private String access_token;

    private Long expires_in;
}
