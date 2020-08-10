package com.rfrongfei.onehammer.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Audit
 * @Description 审计字段
 * @Author eason.xu
 * @Date 19-11-21 下午11:44
 * @Version 1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Audit implements Serializable {

    public static final String CREATE_DATE = "create_date";
    public static final String UPDATE_DATE = "update_date";

    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;
    /** 更新时间 */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateDate;

}
