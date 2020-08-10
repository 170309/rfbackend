package com.rfrongfei.onehammer.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName CouponTypeEnum
 * @Author Jxlsx
 * @Date 2019/12/15 下午11:52
 * @Version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum CouponTypeEnum {
    DISCOUNT(0),
    REDUTION(1),
    ;
    private Integer code;
}
