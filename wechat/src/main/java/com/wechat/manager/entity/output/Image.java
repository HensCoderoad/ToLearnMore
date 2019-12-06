package com.wechat.manager.entity.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 23:01
 * @Description: 图片回复消息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    /**
     * 通过上传多媒体文件，得到id
     */
    private String MediaId;
}
