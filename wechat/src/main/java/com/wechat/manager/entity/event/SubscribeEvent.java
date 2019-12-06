package com.wechat.manager.entity.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:45
 * @Description: 关注取消事件
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SubscribeEvent extends BaseEvent {
}
