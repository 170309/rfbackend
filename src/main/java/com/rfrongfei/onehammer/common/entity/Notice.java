package com.rfrongfei.onehammer.common.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.rfrongfei.onehammer.base.entity.Audit;




import java.util.Date;

import lombok.*;

/**
 * 消息通知
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
@TableName("rf_notice")

public class Notice extends Audit {

    public static final String ID = "id";
    public static final String CONTENT = "content";
    public static final String NOTICE_ID = "notice_id";
    public static final String NOTICE_FROM = "notice_from";
    public static final String STATUS = "status";
    public static final String TITLE = "title";
    public static final String TYPE = "type";
    public static final String USER_ID = "user_id";

    /**
     *
     */

    @TableId
    private String id;
    /**
     * 通知内容
     */
    @TableField(value = "content")
    private String content;
    /**
     * 通知ID
     */
    @TableField(value = "notice_id")
    private String noticeId;
    /**
     * 消息来源
     */
    @TableField(value = "notice_from")
    private String noticeFrom;
    /**
     * 状态:0未读，1已读
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;
    /**
     * 通知类型
     */
    @TableField(value = "type")
    private Integer type;
    /**
     * 需要通知的用户IDs
     */
    @TableField(value = "user_id")
    private Integer userId;

}
