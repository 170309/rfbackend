package com.rfrongfei.onehammer.coupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.coupon.mapper.CouponMapper;
import com.rfrongfei.onehammer.coupon.entity.Coupon;
import com.rfrongfei.onehammer.coupon.service.ICouponService;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements ICouponService {
}
