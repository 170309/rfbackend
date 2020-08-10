package com.rfrongfei.onehammer.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 用户充值记录
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
@TableName("rf_user_recharge_record")

public class UserRechargeRecord extends Audit {

    public static final String ID = "id";
    public static final String RECHARGE = "recharge";
    public static final String USER_ID = "user_id";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 充值金额
     */
    @TableField(value = "recharge")
    private BigDecimal recharge;
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;

}
