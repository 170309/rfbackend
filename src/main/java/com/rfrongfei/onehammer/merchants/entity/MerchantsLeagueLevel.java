package com.rfrongfei.onehammer.merchants.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 加盟等级
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
@TableName("rf_merchants_league_level")

public class MerchantsLeagueLevel extends Audit {

    public static final String ID = "id";
    public static final String LEAGUE_AMOUNT = "league_amount";
    public static final String LEVEL = "level";
    public static final String LEVEL_ID = "level_id";
    public static final String PROPORTION = "proportion";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 等级对应金额
     */
    @TableField(value = "league_amount")
    private BigDecimal leagueAmount;
    /**
     * 加盟等级
     */
    @TableField(value = "level")
    private String level;
    /**
     * 加盟等级ID
     */
    @TableField(value = "level_id")
    private String levelId;
    /**
     * 等级分成比例
     */
    @TableField(value = "proportion")
    private BigDecimal proportion;

}
