package com.rfrongfei.onehammer.merchants.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 商家分类
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
@TableName("rf_merchants_category")

public class MerchantsCategory extends Audit {

    public static final String ID = "id";
    public static final String DESCRIPTION = "description";
    public static final String MERCHANTS_CATEGORY_ID = "merchants_category_id";
    public static final String MERCHANTS_ID = "merchants_id";
    public static final String SORT = "sort";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 分类描述
     */
    @TableField(value = "description")
    private String description;
    /**
     * 商户分类ID
     */
    @TableField(value = "merchants_category_id")
    private String merchantsCategoryId;
    /**
     * 用户ID
     */
    @TableField(value = "merchants_id")
    private String merchantsId;
    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;

}
