package com.rfrongfei.onehammer.goods.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 商品分类
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
@TableName("rf_goods_category")

public class GoodsCategory extends Audit {

    public static final String ID = "id";
    public static final String DECS = "decs";
    public static final String GOODS_CATEGORY_ID = "goods_category_id";
    public static final String SORT = "sort";
    public static final String USER_ID = "user_id";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 分类描述
     */
    @TableField(value = "decs")
    private String decs;
    /**
     * 商品分类ID
     */
    @TableField(value = "goods_category_id")
    private String goodsCategoryId;
    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;

}
