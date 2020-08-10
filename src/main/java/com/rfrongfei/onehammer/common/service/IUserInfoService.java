package com.rfrongfei.onehammer.common.service;

import com.rfrongfei.onehammer.base.entity.UserInfo;
import com.rfrongfei.onehammer.common.input.UserInput;
import com.rfrongfei.onehammer.common.vo.UserInfoVO;

public interface IUserInfoService {

    UserInfoVO phoneLogin(UserInput userInput);
    UserInfo getUserInfoPhone(String phone);
    UserInfo getUserInfoUserId(String userId);
    void updateUser(UserInfo userInfo);
    void deleteUser(UserInfo userInfo);
}
