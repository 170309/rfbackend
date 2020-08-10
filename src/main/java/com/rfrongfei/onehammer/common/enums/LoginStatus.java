package com.rfrongfei.onehammer.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.rfrongfei.onehammer.base.enums.OnehammerEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum LoginStatus implements OnehammerEnum {
    LOGIN(0,"已登陆"),
    UN_LOGIN(1,"未登陆"),
    ;
    @EnumValue
    private Integer code;
    @JsonValue
    private String desc;

}
