package com.rfrongfei.onehammer.deliveryman.entity;

import com.baomidou.mybatisplus.annotation.*;

import com.rfrongfei.onehammer.base.entity.Audit;
import com.rfrongfei.onehammer.base.entity.UserInfo;
import lombok.*;

/**
 * 骑手信息
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
@TableName("rf_deliveryman_info")
@KeySequence(value = "commonIdGenerator",clazz = String.class)
public class DeliverymanInfo extends Audit implements UserInfo {

    public static final String ID = "id";
    public static final String DELIVERYMAN_ID = "deliveryman_id";
    public static final String HEAD_PORTRAIT = "head_portrait";
    public static final String NAME = "name";
    public static final String NICKNAME = "nickname";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";
    public static final String STATUS = "status";

    /**
     *
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 用户ID
     */
    @TableField(value = "deliveryman_id")
    private String deliverymanId;
    /**
     * 头像
     */
    @TableField(value = "head_portrait")
    private String headPortrait;
    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;
    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;
    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 工作状态:0开工中，1休息
     */
    @TableField(value = "status")
    private Integer status;

    @Override
    public void setUserId(String userId) {
        this.setDeliverymanId(userId);
    }

    @Override
    public String getUserId() {
        return this.getDeliverymanId();
    }
}
