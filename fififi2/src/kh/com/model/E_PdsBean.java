package kh.com.model;

import java.io.Serializable;
import java.util.Date;

import kh.com.util.DateUtil;

public class E_PdsBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eclass_pds_bbs_seq;	
	private String user_id;
	private String user_name;
	private String title;
	private String content;
	private String filename;
	private String org_filename;

	private int syear;
	private int smonth;
	private int sday;
	
	private int eyear;
	private int emonth;
	private int eday;
	private int sub_seq;
	
	public E_PdsBean() {}
	
	public java.sql.Date getSdate() {return DateUtil.toDate(getSyear(), getSmonth(), getSday());}
	public java.sql.Date getEdate() {return DateUtil.toDate(getEyear(), getEmonth(), getEday());}
	
	
	
	public int getEclass_pds_bbs_seq() {
		return eclass_pds_bbs_seq;
	}

	public void setEclass_pds_bbs_seq(int eclass_pds_bbs_seq) {
		this.eclass_pds_bbs_seq = eclass_pds_bbs_seq;
	}

	public int getSub_seq() {
		return sub_seq;
	}

	public void setSub_seq(int sub_seq) {
		this.sub_seq = sub_seq;
	}

	public String getFilename() {
		return filename;
	}

	public String getOrg_filename() {
		return org_filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setOrg_filename(String org_filename) {
		this.org_filename = org_filename;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getTitle() {
		return title;
	}

	public int getSyear() {
		return syear;
	}

	public int getSmonth() {
		return smonth;
	}

	public int getSday() {
		return sday;
	}

	public int getEyear() {
		return eyear;
	}

	public int getEmonth() {
		return emonth;
	}

	public int getEday() {
		return eday;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSyear(int syear) {
		this.syear = syear;
	}

	public void setSmonth(int smonth) {
		this.smonth = smonth;
	}

	public void setSday(int sday) {
		this.sday = sday;
	}

	public void setEyear(int eyear) {
		this.eyear = eyear;
	}

	public void setEmonth(int emonth) {
		this.emonth = emonth;
	}

	public void setEday(int eday) {
		this.eday = eday;
	}

	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@Override
	public String toString() {
		return "E_PdsBean [eclass_pds_bbs_seq=" + eclass_pds_bbs_seq + ", user_id=" + user_id + ", user_name="
				+ user_name + ", title=" + title + ", content=" + content + ", filename=" + filename + ", org_filename="
				+ org_filename + ", syear=" + syear + ", smonth=" + smonth + ", sday=" + sday + ", eyear=" + eyear
				+ ", emonth=" + emonth + ", eday=" + eday + ", sub_seq=" + sub_seq + "]";
	}
	
	
	
}
