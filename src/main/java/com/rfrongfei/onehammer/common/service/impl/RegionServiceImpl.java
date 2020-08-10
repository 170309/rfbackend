package com.rfrongfei.onehammer.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.common.mapper.RegionMapper;
import com.rfrongfei.onehammer.common.entity.Region;
import com.rfrongfei.onehammer.common.service.IRegionService;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region> implements IRegionService {
}
