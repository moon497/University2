package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("E_QnADto")
public class E_QnaDto implements Serializable{
	
	private int eclass_qna_bbs_seq;	
	private String user_id;
	private String user_name;
	
	private int ref;	// 그룹 글 번호
	private int step;   // 답글의 순서
	private int depth;  // 글의 깊이
	
	private String title;
	private String content;
	private String wdate;
	private int parent;
	private int readcount;
	private int sub_seq;
	private int del;
	
	
	public E_QnaDto() {}
	
	
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}


	public int getEclass_qna_bbs_seq() {
		return eclass_qna_bbs_seq;
	}

	public void setEclass_qna_bbs_seq(int eclass_qna_bbs_seq) {
		this.eclass_qna_bbs_seq = eclass_qna_bbs_seq;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
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

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getSub_seq() {
		return sub_seq;
	}

	public void setSub_seq(int sub_seq) {
		this.sub_seq = sub_seq;
	}

	@Override
	public String toString() {
		return "E_QnADto [eclass_qna_bbs_seq=" + eclass_qna_bbs_seq + ", user_id=" + user_id + ", user_name="
				+ user_name + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", title=" + title + ", content="
				+ content + ", wdate=" + wdate + ", parent=" + parent + ", readcount=" + readcount + ", sub_seq="
				+ sub_seq + ", del=" + del + ", getUser_name()=" + getUser_name() + ", getDel()=" + getDel()
				+ ", getEclass_qna_bbs_seq()=" + getEclass_qna_bbs_seq() + ", getUser_id()=" + getUser_id()
				+ ", getRef()=" + getRef() + ", getStep()=" + getStep() + ", getDepth()=" + getDepth() + ", getTitle()="
				+ getTitle() + ", getContent()=" + getContent() + ", getWdate()=" + getWdate() + ", getParent()="
				+ getParent() + ", getReadcount()=" + getReadcount() + ", getSub_seq()=" + getSub_seq()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}

