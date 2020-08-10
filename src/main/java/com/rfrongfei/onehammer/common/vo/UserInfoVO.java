package com.rfrongfei.onehammer.common.vo;

import com.rfrongfei.onehammer.base.entity.UserInfo;
import com.rfrongfei.onehammer.common.entity.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserInfoVO {
    private UserInfo userInfo;
    private User user;
}
