package com.rfrongfei.onehammer.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 订单
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
@TableName("rf_order")

public class Order extends Audit {

    public static final String ID = "id";
    public static final String ACTIVITY_AMOUNT = "activity_amount";
    public static final String ACTIVITY_ID = "activity_id";
    public static final String ADDRESS_ID = "address_id";
    public static final String COMMENT = "comment";
    public static final String CONSUMER_ID = "consumer_id";
    public static final String COUPON_AMOUNT = "coupon_amount";
    public static final String COUPON_ID = "coupon_id";
    public static final String DELIVERY_AMOUNT = "delivery_amount";
    public static final String MERCHANTS_ID = "merchants_id";
    public static final String ORDER_ID = "order_id";
    public static final String PAY_AMOUNT = "pay_amount";
    public static final String TOTAL = "total";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 商家活动优惠金额
     */
    @TableField(value = "activity_amount")
    private BigDecimal activityAmount;
    /**
     * 商家活动ID
     */
    @TableField(value = "activity_id")
    private String activityId;
    /**
     * 用户地址
     */
    @TableField(value = "address_id")
    private String addressId;
    /**
     * 订单备注
     */
    @TableField(value = "comment")
    private String comment;
    /**
     * 用户ID
     */
    @TableField(value = "consumer_id")
    private String consumerId;
    /**
     * 订单优惠总金额
     */
    @TableField(value = "coupon_amount")
    private BigDecimal couponAmount;
    /**
     * 优惠券ID
     */
    @TableField(value = "coupon_id")
    private String couponId;
    /**
     * 订单配送金额
     */
    @TableField(value = "delivery_amount")
    private BigDecimal deliveryAmount;
    /**
     * 商家ID
     */
    @TableField(value = "merchants_id")
    private String merchantsId;
    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private String orderId;
    /**
     * 订单实付金额
     */
    @TableField(value = "pay_amount")
    private BigDecimal payAmount;
    /**
     * 订单总价
     */
    @TableField(value = "total")
    private BigDecimal total;

}
