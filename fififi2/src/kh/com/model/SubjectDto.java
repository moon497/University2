package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
/*
DROP TABLE SUBJECT
CASCADE CONSTRAINTS;

DROP SEQUENCE SUB_SEQ;

CREATE TABLE SUBJECT(
    SUB_SEQ NUMBER(8) PRIMARY KEY,
    SUB_CATEGORY VARCHAR2(50) NOT NULL,         -- 전공:100,교양:200
    MAJOR_NUMBER VARCHAR2(50) NOT NULL,         -- 없음:0,기계공학과:100,전기공학과:200,컴퓨터공학과:300...       
    SUB_GRADE NUMBER(8) NOT NULL,               -- 학년
    SUB_SEMESTER NUMBER(8) NOT NULL,            -- 학기(1~2)  
    SUB_NAME VARCHAR2(50),                      -- 과목명
    PROFESSOR_ID VARCHAR2(50) NOT NULL,         -- 교수아이디 외래키
    PROFESSOR_NAME VARCHAR2(50) NOT NULL,       -- 교수명 외래키
    SUB_INFO VARCHAR2(4000) NOT NULL,           -- 강의 소개
    SUB_ROOM VARCHAR2(255) NOT NULL,            -- 강의실
    SUB_WEEK VARCHAR2(50) NOT NULL,                -- 1 ~ 5 (월~금)
    SUB_S_CLASS NUMBER(8) NOT NULL,             -- 1 ~ 10 (1~10교시) 시작 교시
    SUB_E_CLASS NUMBER(8) NOT NULL,             -- 1 ~ 10 (1~10교시) 끝나는 교시
    SUB_MAX_STUDENT NUMBER NOT NULL,            -- 최대 인원수
    SUB_NOW_STUDENT NUMBER DEFAULT 0 NOT NULL,  -- 현재 인원수
    SUB_POINT NUMBER NOT NULL,                  -- 학점(1~3)
    SUB_REF NUMBER(8) NOT NULL,                 -- 참조 글
    SUB_PARENT NUMBER(8) NOT NULL               -- 부모 글 
);
CREATE SEQUENCE SUB_SEQ
START WITH 1 INCREMENT BY 1; 

ALTER TABLE SUBJECT
ADD CONSTRAINT FK_SUB_UID FOREIGN KEY(PROFESSOR_ID)
REFERENCES USERS(USER_ID);  
*/
@Alias("SubjectDto")
public class SubjectDto implements Serializable{
	private int sub_seq;				
	  
	private String sub_category; 		 // 전공 : 100, 교양 : 200
	private String major_number;		 // 없음:0,기계공학과:100,전기공학과:200,컴퓨터공학과:300...
	
	private int sub_grade;				 // 학년 ( 1 ~ 4)
	private int sub_semester;			 // 학기 ( 1 ~ 2)
	
	private String sub_name;		 	 // 과목명 
    private String professor_id;		 // 교수아이디 외래키
    private String professor_name;		 // 교수명 
    private String sub_info;             // 강의 소개
    private String sub_room;             // 강의실
    
    private String sub_week;				 // 월~금 ( 1~5)
    
    private int sub_s_class;			 // 1~10교시 (1~10) 시작교시
    private int sub_e_class;			 // 1~10  끝교시
    
    private int sub_max_student;         // 최대 인원수
    private int sub_now_student;   		 // 현재 인원수
    private int sub_point; 				 // 학점(1~3)
    
    private int sub_ref;				 // 글 그룹 번호
    private int sub_parent;				 //	참조하는 글
        
    
    public SubjectDto() {}


