package com.rfrongfei.onehammer.common.service.impl;

import com.rfrongfei.onehammer.base.util.RedisHelper;
import com.rfrongfei.onehammer.common.entity.User;
import com.rfrongfei.onehammer.base.key.IdGenerator;
import com.rfrongfei.onehammer.common.enums.LoginStatus;
import com.rfrongfei.onehammer.common.enums.UserType;
import com.rfrongfei.onehammer.common.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private IUserService userService;

    @Test
    public void test1() {
    }

    @Autowired
    private RedisHelper redisHelper;

    @Test
    public void test2() {
//        User user = new User();
//        user.setId("asdasd");
//        user.setUserType(1);
//        user.setUpdateDate(new Date());
//        redisHelper.set("testKey",user);
//        System.out.println(redisHelper.get("testKey", User.class));
//
        redisHelper.del("testKey");
        System.out.println(redisHelper.get("testKey", User.class));

    }

}
