package com.rfrongfei.onehammer.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName IntegralType
 * @Author Jxlsx
 * @Date 2019/12/15 下午12:29
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum IntegralTypeEnum {
    ORDER(0,"订单消费增加"),
    RECHARGE(1,"充值消费增加"),
    ;
    private Integer code;
    private String type;
}
