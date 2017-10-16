package kh.com.model;

import java.io.Serializable;

public class StudentGradeDTO implements Serializable {

	private String student_id; 			// USER_ID
	private String student_name; 		// USER_NAME
	private String student_regidate; 	// 입학일
	private int student_term; 			// 총 수강 학기
	private int student_year; 			// 학년
	private int student_total_credit; 	// 총 학점
	private int student_term_grade; 	// 학기 별 성적
	private int student_total_grade; 	// 총 성적

	public StudentGradeDTO() {	}

	public StudentGradeDTO(String student_id, String student_name, String student_regidate, int student_term,
			int student_year, int student_total_credit, int student_term_grade, int student_total_grade) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_regidate = student_regidate;
		this.student_term = student_term;
		this.student_year = student_year;
		this.student_total_credit = student_total_credit;
		this.student_term_grade = student_term_grade;
		this.student_total_grade = student_total_grade;
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

	@Override
	public String toString() {
		return "StudentGradeDTO [student_id=" + student_id + ", student_name=" + student_name + ", student_regidate="
				+ student_regidate + ", student_term=" + student_term + ", student_year=" + student_year
				+ ", student_total_credit=" + student_total_credit + ", student_term_grade=" + student_term_grade
				+ ", student_total_grade=" + student_total_grade + "]";
	}

}
