package com.accp.vo;

public class govo {
	private String username;
	private String gomoney;
	@Override
	public String toString() {
		return "govo [username=" + username + ", gomoney=" + gomoney + "]";
	}
	public govo(String username, String gomoney) {
		super();
		this.username = username;
		this.gomoney = gomoney;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGomoney() {
		return gomoney;
	}
	public void setGomoney(String gomoney) {
		this.gomoney = gomoney;
	}
	public govo() {
		super();
	}
	
}
