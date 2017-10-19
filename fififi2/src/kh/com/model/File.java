package kh.com.model;

import java.io.Serializable;
import java.text.DecimalFormat;

import org.apache.ibatis.type.Alias;

@Alias("File")
public class File implements Serializable {
	private static final long serialVersionUID = 3379135415341642324L;
	
	//file	
	private int fileSeq;
	private String originalFileName;
	private String storedFileName;
	private Long fileSize;
	private String fileKBSize;
	private String contentType;
	private int downCount;
	private String createAt;
	
	//postFile
	private int postSeq;

	@Override
	public String toString() {
		return "File [fileSeq=" + fileSeq + ", originalFileName=" + originalFileName + ", storedFileName="
				+ storedFileName + ", fileSize=" + fileSize + ", fileKBSize=" + fileKBSize + ", contentType="
				+ contentType + ", downCount=" + downCount + ", createAt=" + createAt + ", postSeq=" + postSeq + "]";
	}

	public String getFileKBSize() {
		DecimalFormat dc = new DecimalFormat("###,###,###");
		
		fileKBSize = dc.format(fileSize / 1024);
		
		return fileKBSize;
	}

	public int getFileSeq() {
		return fileSeq;
	}

	public void setFileSeq(int fileSeq) {
		this.fileSeq = fileSeq;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getStoredFileName() {
		return storedFileName;
	}

	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getDownCount() {
		return downCount;
	}

	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public int getPostSeq() {
		return postSeq;
	}

	public void setPostSeq(int postSeq) {
		this.postSeq = postSeq;
	}
}
