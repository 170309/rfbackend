package com.rfrongfei.onehammer.merchants.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 商家活动状态
 * @ClassName ActivityStatusEnum
 * @Author Jxlsx
 * @Date 2019/12/16 上午12:34
 * @Version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ActivityStatusEnum {
    ONLINE(0),
    OFFLINE(1),
    ;
    private Integer code;
}
