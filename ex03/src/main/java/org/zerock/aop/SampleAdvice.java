package org.zerock.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component	//Spring이 Bean으로 등록
@Aspect	//AOP기능을 하는 클래스 임을 선언
public class SampleAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
	//지정된 메소드의 실행 전에 이 메소드가 실행 됨
	//메소드 지정은 pointcut을 지정하는 문법으로 AspectJ언어의 문법
	//org.zerock.service.MessageService로 시작하는 모든 클래스의 모든 메소드를 지정
	@Before("execution(* org.zerock.service.MessageService*.*(..))")	
	public void startLog() {
		
		logger.info("-----------------------");
		logger.info("-----------------------");
		
	}
	
}
