package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/*
	CREATE TABLE ENROLL(
	    SUB_SEQ NUMBER NOT NULL,                            --과목SEQ
	    USER_ID VARCHAR2(50) NOT NULL,                      --USER_ID
	    GRADE NUMBER DEFAULT 0 NOT NULL,                    --성적(0.0~4.0)
	    CONSTRAINT ENROLL_PK PRIMARY KEY(SUB_SEQ,USER_ID),
	    CONSTRAINT ENROLL_FK FOREIGN KEY(SUB_SEQ)
	    REFERENCES SUBJECT(SUB_SEQ) ON DELETE CASCADE,
	    CONSTRAINT ENROLL_FK2 FOREIGN KEY(USER_ID)
	    REFERENCES USERS(USER_ID) ON DELETE CASCADE
	);
*/
@Alias("enrollDto")
public class EnrollDto implements Serializable {

	private int sub_seq;				// 과목SEQ
	private String user_id;				// USER_ID
	private int grade;					// 성적(0.0~4.0)
	
	public EnrollDto() {}

	public EnrollDto(int sub_seq, String user_id, int grade) {
		super();
		this.sub_seq = sub_seq;
		this.user_id = user_id;
		this.grade = grade;
	}

	public int getSub_seq() {
		return sub_seq;
	}

	public void setSub_seq(int sub_seq) {
		this.sub_seq = sub_seq;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "EnrollDto [sub_seq=" + sub_seq + ", user_id=" + user_id + ", grade=" + grade + "]";
	}
	
}