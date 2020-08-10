package com.rfrongfei.onehammer.common.vo;

import com.rfrongfei.onehammer.base.entity.UserInfo;
import com.rfrongfei.onehammer.common.entity.User;
import com.rfrongfei.onehammer.common.enums.UserType;
import com.rfrongfei.onehammer.deliveryman.entity.DeliverymanInfo;
import com.rfrongfei.onehammer.merchants.entity.MerchantsInfo;
import com.rfrongfei.onehammer.user.entity.ConsumerInfo;
import lombok.Data;

@Data
public class InfoVO {
    private ConsumerInfo consumerInfo;
    private DeliverymanInfo deliverymanInfo;
    private MerchantsInfo merchantsInfo;
    private User user;

    public void setUserInfo(UserInfo userInfo){
        String userId = userInfo.getUserId();
        if (UserType.CONSUMER.getCode().toString().equalsIgnoreCase(userId.substring(0,1))){
            setConsumerInfo(((ConsumerInfo) userInfo));
        }
        if (UserType.MERCHANTS.getCode().toString().equalsIgnoreCase(userId.substring(0,1))){
            setMerchantsInfo(((MerchantsInfo) userInfo));
        }
        if (UserType.DELIVERYMAN.getCode().toString().equalsIgnoreCase(userId.substring(0,1))){
            setDeliverymanInfo(((DeliverymanInfo) userInfo));
        }
    }
}
