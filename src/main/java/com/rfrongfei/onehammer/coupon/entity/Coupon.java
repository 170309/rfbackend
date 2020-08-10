package com.rfrongfei.onehammer.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 优惠券
 *
 * @author Jxlsx
 * @email iamlive@aliyun.com
 * @date 2019-12-23 15:33:55
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("rf_coupon")

public class Coupon extends Audit {

    public static final String ID = "id";
    public static final String COUNT = "count";
    public static final String COUPON_ID = "coupon_id";
    public static final String DISCOUNT = "discount";
    public static final String END = "end";
    public static final String REDUTION = "redution";
    public static final String REDUTION_AMOUNT = "redution_amount";
    public static final String START = "start";
    public static final String STATUS = "status";
    public static final String TYPE = "type";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 优惠券数量
     */
    @TableField(value = "count")
    private Integer count;
    /**
     * 优惠券ID
     */
    @TableField(value = "coupon_id")
    private String couponId;
    /**
     * 折扣数
     */
    @TableField(value = "discount")
    private BigDecimal discount;
    /**
     * 优惠券过期时间
     */
    @TableField(value = "end")
    private Date end;
    /**
     * 满减基准金额
     */
    @TableField(value = "redution")
    private BigDecimal redution;
    /**
     * 满减金额
     */
    @TableField(value = "redution_amount")
    private BigDecimal redutionAmount;
    /**
     * 优惠券发布时间
     */
    @TableField(value = "start")
    private Date start;
    /**
     * 优惠券状态:0可用，1不可用
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 优惠券类型：满减，折扣
     */
    @TableField(value = "type")
    private Integer type;

}
