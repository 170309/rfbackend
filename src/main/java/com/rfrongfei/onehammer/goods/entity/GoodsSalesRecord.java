package com.rfrongfei.onehammer.goods.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 商品销售记录
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
@TableName("rf_goods_sales_record")

public class GoodsSalesRecord extends Audit {

    public static final String ID = "id";
    public static final String GOODS_ID = "goods_id";
    public static final String GOODS_SIZE_ID = "goods_size_id";
    public static final String MERCHANTS_ID = "merchants_id";
    public static final String RATE = "rate";
    public static final String SALES_COUNT = "sales_count";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 商品ID
     */
    @TableField(value = "goods_id")
    private String goodsId;
    /**
     * 商品规格ID
     */
    @TableField(value = "goods_size_id")
    private String goodsSizeId;
    /**
     * 商家ID
     */
    @TableField(value = "merchants_id")
    private String merchantsId;
    /**
     * 好评率
     */
    @TableField(value = "rate")
    private BigDecimal rate;
    /**
     * 销售数量
     */
    @TableField(value = "sales_count")
    private Integer salesCount;

}
