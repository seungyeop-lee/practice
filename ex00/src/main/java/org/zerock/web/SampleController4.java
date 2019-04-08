package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr) {
		
		logger.info("doE called but redirect to /doF............");
		
		//redirect 할 때 넘겨줄 데이터를 key와 value로 저장
		rttr.addFlashAttribute("msg", "This is the Message!! with redirected");
		
		//redirect:가 붙으면 뒤에오는 URI로 리다이렉트
		return "redirect:/doF";
		
		//forward:를 사용하면 뒤에오는 URI로 포워드
	}
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("msg") String msg) {
		
		logger.info("doF called........." + msg);
		
	}
	
}
