package com.rfrongfei.onehammer.base.util;

public class RedisKeyHelper {

    public static final String smsCodePrefix = "SMS_CODE_";

    // 电话号码验证码key
    public static String smsCode(String phone,Integer userType){
        return smsCodePrefix + userType + phone;
    }

}