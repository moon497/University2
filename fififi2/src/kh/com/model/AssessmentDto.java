package kh.com.model;
/*
CREATE TABLE assessment(
    SUB_SEQ_NUM NUMBER PRIMARY KEY,                     -- 과목번호
    STUDENT_ID VARCHAR2(30),                            -- 학생ID
    STUDENT_NAME VARCHAR2(50 BYTE),                     -- 학생이름
    PROFESSOR_ID VARCHAR2(50 BYTE),                     -- 교수ID
    PROFESSOR_NAME VARCHAR2(50 BYTE),                   -- 교수이름
    PROFESSOR_GRADE NUMBER,                                       -- 교수평가점수(총 합이 아니고 몇번문항에 몇점을 찍었는지에 대한 점수가 들어감)                 
    STUDENT_SCORE NUMBER,
    CONSTRAINT FK_assessment FOREIGN KEY(SUB_SEQ_NUM)
    REFERENCES SUBJECT(SUB_SEQ)
);
*/
import java.io.Serializable;
import org.apache.ibatis.type.Alias;

@Alias("Assessment")
public class AssessmentDto implements Serializable {
	private static final long serialVersionUID = -6977015862285234497L;
	
	private int sub_seq_num;
	private String student_id;
	private String student_name;
	private String professor_id;
	private String professor_name;
	private int professor_grade;
	private int student_score;
	
	//subject조인용 변수
	private String sub_name;		 	 // 과목명 
	
	public AssessmentDto() {}

	public int getSub_seq_num() {
		return sub_seq_num;
	}

	public void setSub_seq_num(int sub_seq_num) {
		this.sub_seq_num = sub_seq_num;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(String professor_id) {
		this.professor_id = professor_id;
	}

	public String getProfessor_name() {
		return professor_name;
	}

	public void setProfessor_name(String professor_name) {
		this.professor_name = professor_name;
	}

	public int getProfessor_grade() {
		return professor_grade;
	}

	public void setProfessor_grade(int professor_grade) {
		this.professor_grade = professor_grade;
	}

	public int getStudent_score() {
		return student_score;
	}

	public void setStudent_score(int student_score) {
		this.student_score = student_score;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	@Override
	public String toString() {
		return "AssessmentDto [sub_seq_num=" + sub_seq_num + ", student_id=" + student_id + ", student_name="
				+ student_name + ", professor_id=" + professor_id + ", professor_name=" + professor_name
				+ ", professor_grade=" + professor_grade + ", student_score=" + student_score + ", sub_name=" + sub_name
				+ "]";
	}

	
	
	
	
	

}