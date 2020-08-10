package com.rfrongfei.onehammer.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.order.mapper.OrderProgressMapper;
import com.rfrongfei.onehammer.order.entity.OrderProgress;
import com.rfrongfei.onehammer.order.service.IOrderProgressService;
import org.springframework.stereotype.Service;

@Service
public class OrderProgressServiceImpl extends ServiceImpl<OrderProgressMapper, OrderProgress> implements IOrderProgressService {
}
