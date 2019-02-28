package com.alvin.springbootvue.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
*
*
*@author: 尹宇
*@mail yinyu@zving.com
*@date:2019年2月28日
*/

@Configuration
@EnableSwagger2
public class Swagger2Config {
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.example"))
        .paths(PathSelectors.any())
        .build();
    }
    
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
            .title("Spring Boot————Swagger2构建Restful APIs")
            .description("消息中心使用")
            .termsOfServiceUrl("https://swagger.io")
            .version("1.0")
            .build();
    }
}
