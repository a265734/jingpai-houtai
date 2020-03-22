package com.accp.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class showVo {
	private String shopname;
	private int startmoney;
	private int endmoney;
	@DateTimeFormat(pattern  = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date starttime;
	@DateTimeFormat(pattern  = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date endtime;
	private String username;
	@Override
	public String toString() {
		return "showVo [shopname=" + shopname + ", startmoney=" + startmoney + ", endmoney=" + endmoney + ", starttime="
				+ starttime + ", endtime=" + endtime + ", username=" + username + "]";
	}
	public showVo(String shopname, int startmoney, int endmoney, Date starttime, Date endtime, String username) {
		super();
		this.shopname = shopname;
		this.startmoney = startmoney;
		this.endmoney = endmoney;
		this.starttime = starttime;
		this.endtime = endtime;
		this.username = username;
	}
	public showVo() {
		super();
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public int getStartmoney() {
		return startmoney;
	}
	public void setStartmoney(int startmoney) {
		this.startmoney = startmoney;
	}
	public int getEndmoney() {
		return endmoney;
	}
	public void setEndmoney(int endmoney) {
		this.endmoney = endmoney;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
