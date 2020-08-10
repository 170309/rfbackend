package com.rfrongfei.onehammer.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 订单退款
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
@TableName("rf_order_refund")

public class OrderRefund extends Audit {

    public static final String ID = "id";
    public static final String CONSUMER_ID = "consumer_id";
    public static final String END = "end";
    public static final String ORDER_ID = "order_id";
    public static final String POUNDAGE = "poundage";
    public static final String REASON = "reason";
    public static final String REFUND_AMOUNT = "refund_amount";
    public static final String START = "start";
    public static final String STATUS = "status";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 用户ID
     */
    @TableField(value = "consumer_id")
    private String consumerId;
    /**
     * 退款完成时间
     */
    @TableField(value = "end")
    private Date end;
    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private String orderId;
    /**
     * 协商扣除的手续费
     */
    @TableField(value = "poundage")
    private BigDecimal poundage;
    /**
     * 退款理由
     */
    @TableField(value = "reason")
    private String reason;
    /**
     * 退款金额
     */
    @TableField(value = "refund_amount")
    private BigDecimal refundAmount;
    /**
     * 商家处理时间
     */
    @TableField(value = "start")
    private Date start;
    /**
     * 退款状态
     */
    @TableField(value = "status")
    private Integer status;

}
