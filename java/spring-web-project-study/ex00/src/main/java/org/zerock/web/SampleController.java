package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")	//브라우저에서 doA로 접근 할 경우 이 메소드가 실행된다.
	public void doA() {
		
		logger.info("doA called...................");
		
	}
	
	@RequestMapping("doB")	//브라우저에서 doB로 접근 할 경우 이 메소드가 실행된다.
	public void doB() {
		
		logger.info("doB called...................");
		
	}
}
