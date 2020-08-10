package com.rfrongfei.onehammer.common.service;

import com.rfrongfei.onehammer.base.entity.UserInfo;
import com.rfrongfei.onehammer.common.enums.UserType;
import com.rfrongfei.onehammer.common.input.UserInput;
import com.rfrongfei.onehammer.common.vo.InfoVO;
import com.rfrongfei.onehammer.common.vo.UserInfoVO;
import com.rfrongfei.onehammer.deliveryman.entity.DeliverymanInfo;
import com.rfrongfei.onehammer.merchants.entity.MerchantsInfo;
import com.rfrongfei.onehammer.user.entity.ConsumerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserInfoServiceHolder {

    @Autowired
    private Map<String, IUserInfoService> loginServices = new ConcurrentHashMap<>(3);

    private ConcurrentHashMap<String, Class<? extends UserInfo>> userInfoMap = new ConcurrentHashMap<>();

    private String userType;

    public void setUserType(Integer userType) {
        this.userType = userType.toString();
    }

    @PostConstruct
    public void init() {
        userInfoMap.put(UserType.CONSUMER.getCode().toString(), ConsumerInfo.class);
        userInfoMap.put(UserType.DELIVERYMAN.getCode().toString(), DeliverymanInfo.class);
        userInfoMap.put(UserType.MERCHANTS.getCode().toString(), MerchantsInfo.class);
    }

    public UserInfoVO login(UserInput userInput) {
        return loginServices.get(this.userType).phoneLogin(userInput);
    }

    public UserInfo getUserInfoPhone(String phone) {
        return loginServices.get(this.userType).getUserInfoPhone(phone);
    }

    public UserInfo getUserInfoUserId(String userId) {
        return loginServices.get(this.userType).getUserInfoUserId(userId);
    }

    public void updateUser(InfoVO infoVO) {
        loginServices.get(this.userType).updateUser(getUserInfo(infoVO));
    }

    public void deleteUser(InfoVO infoVO){
        loginServices.get(this.userType).deleteUser(getUserInfo(infoVO));
    }

    private UserInfo getUserInfo(InfoVO infoVO){
        if (UserType.CONSUMER.getCode().equals(this.userType)) {
            return infoVO.getConsumerInfo();
        }
        if (UserType.MERCHANTS.getCode().equals(this.userType)) {
            return infoVO.getMerchantsInfo();
        }
        if (UserType.DELIVERYMAN.getCode().equals(this.userType)) {
            return infoVO.getDeliverymanInfo();
        }
        return null;
    }
}
