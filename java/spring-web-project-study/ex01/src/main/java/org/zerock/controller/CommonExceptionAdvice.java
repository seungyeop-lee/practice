package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice	//예외 처리 클래스의 역할을 맡김
public class CommonExceptionAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)	//지정한 예외가 발생했을 경우 메소드가 실행
	private ModelAndView errorModelAndView(Exception ex) {	//지정한 예외와 같은 타입만 파라미터로 설정 가능
		
		//model과 view의 처리를 동시에 할 수 있는 객체
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", ex);
		
		return modelAndView;
		
	}
}
