package cafe.jjdev.web.service;

public class FileVo {
	private String fileTitle;
	private String filePath;
	public String getFileTitle() {
		return fileTitle;
	}
	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "FileVo [fileTitle=" + fileTitle + ", filePath=" + filePath + "]";
	}
		
}
