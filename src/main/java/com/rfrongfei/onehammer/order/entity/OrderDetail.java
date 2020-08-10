package com.rfrongfei.onehammer.order.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 订单详情
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
@TableName("rf_order_detail")

public class OrderDetail extends Audit {

    public static final String ID = "id";
    public static final String COUNT = "count";
    public static final String GOODS_ID = "goods_id";
    public static final String GOODS_SIZE = "goods_size";
    public static final String GOODS_SIZE_ID = "goods_size_id";
    public static final String NAME = "name";
    public static final String ORDER_ID = "order_id";
    public static final String PIC = "pic";
    public static final String PRICE = "price";

    /**
     *
     */

    @TableId
    private String id;
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
     * 商品规格名
     */
    @TableField(value = "goods_size")
    private String goodsSize;
    /**
     * 商品规格ID
     */
    @TableField(value = "goods_size_id")
    private String goodsSizeId;
    /**
     * 商品名
     */
    @TableField(value = "name")
    private String name;
    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private String orderId;
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

}
