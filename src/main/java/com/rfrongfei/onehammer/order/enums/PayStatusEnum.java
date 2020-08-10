package com.rfrongfei.onehammer.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName PayStatusEnum
 * @Author Jxlsx
 * @Date 2019/12/16 上午1:33
 * @Version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum PayStatusEnum {
    /** 已支付 */
    PAID(0),
    NOT_PAID(1),
    WAIT(2)
    ;
    private Integer code;
}
