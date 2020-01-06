package com.tistory.codingtrainee.controller.upload;

import java.io.File;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	// servlet-context에 설정되어 있는 리소스를 참조한다
	// bean의 id가 uploadPath인 태그를 참조한다는 의미를 가지고 있다
	@Resource(name = "uploadPath")
	String uploadPath;
	
	// 내용이 없는 상태로 uploadForm을 호출하면 이 메소드 부분으로 도착한다.
	@RequestMapping(value = "/upload/upload_form", method = RequestMethod.GET)
	public void uploadForm() {
		// upload/uploadForm.jsp로 포워딩된다
	}
	
	@RequestMapping(value = "/upload/upload_form", method = RequestMethod.POST)
	public ModelAndView uploadForm(MultipartFile file, ModelAndView modelView) throws Exception {
		// 한글 깨짐현상을 발견해 값을 받을 때 디코딩시켜주는 코드를 추가했다
		String fileName = new String(file.getOriginalFilename().getBytes("8859_1"), "UTF-8"); 
		
		logger.info("파일 이름 : " + file.getOriginalFilename());
		fileName = file.getOriginalFilename();
		logger.info("파일 크기 : " + file.getSize());
		logger.info("컨텐트 타입 : " + file.getContentType());
		
		fileName = uploadFile(fileName, file.getBytes());
		
		modelView.setViewName("upload/upload_result");
		modelView.addObject("fileName", fileName);
		
		// jsp에서 지정해둔 upload_result.jsp로 포워딩된다
		return modelView;
	}
	
	// 파일 이름은 중복되지 않도록 처리했다
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		// Universal Unique IDentifier(범용 고유 식별자)를 생성한다 (랜덤으로 코드를 생성하는 기능을 하는데 거의 중복되는 일이 없다)
		UUID uid = UUID.randomUUID();
		String fileName = uid.toString() + "_" + originalName;
		File targetFile = new File(uploadPath, fileName);
		
		// 임시 저장공간에 보관된 업로드 파일을 실제 저장하기로 했던 디렉토리로 복사해 옮긴다.
		FileCopyUtils.copy(fileData, targetFile);
		
		return fileName;
	}
}
