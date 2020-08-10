package com.rfrongfei.onehammer.user.entity;

import com.baomidou.mybatisplus.annotation.*;


import com.rfrongfei.onehammer.base.entity.Audit;
import com.rfrongfei.onehammer.base.entity.UserInfo;
import lombok.*;

/**
 * 消费者信息
 *
 * @author Jxlsx
 * @email iamlive@aliyun.com
 * @date 2019-12-23 15:43:17
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("rf_consumer_info")
@KeySequence(value = "commonIdGenerator",clazz = String.class)
public class ConsumerInfo extends Audit implements UserInfo {

    public static final String ID = "id";
    public static final String ACCOUNT = "account";
    public static final String CONSUMER_ID = "consumer_id";
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";
    public static final String USER_NICKNAME = "user_nickname";
    public static final String USER_PORTRAIT = "user_portrait";

    /**
     *
     */

    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;
    /**
     * 用户ID
     */
    @TableField(value = "consumer_id")
    private String consumerId;
    /**
     * email
     */
    @TableField(value = "email")
    private String email;
    /**
     * 用户名
     */
    @TableField(value = "name")
    private String name;
    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 用户手机号
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 用户昵称
     */
    @TableField(value = "user_nickname")
    private String userNickname;
    /**
     * 用户头像
     */
    @TableField(value = "user_portrait")
    private String userPortrait;

    @Override
    public void setUserId(String userId) {
        this.setConsumerId(userId);
    }

    @Override
    public String getUserId() {
        return this.getConsumerId();
    }
}
