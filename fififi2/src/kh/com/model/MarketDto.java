package kh.com.model;

import java.io.Serializable;

public class MarketDto implements Serializable {
	private static final long serialVersionUID = -7370392075178708767L;
	
	private String status;
	private int seq;
	private String category;
	private String userId;
	private String userName;
	private String title;
	private String content;
	private int price;
	private String address;
	private String phone;
	private String wdate;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	@Override
	public String toString() {
		return "MarketDto [status=" + status + ", seq=" + seq + ", category=" + category + ", userId=" + userId
				+ ", userName=" + userName + ", title=" + title + ", content=" + content + ", price=" + price
				+ ", address=" + address + ", phone=" + phone + ", wdate=" + wdate + "]";
	}

}
