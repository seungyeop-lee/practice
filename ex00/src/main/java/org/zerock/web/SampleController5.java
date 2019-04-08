package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController5 {

	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {	//@ResponseBody를 붙이면 리턴 타입이 HTTP의 응답 메시지로 전송
		
		ProductVO vo = new ProductVO("샘플상품", 30000);
		
		//jackson-databind가 object를 json형태로 자동 변환
		return vo;
		
	}
	
}
