package com.rfrongfei.onehammer.base.key;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.SystemClock;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;

import java.text.DecimalFormat;
import java.util.Date;

public class IdGenerator {

    /**
     * 1位用户类型，13位时间戳，2位hash值正负，10位hash值
     * @param userType : 用户类型
     * @return : {@link String}
     */
    public static String nextUserId(String userType){
        String time = DateUtil.format(new Date(System.currentTimeMillis()), "yyMMddHHmmss");
        return userType + time + uuidHash();
    }

    public static String nextUserId(Integer userType){
        return nextUserId(userType+"");
    }

    public static String account(String phone){
        String time = SystemClock.now() + "";
        time = time.substring(time.length()-4);
        String substring = phone.substring(phone.length() - 5);
        return time+substring;
    }

    /**
     * 13位时间戳，10位用户ID，2位商品数量
     * @param consumerId : 用户ID
     * @param goodsCount : 商品数量
     * @return : {@link String}
     */
    public static String nextOrderId(String consumerId,Integer goodsCount){
        String consumerSub = consumerId.substring(consumerId.length() - 10);
        DecimalFormat df = new DecimalFormat("00");
        return System.currentTimeMillis()+consumerSub+df.format(goodsCount);
    }

    private static String uuidHash(){
        String uuidHash = "";
        String uuid = IdWorker.get32UUID();
        int i = uuid.hashCode();
        if (i>0) {
            uuidHash = uuidHash + "99";
        }else{
            uuidHash = uuidHash + "11";
        }
        int abs = Math.abs(i);
        DecimalFormat df = new DecimalFormat("0000000000");
        return uuidHash + df.format(abs);
    }
}
