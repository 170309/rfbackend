package com.rfrongfei.onehammer.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.rfrongfei.onehammer.base.entity.UserInfo;
import com.rfrongfei.onehammer.base.exception.OnehammerException;
import com.rfrongfei.onehammer.base.util.*;
import com.rfrongfei.onehammer.common.enums.LoginStatus;
import com.rfrongfei.onehammer.common.input.UserInput;
import com.rfrongfei.onehammer.common.mapper.UserMapper;
import com.rfrongfei.onehammer.common.entity.User;
import com.rfrongfei.onehammer.common.service.IUserService;
import com.rfrongfei.onehammer.common.service.UserInfoServiceHolder;
import com.rfrongfei.onehammer.common.vo.InfoVO;
import com.rfrongfei.onehammer.common.vo.UserInfoVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private final UserInfoServiceHolder userInfoServiceHolder;

    private final SmsCodeService smsCodeService;

    @Override
    public User loginStatus(String userId) {
        User user = new User();
        user.setUserId(userId);
        user = getOne(EntityHelper.query(user), true);
        String accessToken = user.getAccessToken();
        user.setAccessToken(JwtTokenHelper.flush(accessToken));
        return user;
    }

    @Override
    public String smsCode(String phone, Integer userType) {
        String smsCode = smsCodeService.getSmsCode(phone, userType);
        if (smsCode != null) {
            if (!smsCodeService.sendSmsCode(phone,smsCode)) {
                throw new OnehammerException(this.getClass(),"smsCode","发送验证码失败!",phone,userType);
            }
        }
        smsCode = smsCodeService.getMsgCode();
        if (smsCodeService.sendSmsCode(phone,smsCode)) {
            if (!smsCodeService.setSmsCode(phone,userType,smsCode)) {
                throw new OnehammerException(this.getClass(),"smsCode","发送验证码失败!",phone,userType);
            }
        }
        return smsCode;
    }

    @Override
    public User login(UserInput userInput) {
        String smsCode = smsCodeService.getSmsCode(userInput.getPhone(), userInput.getUserType());
        if (smsCode == null) {
            throw new OnehammerException(this.getClass(), "login", "验证码不存在", userInput);
        }
        if (!StringUtils.equalsIgnoreCase(smsCode, userInput.getSmsCode())) {
            throw new OnehammerException(this.getClass(), "login", "验证码错误", userInput);
        }
        userInfoServiceHolder.setUserType(userInput.getUserType());
        UserInfoVO userInfoVO = userInfoServiceHolder.login(userInput);
        User user = new User();
        String userId = userInfoVO.getUserInfo().getUserId();
        user.setUserId(userId);
        String token = JwtTokenHelper.generate(userId, userInput.getUserType());
        user.setAccessToken(token);
        user.setUserType(userInput.getUserType());
        user.setLoginStatus(LoginStatus.LOGIN.getCode());
        smsCodeService.clearSmsCode(userInput.getPhone(), userInput.getUserType());
        return user;
    }

    @Override
    public UserInfo getUserInfoUserId(String userId) {
        userInfoServiceHolder.setUserType(getUserType(userId));
        return userInfoServiceHolder.getUserInfoUserId(userId);
    }

    @Override
    public UserInfo getUserInfoPhone(String phone) {
        userInfoServiceHolder.setUserType(getUserType(phone));
        return userInfoServiceHolder.getUserInfoPhone(phone);
    }

    @Override
    public InfoVO updateUser(InfoVO infoVO) {
        userInfoServiceHolder.setUserType(getUserType(infoVO));
        userInfoServiceHolder.updateUser(infoVO);
        return infoVO;
    }

    @Override
    public InfoVO deleteUser(InfoVO infoVO) {
        userInfoServiceHolder.setUserType(getUserType(infoVO));
        userInfoServiceHolder.deleteUser(infoVO);
        return infoVO;
    }

    private Integer getUserType(String identifier){
        // 手机号码
        if (identifier.length() == 11) {
            return getOne(EntityHelper.query(User.builder().phone(identifier).build()),true).getUserType();
        }else{
            return Integer.valueOf(identifier.substring(0,1));
        }
    }

    private Integer getUserType(InfoVO infoVO){
        String identifier = null;
        if (infoVO.getConsumerInfo() != null) {
            identifier = infoVO.getConsumerInfo().getConsumerId();
        }
        if (infoVO.getDeliverymanInfo() != null) {
            identifier = infoVO.getDeliverymanInfo().getDeliverymanId();
        }
        if (infoVO.getMerchantsInfo() != null){
            identifier = infoVO.getMerchantsInfo().getMerchantsId();
        }
        if (identifier == null) {
            throw new OnehammerException(this.getClass(),"getUserType","获取用户类型失败",infoVO);
        }
        return getUserType(identifier);
    }
}
