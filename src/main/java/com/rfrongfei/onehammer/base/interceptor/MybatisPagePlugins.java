package com.rfrongfei.onehammer.base.interceptor;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
public class MybatisPagePlugins {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // pageInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // pageInterceptor.setLimit(500);
        return new PaginationInterceptor();
    }
}
