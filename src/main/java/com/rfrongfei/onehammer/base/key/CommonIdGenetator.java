package com.rfrongfei.onehammer.base.key;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class CommonIdGenetator implements IKeyGenerator {

    // 普通主键生成
    // 1. 12位日期
    // 用户ID生成
    // 订单ID生成
    @Override
    public String executeSql(String incrementerName) {
        Date date = new Date();
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        String workerId = monthFormat.format(date);
        String dateCenterId = dayFormat.format(date);
        Snowflake snowflake = new Snowflake(Long.parseLong(workerId), Long.parseLong(dateCenterId), true);
        String nextIdStr = snowflake.nextIdStr();
        log.info("snowFlak,idWorker,ID:[{}]", nextIdStr);
        return String.format("select %s from dual",nextIdStr);
    }
}
