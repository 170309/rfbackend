package com.rfrongfei.onehammer.merchants.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 商家地区
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
@TableName("rf_merchants_league")

public class MerchantsLeague extends Audit {

    public static final String ID = "id";
    public static final String LEAGUE_ID = "league_id";
    public static final String LEVEL_ID = "level_id";
    public static final String REGION_ID = "region_id";
    public static final String USER_ID = "user_id";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 加盟信息ID
     */
    @TableField(value = "league_id")
    private String leagueId;
    /**
     * 加盟等级
     */
    @TableField(value = "level_id")
    private String levelId;
    /**
     * 所属地区
     */
    @TableField(value = "region_id")
    private String regionId;
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;

}
