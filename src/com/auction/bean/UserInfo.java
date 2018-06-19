package com.auction.bean;

public class UserInfo {
	private String username;
	private String password;
	private String vercode;
	private String loginname;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	
	@Override
	public String toString() {
		return"username=" + username + "password=" + password + "vercode=" + vercode + "loginname="
		+ loginname + "\n";
	}
	
}
