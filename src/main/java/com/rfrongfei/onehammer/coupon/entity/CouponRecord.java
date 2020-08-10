package com.rfrongfei.onehammer.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 优惠券关联记录
 *
 * @author Jxlsx
 * @email iamlive@aliyun.com
 * @date 2019-12-23 15:33:54
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("rf_coupon_record")
public class CouponRecord extends Audit {

    public static final String ID = "id";
    public static final String COUNT = "count";
    public static final String COUPON_ID = "coupon_id";
    public static final String STATUS = "status";
    public static final String USER_ID = "user_id";

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
     * 使用状态
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;

}
