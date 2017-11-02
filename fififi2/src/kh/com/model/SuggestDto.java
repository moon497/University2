package kh.com.model;
/*
DROP TABLE SUGGEST
CASCADE CONSTRAINT;

DROP SEQUENCE suggest_seq;

CREATE TABLE SUGGEST(
    suggest_seq number(8) primary key,         -- 시퀀스
    user_id varchar2(50) not null,          -- 아이디
    ref number(8) not null,                 -- 조상 글 
    step number(8) default 0 not null,      -- 높이 
    depth number(8) default 0 not null,     -- 깊이 
    title varchar2(50) not null,            -- 제목
    content varchar2(4000) not null,        -- 내용
    readcount number(8) default 0 not null, -- 읽은 수
    wdate date not null,                    -- 작성한 날
    parent number(8),                       -- 부모 글
    del number(8) default 0 not null,       -- 삭제 여부
    filename varchar2(200),                 -- 파일명
    org_filename varchar2(200)              -- 오리지날 파일명
);

CREATE SEQUENCE SUGGEST_SEQ
START WITH 1 INCREMENT BY 1;

ALTER TABLE SUGGEST
ADD CONSTRAINT FK_SUGGEST_USER_ID FOREIGN KEY(USER_ID)
REFERENCES USERS(USER_ID);

 */
import java.io.Serializable;

public class SuggestDto implements Serializable {

	private int suggest_seq;		        //시퀀스
	private String user_id;        			//아이디
	private int ref;            		    // 조상 글 
	private int step;      				    // 높이 
	private int depth;						// 깊이 
	private String title;           		// 제목
	private String content;        			// 내용
	private int readcount; 					// 읽은 수
	private String wdate;                   // 작성한 날
	private int parent;                     // 부모 글
	private int del;      					// 삭제 여부
	private String filename;                // 파일명
	private String org_filename;            // 오리지날 파일명
	
	public SuggestDto(int suggest_seq, String user_id, int ref, int step, int depth, String title, String content,
			int readcount, String wdate, int parent, int del, String filename, String org_filename) {
		super();
		this.suggest_seq = suggest_seq;
		this.user_id = user_id;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.title = title;
		this.content = content;
		this.readcount = readcount;
		this.wdate = wdate;
		this.parent = parent;
		this.del = del;
		this.filename = filename;
		this.org_filename = org_filename;
	}

	public int getSuggest_seq() {
		return suggest_seq;
	}

	public void setSuggest_seq(int suggest_seq) {
		this.suggest_seq = suggest_seq;
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

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
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

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
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

	@Override
	public String toString() {
		return "SuggestDto [suggest_seq=" + suggest_seq + ", user_id=" + user_id + ", ref=" + ref + ", step=" + step
				+ ", depth=" + depth + ", title=" + title + ", content=" + content + ", readcount=" + readcount
				+ ", wdate=" + wdate + ", parent=" + parent + ", del=" + del + ", filename=" + filename
				+ ", org_filename=" + org_filename + "]";
	}

	
	



}


















