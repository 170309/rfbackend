package com.rfrongfei.onehammer.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.order.mapper.OrderPayMapper;
import com.rfrongfei.onehammer.order.entity.OrderPay;
import com.rfrongfei.onehammer.order.service.IOrderPayService;
import org.springframework.stereotype.Service;

@Service
public class OrderPayServiceImpl extends ServiceImpl<OrderPayMapper, OrderPay> implements IOrderPayService {
}
