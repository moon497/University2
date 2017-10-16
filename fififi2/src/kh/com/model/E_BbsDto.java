package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("E_BBS_DTO")
public class E_BbsDto implements Serializable{
	private int eclass_notice_bbs_seq;
	private int sub_seq;	
	private String user_id;
	
	private String title;
	private String content;
	private String wdate;
	
	private String filename;
	private String org_filename;
	private int readcount;
	private int del;
	
	public E_BbsDto() {}
	
	public E_BbsDto(int eclass_notice_bbs_seq, int sub_seq, String user_id, String title, String content, String wdate, String filename,
			 int readcount, int del,String org_filename) {
		super();
		eclass_notice_bbs_seq = eclass_notice_bbs_seq;
		this.sub_seq = sub_seq;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.filename = filename;
		this.readcount = readcount;
		this.del = del;
		this.org_filename = org_filename;
	}
	
	public E_BbsDto(String user_id, String title, String content, String filename, String org_filename) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.org_filename = org_filename;
	}

	public E_BbsDto(String user_id, String title, String content, String filename) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.filename = filename;
	}
	
	

	@Override
	public String toString() {
		return "E_BbsDto [eclass_notice_bbs_seq=" + eclass_notice_bbs_seq + ", sub_seq=" + sub_seq + ", user_id="
				+ user_id + ", title=" + title + ", content=" + content + ", wdate=" + wdate + ", filename=" + filename
				+ ", org_filename=" + org_filename + ", readcount=" + readcount + ", del=" + del + "]";
	}

	public int getEclass_notice_bbs_seq() {
		return eclass_notice_bbs_seq;
	}

	public void setEclass_notice_bbs_seq(int eclass_notice_bbs_seq) {
		this.eclass_notice_bbs_seq = eclass_notice_bbs_seq;
	}

	public int getSub_seq() {
		return sub_seq;
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

	public String getContent() {
		return content;
	}

	public String getWdate() {
		return wdate;
	}

	public String getFilename() {
		return filename;
	}

	public String getOrg_filename() {
		return org_filename;
	}

	public int getReadcount() {
		return readcount;
	}

	public int getDel() {
		return del;
	}

	public void setSub_seq(int sub_seq) {
		this.sub_seq = sub_seq;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setOrg_filename(String org_filename) {
		this.org_filename = org_filename;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public void setDel(int del) {
		this.del = del;
	}
	
}
