package com.rfrongfei.onehammer.merchants.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 商家活动
 *
 * @author Jxlsx
 * @email iamlive@aliyun.com
 * @date 2019-12-23 15:43:17
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("rf_merchants_activity")

public class MerchantsActivity extends Audit {

    public static final String ID = "id";
    public static final String ACTIVITY_ID = "activity_id";
    public static final String MERCHANTS_ID = "merchants_id";
    public static final String REDUTION = "redution";
    public static final String STATUS = "status";
    public static final String TARGET = "target";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 商家活动ID
     */
    @TableField(value = "activity_id")
    private String activityId;
    /**
     * 商家ID
     */
    @TableField(value = "merchants_id")
    private String merchantsId;
    /**
     * 优惠金额
     */
    @TableField(value = "redution")
    private BigDecimal redution;
    /**
     * 状态:1可用，0不可用
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 满足的消费金额
     */
    @TableField(value = "target")
    private BigDecimal target;

}
