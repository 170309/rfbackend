package com.rfrongfei.onehammer.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 订单派送
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
@TableName("rf_order_delivery")

public class OrderDelivery extends Audit {

    public static final String ID = "id";
    public static final String DELIVERYMAN_ID = "deliveryman_id";
    public static final String END = "end";
    public static final String ORDER_ID = "order_id";
    public static final String START = "start";
    public static final String STATUS = "status";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 骑手ID
     */
    @TableField(value = "deliveryman_id")
    private String deliverymanId;
    /**
     * 结束时间
     */
    @TableField(value = "end")
    private Date end;
    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private String orderId;
    /**
     * 开始时间
     */
    @TableField(value = "start")
    private Date start;
    /**
     * 商家已接单0,骑手已接单1,骑手已取货2,订单配送结束3
     */
    @TableField(value = "status")
    private Integer status;

}
