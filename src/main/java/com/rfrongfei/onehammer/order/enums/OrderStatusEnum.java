package com.rfrongfei.onehammer.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName OrderStatusEnum
 * @Author Jxlsx
 * @Date 2019/12/16 上午1:32
 * @Version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum OrderStatusEnum {
    /** 商家已接单 */
    MERCHANTS_ORDER(0),
    /** 骑手已接单 */
    DELIVERY_ORDER(1),
    /** 骑手已取货 */
    DELIVERY_ORDER_GOODS(2),
    /** 订单配送结束 */
    DELIVERY_ORDER_END(3),
    ;
    private Integer code;
}
