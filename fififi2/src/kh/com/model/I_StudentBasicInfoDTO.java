package kh.com.model;

import java.io.Serializable;

public class I_StudentBasicInfoDTO implements Serializable {
	/*
	 * ST.STUDENT_ID 		, -- AS "학번"	, 
	 * ST.STUDENT_NAME 		, -- AS "학생이름"	,
	 * ST.STUDENT_REGIDATE 	, -- AS "입학년도"	, 
	 * U.USER_PW 			, -- AS "비밀번호"	, 
	 * U.USER_EMAIL 		, -- AS "이메일"	, 
	 * U.USER_PHONE			, -- AS "전화번호"	, 
	 * U.USER_ADDRESS 		, -- AS "집주소"	,
	 * U.USER_STATUS 		  -- AS "졸업여부"
	 */
	private String student_id;
	private String student_name;
	private String student_regidate;
	private String user_pw;
	private String user_email;
	private String user_phone;
	private String user_address;
	private String user_status;
	private String user_photo;

	public I_StudentBasicInfoDTO() {  }

	public I_StudentBasicInfoDTO(String student_id, String student_name, String student_regidate, String user_pw,
			String user_email, String user_phone, String user_address, String user_status, String user_photo) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.student_regidate = student_regidate;
		this.user_pw = user_pw;
		this.user_email = user_email;
		this.user_phone = user_phone;
		this.user_address = user_address;
		this.user_status = user_status;
		this.user_photo = user_photo;
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

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	
	public String getUser_photo() {
		return user_photo;
	}

	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}

	@Override
	public String toString() {
		return "I_StudentBasicInfoDTO [student_id=" + student_id + ", student_name=" + student_name
				+ ", student_regidate=" + student_regidate + ", user_pw=" + user_pw + ", user_email=" + user_email
				+ ", user_phone=" + user_phone + ", user_address=" + user_address + ", user_status=" + user_status
				+ ", user_photo=" + user_photo + "]";
	}

}
