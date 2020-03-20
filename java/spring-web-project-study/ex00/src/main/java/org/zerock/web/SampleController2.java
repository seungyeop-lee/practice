package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	@RequestMapping("doC")
	public String doC(
			//model객체에서 msg를 key값으로 갖는 value를 찾아 자동으로 주입
			//뷰(jsp)로 전달 역할도 함
			@ModelAttribute("msg") String msg) {
		
		logger.info("doC called........................");
		
		//result.jsp 파일을 찾아서 실행
		return "result";
		
	}
}
