package com.rfrongfei.onehammer.base.exception;

import com.google.common.collect.ImmutableMap;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

/**
 * @ClassName OnehammerException
 * @Author Jxlsx
 * @Date 2019/12/17 下午4:56
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class OnehammerException extends RuntimeException implements GraphQLError {
    /** 异常类 */
    private Class<?> clazz;
    /** 异常方法 */
    private String method;
    /** 异常参数 */
    private Object[] param;
    /** 异常消息 */
    private String message;
    public OnehammerException(){
        super();
    }
    public OnehammerException(Class<?> clazz,String method,String message,Object ...param){
        this();
        this.clazz = clazz;
        this.method = method;
        this.param = param;
        this.message = message;
    }
    public OnehammerException(Class<?> clazz,String method,String message){
        this(clazz,method,message, (Object[]) null);
    }
    public OnehammerException(Class<?> clazz,String method){
        this(clazz,method,null);
    }
    public OnehammerException(String message){
        this(null,null,message,(Object[]) null);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return ImmutableMap.of("code","101"+param.length,"message",this.message);
    }
}
