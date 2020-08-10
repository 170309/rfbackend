package com.rfrongfei.onehammer.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.order.mapper.OrderMapper;
import com.rfrongfei.onehammer.order.entity.Order;
import com.rfrongfei.onehammer.order.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
}
