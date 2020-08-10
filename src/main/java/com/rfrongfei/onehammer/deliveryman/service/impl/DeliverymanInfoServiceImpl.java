package com.rfrongfei.onehammer.deliveryman.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.ImmutableMap;
import com.rfrongfei.onehammer.base.entity.UserInfo;
import com.rfrongfei.onehammer.base.exception.OnehammerException;
import com.rfrongfei.onehammer.base.key.IdGenerator;
import com.rfrongfei.onehammer.base.util.BeanHelper;
import com.rfrongfei.onehammer.base.util.EntityHelper;
import com.rfrongfei.onehammer.common.input.UserInput;
import com.rfrongfei.onehammer.common.service.IUserInfoService;
import com.rfrongfei.onehammer.common.vo.UserInfoVO;
import com.rfrongfei.onehammer.deliveryman.mapper.DeliverymanInfoMapper;
import com.rfrongfei.onehammer.deliveryman.entity.DeliverymanInfo;
import com.rfrongfei.onehammer.deliveryman.service.IDeliverymanInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("2")
@Slf4j
public class DeliverymanInfoServiceImpl extends ServiceImpl<DeliverymanInfoMapper, DeliverymanInfo>
        implements IDeliverymanInfoService, IUserInfoService {
    @Override
    public UserInfoVO phoneLogin(UserInput userInput) {
        DeliverymanInfo deliverymanInfo = BeanHelper.create(userInput, DeliverymanInfo.class);
        deliverymanInfo = getOne(EntityHelper.query(deliverymanInfo), true);
        if (deliverymanInfo == null) {
            deliverymanInfo = BeanHelper.create(userInput, DeliverymanInfo.class);
            deliverymanInfo.setDeliverymanId(IdGenerator.nextUserId(userInput.getUserType()));
            if (!save(deliverymanInfo)) {
                throw new OnehammerException(this.getClass(), "phoneLogin", "保存用户信息失败", deliverymanInfo);
            }
        }
        return UserInfoVO.builder().userInfo(deliverymanInfo).build();
    }

    @Override
    public UserInfo getUserInfoPhone(String phone) {
        DeliverymanInfo deliverymanInfo = new DeliverymanInfo();
        deliverymanInfo.setPhone(phone);
        return getOne(EntityHelper.query(deliverymanInfo),true);
    }

    @Override
    public UserInfo getUserInfoUserId(String userId) {
        DeliverymanInfo deliverymanInfo = new DeliverymanInfo();
        deliverymanInfo.setDeliverymanId(userId);
        return getOne(EntityHelper.query(deliverymanInfo),true);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        DeliverymanInfo deliverymanInfo = (DeliverymanInfo) userInfo;
        if (deliverymanInfo.getId() != null) {
            if (!updateById(deliverymanInfo)) {
                throw new OnehammerException(this.getClass(),"updateUser","更新用户信息失败",userInfo);
            }
        }else{
            UpdateWrapper<DeliverymanInfo> infoUpdateWrapper = EntityHelper.update(DeliverymanInfo.class, ImmutableMap.of(
                    DeliverymanInfo.DELIVERYMAN_ID, deliverymanInfo.getDeliverymanId(),
                    DeliverymanInfo.PHONE, deliverymanInfo.getPhone()
            ));
            if (!update(deliverymanInfo, infoUpdateWrapper)) {
                throw new OnehammerException(this.getClass(),"updateUser","更新用户信息失败",userInfo);
            }
        }
        log.info("更新:table:['{}'],params:[{}]",EntityHelper.tableName(deliverymanInfo),deliverymanInfo);
    }

    @Override
    public void deleteUser(UserInfo userInfo) {
        DeliverymanInfo deliverymanInfo = (DeliverymanInfo) userInfo;
        if (deliverymanInfo.getId() != null) {
            if (!removeById(deliverymanInfo.getId())) {
                throw new OnehammerException(this.getClass(),"updateUser","删除用户信息失败",userInfo);
            }
        }else{
            UpdateWrapper<DeliverymanInfo> infoUpdateWrapper = EntityHelper.update(DeliverymanInfo.class, ImmutableMap.of(
                    DeliverymanInfo.DELIVERYMAN_ID, deliverymanInfo.getDeliverymanId(),
                    DeliverymanInfo.PHONE, deliverymanInfo.getPhone()
            ));
            if (!remove(infoUpdateWrapper)) {
                throw new OnehammerException(this.getClass(),"updateUser","删除用户信息失败",userInfo);
            }
        }
        log.info("删除:table:['{}'],params:[{}]",EntityHelper.tableName(deliverymanInfo),deliverymanInfo);
    }

}
