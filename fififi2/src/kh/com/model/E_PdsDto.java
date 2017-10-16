package kh.com.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import kh.com.util.DateUtil;

@Alias("E_PDS_DTO")
public class E_PdsDto implements Serializable{
	
	private int ECLASS_PDS_BBS_SEQ;
	private int ref;
	private int step;
	private int depth;
	private String user_id;
	
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

	public E_PdsDto(int eCLASS_PDS_BBS_SEQ, int ref, int step, int depth, String user_id, String title, String content,
			int readcount, String filename, String org_filename, int status, Date wdate, Date sdate, Date edate,
			int sub_seq) {
		super();
		ECLASS_PDS_BBS_SEQ = eCLASS_PDS_BBS_SEQ;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.readcount = readcount;
		this.filename = filename;
		this.org_filename = org_filename;
		this.status = status;
		this.wdate = wdate;
		this.sdate = sdate;
		this.edate = edate;
		this.sub_seq = sub_seq;
	}

	public E_PdsDto(String user_id, String title, String content, String filename, String org_filename) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.org_filename = org_filename;
	}
	
	public E_PdsDto(String user_id, String title, String content, String filename, String org_filename, Date sdate,
			Date edate) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.filename = filename;
		this.org_filename = org_filename;
		this.sdate = sdate;
		this.edate = edate;
	}

	public E_PdsDto(String filename, String org_filename) {
		super();
		this.filename = filename;
		this.org_filename = org_filename;
	}

	public E_PdsDto(String user_id, String title, String content, Date sdate, Date edate) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.content = content;
		this.sdate = sdate;
		this.edate = edate;
	}

	public int getECLASS_PDS_BBS_SEQ() {
		return ECLASS_PDS_BBS_SEQ;
	}

	public int getRef() {
		return ref;
	}

	public int getStep() {
		return step;
	}

	public int getDepth() {
		return depth;
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

	public void setECLASS_PDS_BBS_SEQ(int eCLASS_PDS_BBS_SEQ) {
		ECLASS_PDS_BBS_SEQ = eCLASS_PDS_BBS_SEQ;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public void setDepth(int depth) {
		this.depth = depth;
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

	@Override
	public String toString() {
		return "E_PdsDto [ECLASS_PDS_BBS_SEQ=" + ECLASS_PDS_BBS_SEQ + ", ref=" + ref + ", step=" + step + ", depth="
				+ depth + ", user_id=" + user_id + ", title=" + title + ", content=" + content + ", readcount="
				+ readcount + ", filename=" + filename + ", org_filename=" + org_filename + ", status=" + status
				+ ", wdate=" + wdate + ", sdate=" + sdate + ", edate=" + edate + ", sub_seq=" + sub_seq + "]";
	}
	
	
	
	
	
}