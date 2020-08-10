package com.rfrongfei.onehammer.licenses.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 商家许可
 *
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
@TableName("rf_license_merchants")

public class LicenseMerchants extends Audit {

    public static final String ID = "id";
    public static final String CARD_NUMBER = "card_number";
    public static final String CARD_VERSO = "card_verso";
    public static final String CARDFRONT = "cardfront";
    public static final String MERCHANTS_ID = "merchants_id";
    public static final String STATUS = "status";
    public static final String STORE_PIC = "store_pic";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 身份证号码
     */
    @TableField(value = "card_number")
    private String cardNumber;
    /**
     * 身份证反面
     */
    @TableField(value = "card_verso")
    private String cardVerso;
    /**
     * 身份证正面
     */
    @TableField(value = "cardfront")
    private String cardfront;
    /**
     * 用户ID
     */
    @TableField(value = "merchants_id")
    private String merchantsId;
    /**
     * 审核状态:0失败，1成功，2等待
     */
    @TableField(value = "status")
    private String status;
    /**
     * 摊位图片
     */
    @TableField(value = "store_pic")
    private String storePic;

}
