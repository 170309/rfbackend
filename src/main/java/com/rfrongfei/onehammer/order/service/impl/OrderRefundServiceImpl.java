package com.rfrongfei.onehammer.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.order.mapper.OrderRefundMapper;
import com.rfrongfei.onehammer.order.entity.OrderRefund;
import com.rfrongfei.onehammer.order.service.IOrderRefundService;
import org.springframework.stereotype.Service;

@Service
public class OrderRefundServiceImpl extends ServiceImpl<OrderRefundMapper, OrderRefund> implements IOrderRefundService {
}
