package com.rfrongfei.onehammer.common.input;

import com.rfrongfei.onehammer.common.entity.User;
import com.rfrongfei.onehammer.deliveryman.entity.DeliverymanInfo;
import com.rfrongfei.onehammer.merchants.entity.MerchantsInfo;
import com.rfrongfei.onehammer.user.entity.ConsumerInfo;
import lombok.Data;

@Data
public class InfoVOInput {
    private ConsumerInfo consumerInfo;
    private DeliverymanInfo deliverymanInfo;
    private MerchantsInfo merchantsInfo;
    private User user;
}
