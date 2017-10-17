package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("introBbs")

public class IntroBbsDto implements Serializable {
	int intro_bbs_seq;
	String user_id;
	String title;
	String content;
	int readcount;
	String filename;
	String org_filename;
	String wdate;
	
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

	@Override
	public String toString() {
		return "IntroBbsDto [intro_bbs_seq=" + intro_bbs_seq + ", user_id=" + user_id + ", title=" + title
				+ ", content=" + content + ", readcount=" + readcount + ", filename=" + filename + ", org_filename="
				+ org_filename + ", wdate=" + wdate + "]";
	}
	
	
	
	
	
	

}
