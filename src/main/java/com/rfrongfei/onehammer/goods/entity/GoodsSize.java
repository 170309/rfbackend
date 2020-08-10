package com.rfrongfei.onehammer.goods.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;


import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 商品规格
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
@TableName("rf_goods_size")

public class GoodsSize extends Audit {

    public static final String ID = "id";
    public static final String GOODS_SIZE = "goods_size";
    public static final String GOODS_SIZE_ID = "goods_size_id";
    public static final String PRICE = "price";
    public static final String STOCK = "stock";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 规格描述
     */
    @TableField(value = "goods_size")
    private String goodsSize;
    /**
     * 商品规格ID
     */
    @TableField(value = "goods_size_id")
    private String goodsSizeId;
    /**
     * 价格
     */
    @TableField(value = "price")
    private BigDecimal price;
    /**
     * 库存
     */
    @TableField(value = "stock")
    private String stock;

}
