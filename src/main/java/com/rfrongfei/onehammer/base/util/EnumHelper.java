package com.rfrongfei.onehammer.base.util;

import com.rfrongfei.onehammer.base.enums.OnehammerEnum;
import com.rfrongfei.onehammer.base.exception.OnehammerException;

/**
 * @ClassName EnumHelper
 * @Author Jxlsx
 * @Date 2019/12/17 下午6:27
 * @Version 1.0
 */
public class EnumHelper {


    public static <T extends OnehammerEnum> T get(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        throw new OnehammerException(EntityHelper.class,"getEnum()","获取enum类型失败",code,enumClass);
    }

    public static <T extends OnehammerEnum> T get(String desc, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (desc.equals(each.getDesc())) {
                return each;
            }
        }
        throw new OnehammerException(EntityHelper.class,"getEnum()","获取enum类型失败",desc,enumClass);
    }

}
