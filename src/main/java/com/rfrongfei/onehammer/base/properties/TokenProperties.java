package com.rfrongfei.onehammer.base.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName TokenProperties
 * @Author Jxlsx
 * @Date 2019/12/17 下午6:42
 * @Version 1.0
 */
@Component
@PropertySource(value = "classpath:config/settings.properties")
@ConfigurationProperties(prefix = "token")
@Data
public class TokenProperties {

    /** token过期时间 */
    private Integer expire;
    /** token刷新时间 */
    private Integer flush;

}
