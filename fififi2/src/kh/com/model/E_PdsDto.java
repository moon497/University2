package kh.com.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import kh.com.util.DateUtil;

@Alias("E_PDS_DTO")
public class E_PdsDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eclass_pds_bbs_seq;
	
	private String user_id;
	private String user_name;
	private String title;
	private String content;
	private int readcount;
	private String filename;
	private String org_filename;
	
	private int status;
	private Date wdate;
	private Date sdate;
	private Date edate;
	private int sub_seq;
	
	public E_PdsDto() {}

	
	
	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public int getEclass_pds_bbs_seq() {
		return eclass_pds_bbs_seq;
	}

	public String getUser_id() {
		return user_id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public int getReadcount() {
		return readcount;
	}

	public String getFilename() {
		return filename;
	}

	public String getOrg_filename() {
		return org_filename;
	}

	public int getStatus() {
		return status;
	}

	public Date getWdate() {
		return wdate;
	}

	public Date getSdate() {
		return sdate;
	}

	public Date getEdate() {
		return edate;
	}

	public int getSub_seq() {
		return sub_seq;
	}

	public void setEclass_pds_bbs_seq(int eclass_pds_bbs_seq) {
		this.eclass_pds_bbs_seq = eclass_pds_bbs_seq;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setOrg_filename(String org_filename) {
		this.org_filename = org_filename;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	public void setSub_seq(int sub_seq) {
		this.sub_seq = sub_seq;
	}

	public E_PdsDto(String user_id, String title, String content, String filename, String org_filename,
			Date sdate, Date edate, int sub_seq) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.org_filename = org_filename;
		this.sdate = sdate;
		this.edate = edate;
		this.sub_seq = sub_seq;
	}
	
	
	public E_PdsDto(int eclass_pds_bbs_seq, String title, String content, String filename, String org_filename,
			Date sdate, Date edate) {
		super();
		this.eclass_pds_bbs_seq = eclass_pds_bbs_seq;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.org_filename = org_filename;
		this.sdate = sdate;
		this.edate = edate;
	}



	@Override
	public String toString() {
		return "E_PdsDto [eclass_pds_bbs_seq=" + eclass_pds_bbs_seq + ", user_id=" + user_id + ", user_name="
				+ user_name + ", title=" + title + ", content=" + content + ", readcount=" + readcount + ", filename="
				+ filename + ", org_filename=" + org_filename + ", status=" + status + ", wdate=" + wdate + ", sdate="
				+ sdate + ", edate=" + edate + ", sub_seq=" + sub_seq + "]";
	}

	
	
	
	
}