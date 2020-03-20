package org.zerock;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.zerock.interceptor.SampleInterceptor;

@Configuration	//Spring에서 이 클래스를 설정 파일로 인식
public class App2WebMvcConfig extends WebMvcConfigurerAdapter {	//Spring의 servlet-context.xml의 역할을 함

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SampleInterceptor()).addPathPatterns("/test");
	}
}
