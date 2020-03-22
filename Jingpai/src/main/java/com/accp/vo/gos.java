package com.accp.vo;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.accp.pojo.Shop;
import com.accp.pojo.User;
import com.fasterxml.jackson.annotation.JsonFormat;

public class gos {
	private int goid;    
	private String username; 
	@DateTimeFormat(pattern  = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date gotime; 
	private int gomoney;
	@Override
	public String toString() {
		return "gos [goid=" + goid + ", username=" + username + ", gotime=" + gotime + ", gomoney=" + gomoney + "]";
	}
	public int getGoid() {
		return goid;
	}
	public void setGoid(int goid) {
		this.goid = goid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getGotime() {
		return gotime;
	}
	public void setGotime(Date gotime) {
		this.gotime = gotime;
	}
	public int getGomoney() {
		return gomoney;
	}
	public void setGomoney(int gomoney) {
		this.gomoney = gomoney;
	}
	public gos(int goid, String username, Date gotime, int gomoney) {
		super();
		this.goid = goid;
		this.username = username;
		this.gotime = gotime;
		this.gomoney = gomoney;
	}
	public gos() {
		super();
	}
	
	
}
