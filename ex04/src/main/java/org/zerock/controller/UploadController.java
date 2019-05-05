package org.zerock.controller;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.util.UploadFileUtils;

@Controller
public class UploadController {
	
	@Resource(name = "uploadPath")
	private String uploadPath;

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value = "/uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
		
	}
	
	@RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
	public String uploadForm(MultipartFile file, Model model) throws Exception {
		
		logger.info("originalName: " + file.getOriginalFilename());	//파일 이름 출력
		logger.info("size: " + file.getSize());	//파일 크기 출력
		logger.info("contentType: " + file.getContentType());	//파일 MIME타입 출력
		
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		
		model.addAttribute("savedName", savedName);
		
		return "uploadResult";
		
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		
		File target = new File(uploadPath, savedName);
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadAjax", 
		method = RequestMethod.POST, 
		produces = "text/plain;charset=UTF-8")	//결과 반환 시, 한국어를 정상적으로 전송하기 위한 설정
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		
		logger.info("originalName: " + file.getOriginalFilename());
		
		return new ResponseEntity<>(
				UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()), 
				HttpStatus.CREATED);
		
	}
	
}
