package com.afterSalesService.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import com.mangofactory.swagger.plugin.EnableSwagger;

/**
 * Swagger配置类
 * @author wjx
 *
 */
@Configuration
@EnableSwagger
@EnableWebMvc
public class SwaggerConfig {
	
	@Bean
    public Docket myDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfo("基础框架", "这是一个项目的基础框架结构，构建新项目可以在这个基础上搭建","1.0","apiDocs","1536999495@qq.com","","");
        docket.apiInfo(apiInfo);
        return docket;
    }
	
}