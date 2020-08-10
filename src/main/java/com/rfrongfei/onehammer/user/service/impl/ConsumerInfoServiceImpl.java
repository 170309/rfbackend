package com.rfrongfei.onehammer.user.service.impl;

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
import com.rfrongfei.onehammer.user.mapper.ConsumerInfoMapper;
import com.rfrongfei.onehammer.user.entity.ConsumerInfo;
import com.rfrongfei.onehammer.user.service.IConsumerInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("0")
@Slf4j
public class ConsumerInfoServiceImpl extends ServiceImpl<ConsumerInfoMapper, ConsumerInfo>
        implements IConsumerInfoService, IUserInfoService {
    @Override
    public UserInfoVO phoneLogin(UserInput userInput) {
        ConsumerInfo consumerInfo = BeanHelper.create(userInput, ConsumerInfo.class);
        consumerInfo = getOne(EntityHelper.query(consumerInfo), true);
        if (consumerInfo == null) {
            consumerInfo = BeanHelper.create(userInput, ConsumerInfo.class);
            consumerInfo.setConsumerId(IdGenerator.nextUserId(userInput.getUserType()));
            consumerInfo.setAccount(IdGenerator.account(userInput.getPhone()));
            if (!save(consumerInfo)) {
                throw new OnehammerException(this.getClass(),"phoneLogin","保存用户信息失败",consumerInfo);
            }
        }
        return UserInfoVO.builder().userInfo(consumerInfo).build();
    }

    @Override
    public UserInfo getUserInfoPhone(String phone) {
        ConsumerInfo consumerInfo = new ConsumerInfo();
        consumerInfo.setPhone(phone);
        return getOne(EntityHelper.query(consumerInfo),true);
    }

    @Override
    public UserInfo getUserInfoUserId(String userId) {
        ConsumerInfo consumerInfo = new ConsumerInfo();
        consumerInfo.setConsumerId(userId);
        return getOne(EntityHelper.query(consumerInfo),true);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        ConsumerInfo consumerInfo = (ConsumerInfo) userInfo;
        if (consumerInfo.getId() != null) {
            if (!updateById(consumerInfo)) {
                throw new OnehammerException(this.getClass(),"updateUser","更新用户信息失败",userInfo);
            }
        }else{
            UpdateWrapper<ConsumerInfo> infoUpdateWrapper = EntityHelper.update(ConsumerInfo.class, ImmutableMap.of(
                    ConsumerInfo.CONSUMER_ID, consumerInfo.getConsumerId(),
                    ConsumerInfo.PHONE, consumerInfo.getPhone()
            ));
            if (!update(consumerInfo, infoUpdateWrapper)) {
                throw new OnehammerException(this.getClass(),"updateUser","更新用户信息失败",userInfo);
            }
        }
        log.info("更新:table:['{}'],params:[{}]",EntityHelper.tableName(consumerInfo),consumerInfo);
    }

    @Override
    public void deleteUser(UserInfo userInfo) {
        ConsumerInfo consumerInfo = (ConsumerInfo) userInfo;
        if (consumerInfo.getId() != null) {
            if (!removeById(consumerInfo.getId())) {
                throw new OnehammerException(this.getClass(),"updateUser","删除用户信息失败",userInfo);
            }
        }else{
            UpdateWrapper<ConsumerInfo> infoUpdateWrapper = EntityHelper.update(ConsumerInfo.class, ImmutableMap.of(
                    ConsumerInfo.CONSUMER_ID, consumerInfo.getConsumerId(),
                    ConsumerInfo.PHONE, consumerInfo.getPhone()
            ));
            if (!remove(infoUpdateWrapper)) {
                throw new OnehammerException(this.getClass(),"updateUser","删除用户信息失败",userInfo);
            }
        }
        log.info("删除:table:['{}'],params:[{}]",EntityHelper.tableName(consumerInfo),consumerInfo);
    }

}
