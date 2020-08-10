package com.rfrongfei.onehammer.base.handler;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.rfrongfei.onehammer.base.entity.Audit;
import com.rfrongfei.onehammer.base.util.StringHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class OnehammerMateObjectHandler implements MetaObjectHandler
{
    private static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");

    @Override
    public void insertFill(MetaObject metaObject) {
        String currentDate = DateUtil.format(new Date(System.currentTimeMillis()),"yyyy-MM-dd HH:mm:ss");
        // 自动填充 创建时间字段
        setValue(Audit.CREATE_DATE,DateUtil.parse(currentDate),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        String currentDate = DateUtil.format(new Date(System.currentTimeMillis()),"yyyy-MM-dd HH:mm:ss");
        setValue(Audit.UPDATE_DATE,DateUtil.parse(currentDate),metaObject);
    }

    private void setValue(String columnName,Object value, MetaObject metaObject){
        String humpColumnName = StringHelper.toHump(columnName);
        Object columnValue = getFieldValByName(humpColumnName, metaObject);//mybatis-plus版本2.0.9+
        if (columnValue == null) {
            setFieldValByName(humpColumnName,value,metaObject);
        }
    }
}
