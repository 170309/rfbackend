package com.rfrongfei.onehammer.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rfrongfei.onehammer.common.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select u.* ,c.* from user u,rf_consumer_info")
    Map<String,Object> findConsumerInfo();

}