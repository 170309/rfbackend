package com.rfrongfei.onehammer.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.coupon.mapper.CouponRecordMapper;
import com.rfrongfei.onehammer.coupon.entity.CouponRecord;
import com.rfrongfei.onehammer.coupon.service.ICouponRecordService;
import org.springframework.stereotype.Service;

@Service
public class CouponRecordServiceImpl extends ServiceImpl<CouponRecordMapper, CouponRecord> implements ICouponRecordService {
}
