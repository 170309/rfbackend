package com.rfrongfei.onehammer.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 订单评价图片
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
@TableName("rf_order_evaluate_pic")

public class OrderEvaluatePic extends Audit {

    public static final String ID = "id";
    public static final String EVALUATE_ID = "evaluate_id";
    public static final String PIC = "pic";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 评价ID
     */
    @TableField(value = "evaluate_id")
    private String evaluateId;
    /**
     * 图片
     */
    @TableField(value = "pic")
    private String pic;

}
