package com.rfrongfei.onehammer.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 订单评价
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
@TableName("rf_order_evaluate")

public class OrderEvaluate extends Audit {

    public static final String ID = "id";
    public static final String CONSUMER_ID = "consumer_id";
    public static final String CONTENT = "content";
    public static final String ORDER_ID = "order_id";
    public static final String STAR = "star";

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
     * 评价内容
     */
    @TableField(value = "content")
    private String content;
    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private String orderId;
    /**
     * 点赞数
     */
    @TableField(value = "star")
    private Integer star;

}
