package com.rfrongfei.onehammer.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName WithdrawalStatu
 * @Author Jxlsx
 * @Date 2019/12/15 下午4:22
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum WithdrawalStatusEnum {
    /**
     * 提现成功
     */
    ERROR(0,"失败"),
    /**
     * 提现失败
     */
    SUCCESS(1,"成功"),
    /**
     * 等待处理
     */
    WAIT(2,"等待处理"),
    ;
    private Integer code;
    private String type;
}
