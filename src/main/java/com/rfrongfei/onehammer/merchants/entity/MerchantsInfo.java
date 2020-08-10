package com.rfrongfei.onehammer.merchants.entity;

import com.baomidou.mybatisplus.annotation.*;


import java.math.BigDecimal;

import com.rfrongfei.onehammer.base.entity.Audit;
import com.rfrongfei.onehammer.base.entity.UserInfo;
import lombok.*;

/**
 * 商家信息
 *
 * @author Jxlsx
 * @email iamlive@aliyun.com
 * @date 2019-12-23 15:43:16
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("rf_merchants_info")
@KeySequence(value = "commonIdGenerator",clazz = String.class)
public class MerchantsInfo extends Audit implements UserInfo {

    public static final String ID = "id";
    public static final String AVG_DELIVERY_TIME = "avg_delivery_time";
    public static final String BGPIC = "bgpic";
    public static final String CATEGORY_ID = "category_id";
    public static final String DESCRIPTION = "description";
    public static final String DETAIL = "detail";
    public static final String END = "end";
    public static final String HEAD_PORTRAIT = "head_portrait";
    public static final String HOTLINE = "hotline";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String MERCHANTS_ID = "merchants_id";
    public static final String NOTICE = "notice";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";
    public static final String REGION_ID = "region_id";
    public static final String START = "start";
    public static final String STORE_NAME = "store_name";

    /**
     *
     */

    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 平均配送时间
     */
    @TableField(value = "avg_delivery_time")
    private Integer avgDeliveryTime;
    /**
     * 商户背景图
     */
    @TableField(value = "bgpic")
    private String bgpic;
    /**
     * 商户所属分类
     */
    @TableField(value = "category_id")
    private String categoryId;
    /**
     * 商户简介
     */
    @TableField(value = "description")
    private String description;
    /**
     * 商户详细地址
     */
    @TableField(value = "detail")
    private String detail;
    /**
     * 营业结束时间
     */
    @TableField(value = "end")
    private String end;
    /**
     * 商户头像
     */
    @TableField(value = "head_portrait")
    private String headPortrait;
    /**
     * 外卖热线
     */
    @TableField(value = "hotline")
    private String hotline;
    /**
     * 商户地址纬度
     */
    @TableField(value = "latitude")
    private BigDecimal latitude;
    /**
     * 商户地址经度
     */
    @TableField(value = "longitude")
    private BigDecimal longitude;
    /**
     * 用户ID
     */
    @TableField(value = "merchants_id")
    private String merchantsId;
    /**
     * 商户公告
     */
    @TableField(value = "notice")
    private String notice;
    /**
     * 商户密码
     */
    @TableField(value = "password")
    private String password;
    /**
     * 商户电话
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 商户区域
     */
    @TableField(value = "region_id")
    private String regionId;
    /**
     * 营业开始时间
     */
    @TableField(value = "start")
    private String start;
    /**
     * 商户店名
     */
    @TableField(value = "store_name")
    private String storeName;

    @Override
    public void setUserId(String userId) {
        this.setMerchantsId(userId);
    }

    @Override
    public String getUserId() {
        return this.getMerchantsId();
    }
}
