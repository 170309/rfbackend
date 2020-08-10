package com.rfrongfei.onehammer.merchants.service.impl;

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
import com.rfrongfei.onehammer.merchants.mapper.MerchantsInfoMapper;
import com.rfrongfei.onehammer.merchants.entity.MerchantsInfo;
import com.rfrongfei.onehammer.merchants.service.IMerchantsInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("1")
@Slf4j
public class MerchantsInfoServiceImpl extends ServiceImpl<MerchantsInfoMapper, MerchantsInfo>
        implements IMerchantsInfoService, IUserInfoService {
    @Override
    public UserInfoVO phoneLogin(UserInput userInput) {
        MerchantsInfo merchantsInfo = BeanHelper.create(userInput, MerchantsInfo.class);
        merchantsInfo = getOne(EntityHelper.query(merchantsInfo), true);
        if (merchantsInfo == null) {
            merchantsInfo = BeanHelper.create(userInput, MerchantsInfo.class);
            merchantsInfo.setMerchantsId(IdGenerator.nextUserId(userInput.getUserType()));
            if (!save(merchantsInfo)) {
                throw new OnehammerException(this.getClass(),"phoneLogin","保存用户信息失败",merchantsInfo);
            }
        }
        return UserInfoVO.builder().userInfo(merchantsInfo).build();
    }

    @Override
    public UserInfo getUserInfoPhone(String phone) {
        MerchantsInfo merchantsInfo = new MerchantsInfo();
        merchantsInfo.setPhone(phone);
        return getOne(EntityHelper.query(merchantsInfo),true);
    }

    @Override
    public UserInfo getUserInfoUserId(String userId) {
        MerchantsInfo merchantsInfo = new MerchantsInfo();
        merchantsInfo.setMerchantsId(userId);
        return getOne(EntityHelper.query(merchantsInfo),true);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        MerchantsInfo merchantsInfo = (MerchantsInfo) userInfo;
        if (merchantsInfo.getId() != null) {
            if (!updateById(merchantsInfo)) {
                throw new OnehammerException(this.getClass(),"updateUser","更新用户信息失败",userInfo);
            }
        }else{
            UpdateWrapper<MerchantsInfo> infoUpdateWrapper = EntityHelper.update(MerchantsInfo.class, ImmutableMap.of(
                    MerchantsInfo.MERCHANTS_ID, merchantsInfo.getMerchantsId(),
                    MerchantsInfo.PHONE, merchantsInfo.getPhone()
            ));
            if (!update(merchantsInfo, infoUpdateWrapper)) {
                throw new OnehammerException(this.getClass(),"updateUser","更新用户信息失败",userInfo);
            }
        }
        log.info("更新:table:['{}'],params:[{}]",EntityHelper.tableName(merchantsInfo),merchantsInfo);
    }

    @Override
    public void deleteUser(UserInfo userInfo) {
        MerchantsInfo merchantsInfo = (MerchantsInfo) userInfo;
        if (merchantsInfo.getId() != null) {
            if (!removeById(merchantsInfo.getId())) {
                throw new OnehammerException(this.getClass(),"updateUser","删除用户信息失败",userInfo);
            }
        }else{
            UpdateWrapper<MerchantsInfo> infoUpdateWrapper = EntityHelper.update(MerchantsInfo.class, ImmutableMap.of(
                    MerchantsInfo.MERCHANTS_ID, merchantsInfo.getMerchantsId(),
                    MerchantsInfo.PHONE, merchantsInfo.getPhone()
            ));
            if (!remove(infoUpdateWrapper)) {
                throw new OnehammerException(this.getClass(),"updateUser","删除用户信息失败",userInfo);
            }
        }
        log.info("删除:table:['{}'],params:[{}]",EntityHelper.tableName(merchantsInfo),merchantsInfo);
    }


}
