package com.wechat.manager.entity.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author: Hens
 * @DateTime: 2019/12/3 22:45
 * @Description: 扫描带二维码事件
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class QRCodeEvent extends BaseEvent {
    /**
     * 事件key值
     */
    private String EventKey;
    /**
     * 换取二维码图片
     */
    private String Ticket;
}
