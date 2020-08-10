package com.rfrongfei.onehammer.licenses.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;




import java.util.Date;

import com.rfrongfei.onehammer.base.entity.Audit;
import lombok.*;

/**
 * 骑手许可
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
@TableName("rf_license_deliveryman")

public class LicenseDeliveryman extends Audit {

    public static final String ID = "id";
    public static final String CARD_FRONT = "card_front";
    public static final String CARD_NUMBER = "card_number";
    public static final String CARD_VERSO = "card_verso";
    public static final String HEALTH_IMG = "health_img";
    public static final String STATUS = "status";
    public static final String USER_ID = "user_id";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 身份证正面
     */
    @TableField(value = "card_front")
    private String cardFront;
    /**
     * 身份证号码
     */
    @TableField(value = "card_number")
    private String cardNumber;
    /**
     * 身份证背面
     */
    @TableField(value = "card_verso")
    private String cardVerso;
    /**
     * 健康证
     */
    @TableField(value = "health_img")
    private String healthImg;
    /**
     * 审核状态:0失败，1成功，2等待
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private String userId;

}
