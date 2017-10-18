package kh.com.model;

import java.util.Date;

public class E_CommentDto {

	private int eclass_pds_bbs_seq;
	private int c_seq;
	private int sub_seq;
	private String c_content;
	private String user_id;
	private String user_name;
	private String filename;
	private String org_filename;
	private Date wdate;

	public E_CommentDto() {}

	
	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public int getSub_seq() {
		return sub_seq;
	}

	public void setSub_seq(int sub_seq) {
		this.sub_seq = sub_seq;
	}

	public int getEclass_pds_bbs_seq() {
		return eclass_pds_bbs_seq;
	}

	public int getC_seq() {
		return c_seq;
	}

	public String getC_content() {
		return c_content;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getFilename() {
		return filename;
	}

	public String getOrg_filename() {
		return org_filename;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setEclass_pds_bbs_seq(int eclass_pds_bbs_seq) {
		this.eclass_pds_bbs_seq = eclass_pds_bbs_seq;
	}

	public void setC_seq(int c_seq) {
		this.c_seq = c_seq;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setOrg_filename(String org_filename) {
		this.org_filename = org_filename;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}



	@Override
	public String toString() {
		return "E_CommentDto [eclass_pds_bbs_seq=" + eclass_pds_bbs_seq + ", c_seq=" + c_seq + ", sub_seq=" + sub_seq
				+ ", c_content=" + c_content + ", user_id=" + user_id + ", filename=" + filename + ", org_filename="
				+ org_filename + ", wdate=" + wdate + "]";
	}

	
	
	
	
}
