package com.rfrongfei.onehammer.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.goods.mapper.GoodsCategoryMapper;
import com.rfrongfei.onehammer.goods.entity.GoodsCategory;
import com.rfrongfei.onehammer.goods.service.IGoodsCategoryService;
import org.springframework.stereotype.Service;

@Service
public class GoodsCategoryServiceImpl extends ServiceImpl<GoodsCategoryMapper, GoodsCategory> implements IGoodsCategoryService {
}
