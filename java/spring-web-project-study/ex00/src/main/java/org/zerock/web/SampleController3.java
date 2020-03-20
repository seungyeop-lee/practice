package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController3 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	@RequestMapping("/doD")
	public String doD(Model model) {
		
		//make sample data
		ProductVO product = new ProductVO("Sample Product", 10000);
		
		logger.info("doD");
		
		//저장되는 객체의 클래스명 앞글자를 소문자로 처리한 클래스명을 이름으로 자동 설정
		//model객체는 뷰(jsp)까지 전달된다.
		model.addAttribute(product);
		
		return "productDetail";
		
	}
}
