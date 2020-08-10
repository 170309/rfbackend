package com.rfrongfei.onehammer.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.rfrongfei.onehammer.base.entity.Audit;




import java.util.Date;

import lombok.*;

/**
 * 地区
 *
 * @author Jxlsx
 * @email iamlive@aliyun.com
 * @date 2019-12-23 15:33:55
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("rf_region")

public class Region extends Audit {

    public static final String ID = "id";
    public static final String CODE = "code";
    public static final String NAME = "name";
    public static final String REGION_ID = "region_id";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 地区编码
     */
    @TableField(value = "code")
    private String code;
    /**
     * 地区中文
     */
    @TableField(value = "name")
    private String name;
    /**
     * 区域ID
     */
    @TableField(value = "region_id")
    private String regionId;

}
