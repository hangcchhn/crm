package hn.cch.entity;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Integer userId;
	private String userName;
	private String userPwd;

	private Set<Visit> userVisits = new HashSet<Visit>();

	public User() {
		super();
	}

	public User(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public User(Integer userId, String userName, String userPwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Set<Visit> getUserVisits() {
		return userVisits;
	}

	public void setUserVisits(Set<Visit> visits) {
		this.userVisits = visits;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userPwd=" + userPwd + "]";
	}

}
