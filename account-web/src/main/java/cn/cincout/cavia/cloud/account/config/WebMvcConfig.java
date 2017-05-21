package cn.cincout.cavia.cloud.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-13
 * @sine 1.8
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    // config web mvc info to override spring boot config
    // if u want to disable spring config, u need to use @EnableWebMvc annotation
}
