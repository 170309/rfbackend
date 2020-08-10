package com.rfrongfei.onehammer.common.entity;

import com.baomidou.mybatisplus.annotation.*;


import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import com.rfrongfei.onehammer.common.enums.LoginStatus;
import com.rfrongfei.onehammer.common.enums.UserType;
import lombok.*;

/**
 * 用户主表
 *
 * @author Jxlsx
 * @email iamlive@aliyun.com
 * @date 2019-12-23 15:33:54
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("rf_user")
@KeySequence(value = "commonIdGenerator",clazz = String.class)
public class User extends Audit {

    public static final String ID = "id";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String LOGIN_STATUS = "login_status";
    public static final String USER_ID = "user_id";
    public static final String USER_TYPE = "user_type";
    public static final String PHONE = "phone";

    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * token
     */
    @TableField(value = "access_token")
    private String accessToken;
    /**
     * 当前的登录状态:0已登录，1未登录
     */
    @TableField(value = "login_status")
    private Integer loginStatus;
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 用户类型
     */
    @TableField(value = "user_type")
    private Integer userType;

    /** 电话号码 */
    @TableField(value = "phone")
    private String phone;

}
