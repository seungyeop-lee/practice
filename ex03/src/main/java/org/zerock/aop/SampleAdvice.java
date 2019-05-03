package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
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
	public void startLog(JoinPoint jp) {
		
		logger.info("-----------------------");
		logger.info("-----------------------");
		
		//전달되는 모든 파라미터를  Object배열로 받아서 출력
		logger.info(Arrays.toString(jp.getArgs()));
		
		//해당 Advice의 타입을 출력
//		logger.info(jp.getKind());
		//실행하는 대상객체의 method정보를 출력
//		logger.info(jp.getSignature().toLongString());
		//target객체의 type이름을 출력
//		logger.info(jp.getTarget().getClass().getTypeName());
		//Advice를 행하는 객체의 type이름을 출력
//		logger.info(jp.getThis().getClass().getTypeName());
	}
	
}
