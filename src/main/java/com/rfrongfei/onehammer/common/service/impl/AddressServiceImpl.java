package com.rfrongfei.onehammer.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.common.mapper.AddressMapper;
import com.rfrongfei.onehammer.common.entity.Address;
import com.rfrongfei.onehammer.common.service.IAddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {
}
