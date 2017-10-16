package cafe.jjdev.web;

import org.junit.internal.requests.FilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cafe.jjdev.web.service.FileuploadService;

@Controller
public class FileuploadController {
	
	@Autowired
	private FileuploadService fileuploadService;
	
	// file upload 폼
	@RequestMapping(value="/fileAdd", method = RequestMethod.GET)
	public String fileAdd() {
		
		
		return "fileAdd";
	}
	
	// flie upload 액션
	@RequestMapping(value="/fileAdd", method = RequestMethod.POST)
	public String fileAdd(FileRequest fileRequest) {
		System.out.println(fileRequest);
		// 파일을 폴더에 저장하는 로직
		fileuploadService.fileupload(fileRequest);
		return "";
		
	}
	

}
