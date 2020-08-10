package com.rfrongfei.onehammer.base.util;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.rfrongfei.onehammer.base.entity.Audit;
import com.rfrongfei.onehammer.base.exception.OnehammerException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName EntityUtil
 * @Author Jxlsx
 * @Date 2019/12/17 下午4:48
 * @Version 1.0
 */
@Slf4j
public class EntityHelper {


    /**
     * 根据实体创建query对象
     *
     * @param entity :
     * @return : {@link QueryWrapper<T>}
     */
    public static <T extends Audit> QueryWrapper<T> query(T entity) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<T>();
        nonNullColumn(entity).parallelStream()
                .forEach(column -> {
                    queryWrapper.eq(StringHelper.toHump(column.getName()), column.getValue());
                });
        return queryWrapper;
    }

    /**
     * 根据实体创建update 对象
     *
     * @param entity :
     * @return : {@link UpdateWrapper<T>}
     */
    public static <T extends Audit> UpdateWrapper<T> update(T entity, List<String> excludeColumns) {
        UpdateWrapper<T> updateWrapper = new UpdateWrapper<T>();
        nonNullColumn(entity).parallelStream()
                .forEach(column -> {
                    updateWrapper.eq(StringHelper.toHump(column.getName()), column.getValue());
                });
        return updateWrapper;
    }

    public static <T extends Audit> UpdateWrapper<T> update(Class<T> clazz, Map<String, Object> columns) {
        UpdateWrapper<T> updateWrapper = new UpdateWrapper<T>();
        if (columns.size() == 0) {
            throw new OnehammerException(EntityHelper.class, "update", "构造更新条件失败", columns);
        }
        columns.forEach((name, value) -> {
            String columnName = !name.contains("_") ? name : StringHelper.toHump(name);
            updateWrapper.eq(columnName, value);
        });
        return updateWrapper;
    }

    /**
     * 获取表名
     * @param entity :
     * @return : {@link String}
     */
    public static <T> String tableName(T entity) {
        return tableName(entity.getClass());
    }

    /**
     * 获取表名
     * @param clazz
     * @return : {@link String}
     */
    public static <T> String tableName(Class<T> clazz) {
        if (clazz.isAnnotationPresent(TableName.class)) {
            return clazz.getAnnotation(TableName.class).value();
        }
        log.info("实体没有@TableName注解:{}",clazz.getName());
        return null;
    }


    /**
     * 获取实体值不为null的列
     *
     * @param entity :
     * @return : {@link List<Column>}
     */
    public static <T extends Audit> List<Column> nonNullColumn(T entity) {
        return column(entity).parallelStream()
                .filter(Objects::nonNull)
                .filter(column -> "".equals(column.getValue()))
                .filter(column -> "null".equals(column.getValue()))
                .filter(column -> column.getValue() != null)
                .collect(Collectors.toList());
    }

    public static <T extends Audit> boolean isNull(T entity) {
        final List<Column> column = column(entity);
        return CollUtil.isNotEmpty(column);
    }

    /**
     * 获取参数实体的列信息
     *
     * @param entity :
     * @return : {@link List<Column>}
     */
    public static <T extends Audit> List<Column> column(T entity) {
        final Class<? extends Audit> entityClass = entity.getClass();
        final Field[] declaredFields = entityClass.getDeclaredFields();
        return Arrays.asList(declaredFields).parallelStream()
                .map(field -> {
                    final Column column = new Column();
                    field.setAccessible(true);
                    try {
                        final Object value;
                        value = field.get(entity);
                        column.setValue(value);
                        final String name = field.getName();
                        column.setName(name);
                    } catch (IllegalAccessException e) {
                        throw new OnehammerException(EntityHelper.class, "column", "获取实体列信息失败！", entity);
                    }
                    return column;
                }).collect(Collectors.toList());
    }

    @Data
    static class Column {
        /**
         * 列名
         */
        private String name;
        /**
         * 列值
         */
        private Object value;
    }

}
