package com.rfrongfei.onehammer.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName UseStatusEnum
 * @Author Jxlsx
 * @Date 2019/12/15 下午11:55
 * @Version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UseStatusEnum {
    USED(0,"未使用"),
    UNUSED(1,"已使用"),
    ;
    private Integer code;
    private String description;
}
