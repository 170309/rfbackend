package com.rfrongfei.onehammer.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.order.mapper.OrderDeliveryMapper;
import com.rfrongfei.onehammer.order.entity.OrderDelivery;
import com.rfrongfei.onehammer.order.service.IOrderDeliveryService;
import org.springframework.stereotype.Service;

@Service
public class OrderDeliveryServiceImpl extends ServiceImpl<OrderDeliveryMapper, OrderDelivery> implements IOrderDeliveryService {
}
