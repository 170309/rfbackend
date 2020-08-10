package com.rfrongfei.onehammer.common.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rfrongfei.onehammer.base.entity.UserInfo;
import com.rfrongfei.onehammer.common.entity.User;
import com.rfrongfei.onehammer.common.service.IUserService;
import com.rfrongfei.onehammer.common.vo.InfoVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserInfoQueryResolver implements GraphQLQueryResolver {

    private final IUserService userService;

    public String smsCode(String phone,Integer userType){
        return userService.smsCode(phone,userType);
    }
    public User loginStatus(String userId){
        return userService.loginStatus(userId);
    }

    public InfoVO getUserInfo(String userId, String phone){
        InfoVO infoVO = new InfoVO();
        if (userId != null) {
            UserInfo userInfo = userService.getUserInfoUserId(userId);
            infoVO.setUserInfo(userInfo);
        }
        if (phone != null){
            UserInfo userInfo = userService.getUserInfoPhone(phone);
            infoVO.setUserInfo(userInfo);
        }
        return infoVO;
    }

}
