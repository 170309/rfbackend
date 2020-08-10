package com.rfrongfei.onehammer.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.order.mapper.OrderDetailMapper;
import com.rfrongfei.onehammer.order.entity.OrderDetail;
import com.rfrongfei.onehammer.order.service.IOrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements IOrderDetailService {
}
