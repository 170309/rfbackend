package com.rfrongfei.onehammer.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.goods.mapper.GoodsMapper;
import com.rfrongfei.onehammer.goods.entity.Goods;
import com.rfrongfei.onehammer.goods.service.IGoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {
}
