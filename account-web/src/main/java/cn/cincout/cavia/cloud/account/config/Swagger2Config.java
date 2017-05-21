package cn.cincout.cavia.cloud.account.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zhaoyu on 16-9-14.
 *
 * @author zhaoyu
 * @date 17-4-12
 * @sine 1.8
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRESTFulApi(@Autowired ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.cincout.cavia.cloud.account.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Cavia-Cloud-Account RESTFul Api Document")
                .description("http://apm.cincout.cn")
                .termsOfServiceUrl("http://blog.cincout.cn")
                .contact(new Contact("TRAMP", "http://zzy.cincout.cn", "china.zhangzhaoyu@gmail.com"))
                .version("1.0")
                .build();
    }

}
