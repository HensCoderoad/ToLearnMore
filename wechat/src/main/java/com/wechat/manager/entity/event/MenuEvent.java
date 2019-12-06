package com.wechat.manager.entity.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:48
 * @Description: 自定义菜单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MenuEvent extends BaseEvent{
    /**
     * 事件key,与自定义菜单接口key对应
     */
    private String EventKey;
}
