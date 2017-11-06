package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("introBbs")

public class IntroBbsDto implements Serializable {
	private int intro_bbs_seq;
	private String user_id;
	private String title;
	private String content;
	private int readcount;
	private String filename;
	private String org_filename;
	private String wdate;
	
	private int recordCountPerPage = 3;
	private int pageNumber = 0;
	
	private int start = 1;
	private int end = 3;
	
	public IntroBbsDto() {
	}
	
	public IntroBbsDto(int intro_bbs_seq, String user_id, String title, String content, int readcount, String filename,
			String org_filename, String wdate) {
		this.intro_bbs_seq = intro_bbs_seq;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.readcount = readcount;
		this.filename = filename;
		this.org_filename = org_filename;
		this.wdate = wdate;
	}
	
	

	public IntroBbsDto(int intro_bbs_seq, String user_id, String title, String content, int readcount, String filename,
			String org_filename, String wdate, int recordCountPerPage, int pageNumber, int start, int end) {
		this.intro_bbs_seq = intro_bbs_seq;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.readcount = readcount;
		this.filename = filename;
		this.org_filename = org_filename;
		this.wdate = wdate;
		this.recordCountPerPage = recordCountPerPage;
		this.pageNumber = pageNumber;
		this.start = start;
		this.end = end;
	}

	public int getIntro_bbs_seq() {
		return intro_bbs_seq;
	}

	public void setIntro_bbs_seq(int intro_bbs_seq) {
		this.intro_bbs_seq = intro_bbs_seq;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getOrg_filename() {
		return org_filename;
	}

	public void setOrg_filename(String org_filename) {
		this.org_filename = org_filename;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	

}
