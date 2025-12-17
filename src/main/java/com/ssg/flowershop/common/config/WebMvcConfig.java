package com.ssg.flowershop.common.config;

/// 스프링에서는 web.xml에서 했었음

import com.ssg.flowershop.common.interceptor.ApiInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // ① 설정 클래스 정의시 사용하는 애너테이션
@RequiredArgsConstructor // ② 빈을 생성자 의존성 주입 애너테 이션
public class WebMvcConfig implements WebMvcConfigurer {

    private final ApiInterceptor apiInterceptor; // ③ 스프링 컨테이너에서 주입해 주는 API 인터셉터

    @Override
    public void addInterceptors(InterceptorRegistry registry) { // ④ 웹 MVC 설정자 인터페이스에서 정의한 메서드 중 addInterceptors 구현
        registry.addInterceptor(apiInterceptor) //적용할 인터셉터 지정
                .addPathPatterns("/v1/api/**")  //인터셉터 적용 URL 경로 지정
                .excludePathPatterns("/v1/api/account/**", "/v1/api/items/**"); // 인터셉터를 적용하지 않을 URL 지정 (계정API 와 상품 API URL 예외 지정)
    }
}