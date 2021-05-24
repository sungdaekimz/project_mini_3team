package com.kh.mini.model.vo;

public class User {
	
	private String userId;
	private String userPwd;
	private String userName;
	private String userPhone;
	private int userAge;
	private char userGender;
	private char userType; // U : 일반 이용자 / P : 사장님
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String userPwd, String userName, String userPhone, int userAge, char userGender,
			char userType) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAge = userAge;
		this.userGender = userGender;
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public char getUserGender() {
		return userGender;
	}

	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userPhone=" + userPhone
				+ ", userAge=" + userAge + ", userGender=" + userGender + ", userType=" + userType + "]";
	}
	
	
	
	

}
