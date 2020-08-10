package com.rfrongfei.onehammer.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.math.BigDecimal;
import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 地址
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
@TableName("rf_address")
public class Address extends Audit {

    public static final String ID = "id";
    public static final String ADDRESS_ID = "address_id";
    public static final String DEFAULT_ENUM = "default_enum";
    public static final String DETAIL = "detail";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String NAME = "name";
    public static final String NUMBER = "number";
    public static final String PHONE = "phone";
    public static final String REGION = "region";

    /**
     *
     */
    @TableId
    private String id;
    /**
     * 地址ID
     */
    @TableField(value = "address_id")
    private String addressId;
    /**
     * 默认
     */
    @TableField(value = "default_enum")
    private Integer defaultEnum;
    /**
     * 收货人详细地址
     */
    @TableField(value = "detail")
    private String detail;
    /**
     * 纬度
     */
    @TableField(value = "latitude")
    private BigDecimal latitude;
    /**
     * 经度
     */
    @TableField(value = "longitude")
    private BigDecimal longitude;
    /**
     * 收货人姓名
     */
    @TableField(value = "name")
    private String name;
    /**
     * 门牌号
     */
    @TableField(value = "number")
    private String number;
    /**
     * 收货人电话
     */
    @TableField(value = "phone")
    private String phone;
    /**
     * 收货人所在区域
     */
    @TableField(value = "region")
    private String region;

}
