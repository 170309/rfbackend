package com.rfrongfei.onehammer.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rfrongfei.onehammer.common.mapper.NoticeMapper;
import com.rfrongfei.onehammer.common.entity.Notice;
import com.rfrongfei.onehammer.common.service.INoticeService;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {
}
