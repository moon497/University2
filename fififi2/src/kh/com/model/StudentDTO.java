package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("Student")
public class StudentDTO implements Serializable {

	//재현
	private String student_id; 			// USER_ID
	private String student_name; 		// USER_NAME
	private String student_regidate; 	// 입학일
	private int student_term; 			// 총 수강 학기
	private int student_year; 			// 학년
	private int student_total_credit; 	// 총 학점
	private int student_term_grade; 	// 학기 별 성적
	private int student_total_grade; 	// 총 성적
	private int totalPoint;				// 수강신청시 총학점
	private String student_major;		// 전공	
	private String first_major;			// 학부

	//지윤
	private int sub_seq; 			// 과목 시퀀스
	private int sub_semester; 		// 학기
	private int sub_category; 		// 전공여부
	private String professor_name; 	// 교수이름
	private String sub_info; 		// 과목명
	private int sub_point; 			// 학점
	private int student_score; 		// 점수(학기별 점수)
	private int professor_grade;    // 교수(강의)평가(완료여부확인용)
	private int grade_confirm;		// 강의 성적확인 여부
	
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
	public int getTotalPoint() {
		return totalPoint;
	}
	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}
	public String getStudent_major() {
		return student_major;
	}
	public void setStudent_major(String student_major) {
		this.student_major = student_major;
	}
	public String getFirst_major() {
		return first_major;
	}
	public void setFirst_major(String first_major) {
		this.first_major = first_major;
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
	public int getGrade_confirm() {
		return grade_confirm;
	}
	public void setGrade_confirm(int grade_confirm) {
		this.grade_confirm = grade_confirm;
	}
	@Override
	public String toString() {
		return "StudentDTO [student_id=" + student_id + ", student_name=" + student_name + ", student_regidate="
				+ student_regidate + ", student_term=" + student_term + ", student_year=" + student_year
				+ ", student_total_credit=" + student_total_credit + ", student_term_grade=" + student_term_grade
				+ ", student_total_grade=" + student_total_grade + ", totalPoint=" + totalPoint + ", student_major="
				+ student_major + ", first_major=" + first_major + ", sub_seq=" + sub_seq + ", sub_semester="
				+ sub_semester + ", sub_category=" + sub_category + ", professor_name=" + professor_name + ", sub_info="
				+ sub_info + ", sub_point=" + sub_point + ", student_score=" + student_score + ", professor_grade="
				+ professor_grade + ", grade_confirm=" + grade_confirm + "]";
	}

	

	
	
	
}
