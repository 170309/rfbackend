package com.rfrongfei.onehammer.base.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.rfrongfei.onehammer.base.exception.OnehammerException;

/**
 * @ClassName BeanHelper
 * @Author Jxlsx
 * @Date 2019/12/17 下午11:59
 * @Version 1.0
 */
public class BeanHelper {

    /**
     * 拷贝对象，忽略null值
     * @param source :
     * @param clazz :
     * @return : {@link T}
     */
    public static <T> T create(Object source,Class<T> clazz){
        try {
            final T instance = clazz.newInstance();
            final CopyOptions copyOptions = CopyOptions.create()
                    .ignoreNullValue();
            BeanUtil.copyProperties(source,instance, copyOptions);
            return instance;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new OnehammerException(BeanHelper.class,"create","创建目标实例对象失败",source,clazz);
        }
    }

}
