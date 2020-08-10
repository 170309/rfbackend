package com.rfrongfei.onehammer.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 订单支付
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
@TableName("rf_order_pay")

public class OrderPay extends Audit {

    public static final String ID = "id";
    public static final String CONSUMER_ID = "consumer_id";
    public static final String MERCHANTS_ID = "merchants_id";
    public static final String ORDER_ID = "order_id";
    public static final String PAY_AMOUNT = "pay_amount";
    public static final String STATUS = "status";

    /**
     *
     */

    @TableId
    private Long id;
    /**
     * 用户ID
     */
    @TableField(value = "consumer_id")
    private String consumerId;
    /**
     * 商户ID
     */
    @TableField(value = "merchants_id")
    private String merchantsId;
    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private String orderId;
    /**
     * 支付金额
     */
    @TableField(value = "pay_amount")
    private BigDecimal payAmount;
    /**
     * 支付状态0成功，1失败，2等待支付
     */
    @TableField(value = "status")
    private Integer status;

}
