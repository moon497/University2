package kh.com.model;

import java.io.Serializable;

public class I_StudentGradeDTO implements Serializable {
	// SB.SUB_SEQ, AT.STUDENT_NAME, SB.SUB_SEMESTER,
	// SB.PROFESSOR_NAME, SB.SUB_INFO, SB.SUB_POINT
	private String student_id; 			// USER_ID
	private String student_name; 		// USER_NAME
	private String student_regidate; 	// 입학일
	private int student_term; 			// 총 수강 학기
	private int student_year; 			// 학년
	private int student_total_credit; 	// 총 학점
	private int student_term_grade; 	// 학기 별 성적
	private int student_total_grade; 	// 총 성적

	private int sub_seq; 			// 과목 시퀀스
	private int sub_semester; 		// 학기
	private int sub_category; 		// 전공여부
	private String professor_name; 	// 교수이름
	private String sub_info; 		// 과목명
	private int sub_point; 			// 학점
	private int student_score; 		// 점수(학기별 점수)
	private int professor_grade;    // 교수(강의)평가(완료여부확인용)

	public I_StudentGradeDTO() {   }

	public I_StudentGradeDTO(String student_name, int sub_seq, int sub_semester, int sub_category, String professor_name,
			String sub_info, int sub_point, int student_score) {
		super();
		this.student_name = student_name;
		this.sub_seq = sub_seq;
		this.sub_semester = sub_semester;
		this.sub_category = sub_category;
		this.professor_name = professor_name;
		this.sub_info = sub_info;
		this.sub_point = sub_point;
		this.student_score = student_score;
	}

	public I_StudentGradeDTO(String student_id, String student_name, String student_regidate, int student_term,
			int student_year, int student_total_credit, int student_term_grade, int student_total_grade, int sub_seq,
			int sub_semester, int sub_category, String professor_name, String sub_info, int sub_point,
			int student_score, int professor_grade) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_regidate = student_regidate;
		this.student_term = student_term;
		this.student_year = student_year;
		this.student_total_credit = student_total_credit;
		this.student_term_grade = student_term_grade;
		this.student_total_grade = student_total_grade;
		this.sub_seq = sub_seq;
		this.sub_semester = sub_semester;
		this.sub_category = sub_category;
		this.professor_name = professor_name;
		this.sub_info = sub_info;
		this.sub_point = sub_point;
		this.student_score = student_score;
		this.professor_grade = professor_grade;
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

	public String getStudent_regidate() {
		return student_regidate;
	}

	public void setStudent_regidate(String student_regidate) {
		this.student_regidate = student_regidate;
	}

	public int getStudent_term() {
		return student_term;
	}

	public void setStudent_term(int student_term) {
		this.student_term = student_term;
	}

	public int getStudent_year() {
		return student_year;
	}

	public void setStudent_year(int student_year) {
		this.student_year = student_year;
	}

	public int getStudent_total_credit() {
		return student_total_credit;
	}

	public void setStudent_total_credit(int student_total_credit) {
		this.student_total_credit = student_total_credit;
	}

	public int getStudent_term_grade() {
		return student_term_grade;
	}

	public void setStudent_term_grade(int student_term_grade) {
		this.student_term_grade = student_term_grade;
	}

	public int getStudent_total_grade() {
		return student_total_grade;
	}

	public void setStudent_total_grade(int student_total_grade) {
		this.student_total_grade = student_total_grade;
	}

	public int getSub_seq() {
		return sub_seq;
	}

	public void setSub_seq(int sub_seq) {
		this.sub_seq = sub_seq;
	}

	public int getSub_semester() {
		return sub_semester;
	}

	public void setSub_semester(int sub_semester) {
		this.sub_semester = sub_semester;
	}

	public int getSub_category() {
		return sub_category;
	}

	public void setSub_category(int sub_category) {
		this.sub_category = sub_category;
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

	public int getSub_point() {
		return sub_point;
	}

	public void setSub_point(int sub_point) {
		this.sub_point = sub_point;
	}

	public int getStudent_score() {
		return student_score;
	}

	public void setStudent_score(int student_score) {
		this.student_score = student_score;
	}
	
	public int getProfessor_grade() {
		return professor_grade;
	}

	public void setProfessor_grade(int professor_grade) {
		this.professor_grade = professor_grade;
	}

	@Override
	public String toString() {
		return "StudentGradeDTO [student_id=" + student_id + ", student_name=" + student_name + ", student_regidate="
				+ student_regidate + ", student_term=" + student_term + ", student_year=" + student_year
				+ ", student_total_credit=" + student_total_credit + ", student_term_grade=" + student_term_grade
				+ ", student_total_grade=" + student_total_grade + ", sub_seq=" + sub_seq + ", sub_semester="
				+ sub_semester + ", sub_category=" + sub_category + ", professor_name=" + professor_name + ", sub_info="
				+ sub_info + ", sub_point=" + sub_point + ", student_score=" + student_score + ", professor_grade="
				+ professor_grade + "]";
	}
	
}
