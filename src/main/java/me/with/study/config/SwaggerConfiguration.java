package me.with.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api(){ // 도큐멘테이션 플러그인을 상속받음
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) // api의 정보
                .select()
                .apis(RequestHandlerSelectors.basePackage("me.with.study"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Spring Boot OPEN API Test with Swagger")
                .description("새로 만든 스프링 부트!!")
                .version("1.0.0")
                .build();
    }
}
