package com.rfrongfei.onehammer.licenses.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.licenses.mapper.LicenseMerchantsMapper;
import com.rfrongfei.onehammer.licenses.entity.LicenseMerchants;
import com.rfrongfei.onehammer.licenses.service.ILicenseMerchantsService;
import org.springframework.stereotype.Service;

@Service
public class LicenseMerchantsServiceImpl extends ServiceImpl<LicenseMerchantsMapper, LicenseMerchants> implements ILicenseMerchantsService {
}
