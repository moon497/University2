package kh.com.model;

import java.io.Serializable;

public class I_semesterGradeDTO implements Serializable{
	
	private String student_id;
	private int sub_semester;  
	private String sub_info;     
	private String sub_category;    
	private int student_score; 
	private int sub_point;    
	private int student_term;
	private int semester;
	
	public I_semesterGradeDTO() {  }

	public I_semesterGradeDTO(String student_id, int sub_semester, String sub_info, String sub_category,
			int student_score, int sub_point, int student_term, int semester) {
		super();
		this.student_id = student_id;
		this.sub_semester = sub_semester;
		this.sub_info = sub_info;
		this.sub_category = sub_category;
		this.student_score = student_score;
		this.sub_point = sub_point;
		this.student_term = student_term;
		this.semester = semester;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public int getSub_semester() {
		return sub_semester;
	}

	public void setSub_semester(int sub_semester) {
		this.sub_semester = sub_semester;
	}

	public String getSub_info() {
		return sub_info;
	}

	public void setSub_info(String sub_info) {
		this.sub_info = sub_info;
	}

	public String getSub_category() {
		return sub_category;
	}

	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}

	public int getStudent_score() {
		return student_score;
	}

	public void setStudent_score(int student_score) {
		this.student_score = student_score;
	}

	public int getSub_point() {
		return sub_point;
	}

	public void setSub_point(int sub_point) {
		this.sub_point = sub_point;
	}

	public int getStudent_term() {
		return student_term;
	}

	public void setStudent_term(int student_term) {
		this.student_term = student_term;
	}
	
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@Override
	public String toString() {
		return "I_semesterGradeDTO [student_id=" + student_id + ", sub_semester=" + sub_semester + ", sub_info="
				+ sub_info + ", sub_category=" + sub_category + ", student_score=" + student_score + ", sub_point="
				+ sub_point + ", student_term=" + student_term + ", semester= " + semester + "]";
	}
	
}
