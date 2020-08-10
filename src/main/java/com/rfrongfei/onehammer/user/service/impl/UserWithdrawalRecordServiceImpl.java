package com.rfrongfei.onehammer.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.user.mapper.UserWithdrawalRecordMapper;
import com.rfrongfei.onehammer.user.entity.UserWithdrawalRecord;
import com.rfrongfei.onehammer.user.service.IUserWithdrawalRecordService;
import org.springframework.stereotype.Service;

@Service
public class UserWithdrawalRecordServiceImpl extends ServiceImpl<UserWithdrawalRecordMapper, UserWithdrawalRecord> implements IUserWithdrawalRecordService {
}
