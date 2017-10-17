package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("querysub")
public class QuerySubjectDto implements Serializable {
	
	private String major;
	private String user_id;
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "QuerySubjectDto [major=" + major + ", user_id=" + user_id + "]";
	}
	
	

}
