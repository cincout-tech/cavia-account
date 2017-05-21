package cn.cincout.cavia.cloud.account.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-13
 * @sine 1.8
 */
@Component
@ConfigurationProperties(prefix = "author")
@Data
public class AuthorInfo {
    private String name;
    private String email;
}
