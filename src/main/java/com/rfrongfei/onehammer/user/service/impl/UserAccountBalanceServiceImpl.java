package com.rfrongfei.onehammer.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.user.mapper.UserAccountBalanceMapper;
import com.rfrongfei.onehammer.user.entity.UserAccountBalance;
import com.rfrongfei.onehammer.user.service.IUserAccountBalanceService;
import org.springframework.stereotype.Service;

@Service
public class UserAccountBalanceServiceImpl extends ServiceImpl<UserAccountBalanceMapper, UserAccountBalance> implements IUserAccountBalanceService {
}
