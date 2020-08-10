package com.rfrongfei.onehammer.goods.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 商品
 * @author Jxlsx
 * @email iamlive@aliyun.com
 * @date 2019-12-23 15:33:54
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("rf_goods")

public class Goods extends Audit {

	public static final String ID="id";
	public static final String CATEGORY_ID="category_id";
	public static final String DESCRIPTION="description";
	public static final String GOODS_ID="goods_id";
	public static final String NAME="name";
	public static final String PIC="pic";
	public static final String SHELVEL="shelvel";
	public static final String SORT="sort";
	public static final String USER_ID="user_id";

	/**
	 * 
	 */

@TableId
		private String id;
	/**
	 * 商品分类
	 */
	@TableField(value = "category_id")
	private String categoryId;
	/**
	 * 商品描述
	 */
	@TableField(value = "description")
	private String description;
	/**
	 * 商品ID
	 */
	@TableField(value = "goods_id")
	private String goodsId;
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
	 * 上架状态0未上架，1已上架
	 */
	@TableField(value = "shelvel")
	private Integer shelvel;
	/**
	 * 排序,数值越高越排在前面
	 */
	@TableField(value = "sort")
	private Integer sort;
	/**
	 * 用户ID
	 */
	@TableField(value = "user_id")
	private String userId;

}
