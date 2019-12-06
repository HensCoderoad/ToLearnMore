package com.wechat.manager.entity.output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 23:10
 * @Description: 回复图文
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Articles {
    /**
     * 标题
     */
    private String Title;
    /**
     * 描述
     */
    private String Description;
    /**
     * 图片链接，支持JPG PNG格式，效果640*320 小图80*80
     */
    private String PicUrl;
    /**
     * 点击跳转路径
     */
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
