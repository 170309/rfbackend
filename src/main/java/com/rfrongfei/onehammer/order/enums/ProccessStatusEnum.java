package com.rfrongfei.onehammer.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @ClassName ProccessStatusEnum
 * @Author Jxlsx
 * @Date 2019/12/16 上午1:59
 * @Version 1.0
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ProccessStatusEnum {
    /** 等待受理 */
    WAIT(0),
    /** 商家受理 */
    MERCHANTS_ACCEPT(1),
    /** 发起流程 */
    START_PROCCESS(2),
    /** 流程结束 */
    PROCCESS_END(3),
    ;
    private Integer code;
}
