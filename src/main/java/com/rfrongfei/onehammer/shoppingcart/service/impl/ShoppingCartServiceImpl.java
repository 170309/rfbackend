package com.rfrongfei.onehammer.shoppingcart.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.shoppingcart.mapper.ShoppingCartMapper;
import com.rfrongfei.onehammer.shoppingcart.entity.ShoppingCart;
import com.rfrongfei.onehammer.shoppingcart.service.IShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements IShoppingCartService {
}