	public SubjectDto(int sub_seq, String sub_category, String major_number, int sub_grade, int sub_semester,
			String sub_name, String professor_id, String professor_name, String sub_info, String sub_room,
			String sub_week, int sub_s_class, int sub_e_class, int sub_max_student, int sub_now_student, int sub_point,
			int sub_ref, int sub_parent) {
		super();
		this.sub_seq = sub_seq;
		this.sub_category = sub_category;
		this.major_number = major_number;
		this.sub_grade = sub_grade;
		this.sub_semester = sub_semester;
		this.sub_name = sub_name;
		this.professor_id = professor_id;
		this.professor_name = professor_name;
		this.sub_info = sub_info;
		this.sub_room = sub_room;
		this.sub_week = sub_week;
		this.sub_s_class = sub_s_class;
		this.sub_e_class = sub_e_class;
		this.sub_max_student = sub_max_student;
		this.sub_now_student = sub_now_student;
		this.sub_point = sub_point;
		this.sub_ref = sub_ref;
		this.sub_parent = sub_parent;
	}


	public int getSub_seq() {
		return sub_seq;
	}


	public void setSub_seq(int sub_seq) {
		this.sub_seq = sub_seq;
	}


	public String getSub_category() {
		return sub_category;
	}


	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}


	public String getMajor_number() {
		return major_number;
	}


	public void setMajor_number(String major_number) {
		this.major_number = major_number;
	}


	public int getSub_grade() {
		return sub_grade;
	}


	public void setSub_grade(int sub_grade) {
		this.sub_grade = sub_grade;
	}


	public int getSub_semester() {
		return sub_semester;
	}


	public void setSub_semester(int sub_semester) {
		this.sub_semester = sub_semester;
	}


	public String getSub_name() {
		return sub_name;
	}


	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
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


	public String getSub_info() {
		return sub_info;
	}


	public void setSub_info(String sub_info) {
		this.sub_info = sub_info;
	}


	public String getSub_room() {
		return sub_room;
	}


	public void setSub_room(String sub_room) {
		this.sub_room = sub_room;
	}


	public String getSub_week() {
		return sub_week;
	}


	public void setSub_week(String sub_week) {
		this.sub_week = sub_week;
	}


	public int getSub_s_class() {
		return sub_s_class;
	}


	public void setSub_s_class(int sub_s_class) {
		this.sub_s_class = sub_s_class;
	}


	public int getSub_e_class() {
		return sub_e_class;
	}


	public void setSub_e_class(int sub_e_class) {
		this.sub_e_class = sub_e_class;
	}


	public int getSub_max_student() {
		return sub_max_student;
	}


	public void setSub_max_student(int sub_max_student) {
		this.sub_max_student = sub_max_student;
	}


	public int getSub_now_student() {
		return sub_now_student;
	}


	public void setSub_now_student(int sub_now_student) {
		this.sub_now_student = sub_now_student;
	}


	public int getSub_point() {
		return sub_point;
	}


	public void setSub_point(int sub_point) {
		this.sub_point = sub_point;
	}


	public int getSub_ref() {
		return sub_ref;
	}


	public void setSub_ref(int sub_ref) {
		this.sub_ref = sub_ref;
	}


	public int getSub_parent() {
		return sub_parent;
	}


	public void setSub_parent(int sub_parent) {
		this.sub_parent = sub_parent;
	}


	@Override
	public String toString() {
		return "SubjectDto [sub_seq=" + sub_seq + ", sub_category=" + sub_category + ", major_number=" + major_number
				+ ", sub_grade=" + sub_grade + ", sub_semester=" + sub_semester + ", sub_name=" + sub_name
				+ ", professor_id=" + professor_id + ", professor_name=" + professor_name + ", sub_info=" + sub_info
				+ ", sub_room=" + sub_room + ", sub_week=" + sub_week + ", sub_s_class=" + sub_s_class
				+ ", sub_e_class=" + sub_e_class + ", sub_max_student=" + sub_max_student + ", sub_now_student="
				+ sub_now_student + ", sub_point=" + sub_point + ", sub_ref=" + sub_ref + ", sub_parent=" + sub_parent
				+ "]";
	}

	
}












