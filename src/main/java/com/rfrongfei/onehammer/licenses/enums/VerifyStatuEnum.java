package com.rfrongfei.onehammer.licenses.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName VerifyStatuEnum
 * @Author Jxlsx
 * @Date 2019/12/16 上午12:29
 * @Version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum VerifyStatuEnum {
    SUCCESS(0),
    FAIL(1),
    WAIT(2),
    ;
    private Integer code;
}
