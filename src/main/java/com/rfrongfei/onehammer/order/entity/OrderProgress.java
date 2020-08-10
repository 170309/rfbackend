package com.rfrongfei.onehammer.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 订单流程
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
@TableName("rf_order_progress")

public class OrderProgress extends Audit {

    public static final String ID = "id";
    public static final String CONSUMER_ID = "consumer_id";
    public static final String ORDER_ID = "order_id";
    public static final String PROCESS_COMMENT = "process_comment";
    public static final String PROCESS_STATUS = "process_status";
    public static final String R_STATUS = "r_status";
    public static final String REASON = "reason";

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
     * 订单ID
     */
    @TableField(value = "order_id")
    private String orderId;
    /**
     * 进度备注内容
     */
    @TableField(value = "process_comment")
    private String processComment;
    /**
     * 进度
     */
    @TableField(value = "process_status")
    private Integer processStatus;
    /**
     * 状态
     */
    @TableField(value = "r_status")
    private Integer rStatus;
    /**
     * 理由
     */
    @TableField(value = "reason")
    private String reason;

}
