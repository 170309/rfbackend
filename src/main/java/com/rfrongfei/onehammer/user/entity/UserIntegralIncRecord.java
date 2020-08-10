package com.rfrongfei.onehammer.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName IntegralIncRecord
 * @Author Jxlsx
 * @Date 2019/12/15 下午12:44
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "rf_user_integral_inc_record")

public class UserIntegralIncRecord extends Audit {

    public static final String ID = "id";
    public static final String USER_ID = "user_id";
    public static final String INCREASE = "increase";
    public static final String CREATE_DATE = "create_date";
    public static final String UPDATE_DATE = "update_date";

    @TableId
    private String id;
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;
    /**
     * 增加的积分数
     */
    @TableField(value = "increase")
    private Integer increase;
    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private Date createDate;
    /**
     * 更新时间
     */
    @TableField(value = "update_date")
    private Date updateDate;

}
