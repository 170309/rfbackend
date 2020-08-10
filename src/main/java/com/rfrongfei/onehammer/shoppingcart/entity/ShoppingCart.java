package com.rfrongfei.onehammer.shoppingcart.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 购物车
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
@TableName("rf_shopping_cart")

public class ShoppingCart extends Audit {

    public static final String ID = "id";
    public static final String CONSUMER_ID = "consumer_id";
    public static final String COUNT = "count";
    public static final String GOODS_ID = "goods_id";
    public static final String GOODS_SIZE = "goods_size";
    public static final String GOODS_SIZE_ID = "goods_size_id";
    public static final String MERCHANTS_ID = "merchants_id";
    public static final String NAME = "name";
    public static final String PIC = "pic";
    public static final String PRICE = "price";
    public static final String SHOPPING_CART_ID = "shopping_cart_id";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 用户ID
     */
    @TableField(value = "consumer_id")
    private String consumerId;
    /**
     * 商品数量
     */
    @TableField(value = "count")
    private Integer count;
    /**
     * 商品ID
     */
    @TableField(value = "goods_id")
    private String goodsId;
    /**
     * 商品规格
     */
    @TableField(value = "goods_size")
    private String goodsSize;
    /**
     * 商品规格ID
     */
    @TableField(value = "goods_size_id")
    private String goodsSizeId;
    /**
     * 商户ID
     */
    @TableField(value = "merchants_id")
    private String merchantsId;
    /**
     * 商品名
     */
    @TableField(value = "name")
    private String name;
    /**
     * 商品图片
     */
    @TableField(value = "pic")
    private String pic;
    /**
     * 商品价格
     */
    @TableField(value = "price")
    private BigDecimal price;
    /**
     * 购物车ID
     */
    @TableField(value = "shopping_cart_id")
    private String shoppingCartId;

}
