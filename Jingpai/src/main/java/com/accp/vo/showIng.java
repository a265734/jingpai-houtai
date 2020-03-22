package com.accp.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class showIng {
	private String shopname;
	@DateTimeFormat(pattern  = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date starttime;
	@DateTimeFormat(pattern  = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date endtime;
	private int startmoney;
	private List<govo> goList;
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
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
	public int getStartmoney() {
		return startmoney;
	}
	public void setStartmoney(int startmoney) {
		this.startmoney = startmoney;
	}
	public List<govo> getGoList() {
		return goList;
	}
	public void setGoList(List<govo> goList) {
		this.goList = goList;
	}
	@Override
	public String toString() {
		return "showIng [shopname=" + shopname + ", starttime=" + starttime + ", endtime=" + endtime + ", startmoney="
				+ startmoney + ", goList=" + goList + "]";
	}
	public showIng(String shopname, Date starttime, Date endtime, int startmoney, List<govo> goList) {
		super();
		this.shopname = shopname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.startmoney = startmoney;
		this.goList = goList;
	}
	public showIng() {
		super();
	}
	
	
}
