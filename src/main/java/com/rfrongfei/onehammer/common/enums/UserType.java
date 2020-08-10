package com.rfrongfei.onehammer.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.rfrongfei.onehammer.base.enums.OnehammerEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserType implements OnehammerEnum {
    CONSUMER(0,"用户"),
    MERCHANTS(1,"商家"),
    DELIVERYMAN(2,"骑手"),
    ;

    @EnumValue
    private Integer code;
    @JsonValue
    private String desc;

}
