package com.rfrongfei.onehammer.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rfrongfei.onehammer.base.entity.UserInfo;
import com.rfrongfei.onehammer.common.entity.User;
import com.rfrongfei.onehammer.common.input.UserInput;
import com.rfrongfei.onehammer.common.vo.InfoVO;

public interface IUserService extends IService<User> {


    User loginStatus(String userId);

    // 获取验证码
    String smsCode(String phone,Integer userType);

    //登陆
    User login(UserInput userInput);

    UserInfo getUserInfoUserId(String userId);

    UserInfo getUserInfoPhone(String phone);

    // 修改用户信息
    InfoVO updateUser(InfoVO infoVO);

    InfoVO deleteUser(InfoVO infoVO);
}
