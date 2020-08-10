package com.rfrongfei.onehammer.user.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 用户提现记录
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
@TableName("rf_user_withdrawal_record")

public class UserWithdrawalRecord extends Audit {

    public static final String ID = "id";
    public static final String USER_ID = "user_id";
    public static final String WITHDRAWAL_AMOUNT = "withdrawal_amount";
    public static final String WITHDRAWAL_STATUS = "withdrawal_status";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 提现金额
     */
    @TableField(value = "withdrawal_amount")
    private BigDecimal withdrawalAmount;
    /**
     * 提现状态
     */
    @TableField(value = "withdrawal_status")
    private Integer withdrawalStatus;

}
