package com.rfrongfei.onehammer.common.input;

import lombok.Data;

@Data
public class UserInput {
    /** 用户电话号码 */
    private String phone;
    /** 用户验证码 */
    private String smsCode;
    /** 用户密码 */
    private String password;
    /** 用户类型 */
    private Integer userType;
    /** 用户ID */
    private String userId;
}
