package cafe.jjdev.web.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cafe.jjdev.web.FileRequest;

@Service
public class FileuploadService {
	
	
	public int fileupload(FileRequest fileRequest) {
		MultipartFile file = fileRequest.getFile();
		String fileName = file.getOriginalFilename();
		int pos = fileName.lastIndexOf("."); // 마지막 점(.)의 위치 찾기.  
		System.out.println("lastindexot>>" + pos);
		String ext = fileName.substring(pos+1);
		System.out.println("filename >> " + fileName);
		System.out.println("ext >> " + ext);
		
		
		UUID uuid = UUID.randomUUID();
		String name = uuid.toString();
		System.out.println("name >> " + name);
		name = name.replaceAll("-", "");
		System.out.println("name >> " + name);
		
		System.out.println("lastname >> " + name + "." + ext);
		
		File destfile = new File("C:/upload/"+name+"."+ext);
		try {
			file.transferTo(destfile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		FileVo fileVo = new FileVo();
		fileVo.setFileTitle(fileRequest.getFileTitle());
		fileVo.setFilePath("c:/upload/"+name+"."+ext); 
		// 1. 파일을 폴더 저장
		// 2. fileRequest -> FileVo
		// 3. FileDao.insertFile() 메서드 호출
		
		
		return 0;
	}
}
