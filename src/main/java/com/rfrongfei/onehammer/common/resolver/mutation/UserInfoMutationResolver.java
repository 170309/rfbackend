package com.rfrongfei.onehammer.common.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.rfrongfei.onehammer.base.util.BeanHelper;
import com.rfrongfei.onehammer.common.entity.User;
import com.rfrongfei.onehammer.common.input.InfoVOInput;
import com.rfrongfei.onehammer.common.input.UserInput;
import com.rfrongfei.onehammer.common.service.IUserService;
import com.rfrongfei.onehammer.common.vo.InfoVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserInfoMutationResolver implements GraphQLMutationResolver {

    private final IUserService userService;

    public User login(UserInput userInput) {
        return userService.login(userInput);
    }

    public InfoVO updateUser(InfoVOInput infoVO) {
        return userService.updateUser(BeanHelper.create(infoVO, InfoVO.class));
    }

    public InfoVO deleteUser(InfoVOInput infoVO) {
        return userService.deleteUser(BeanHelper.create(infoVO, InfoVO.class));
    }

}
