package com.wechat.manager.entity.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 23:05
 * @Description: 视频消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    /**
     * 媒体文件id
     */
    private String MediaId;
    /**
     * 缩略图媒体id
     */
    private String ThumbMediaId;
    /**
     * 视频消息标题
     */
    private String Title;
    /**
     * 视频消息描述
     */
    private String Description;
}
