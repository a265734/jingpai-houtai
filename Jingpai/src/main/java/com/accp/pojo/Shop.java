package com.accp.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
@TableName("shop")
public class Shop {
	@TableId(value = "shopid",type = IdType.AUTO)
	private int shopid;
	private int userid;
	private String shopname;
	private int startmoney;
	private int endmoney;
	private String endname;
	@DateTimeFormat(pattern  = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date starttime;
	@DateTimeFormat(pattern  = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date endtime;
	private String imgpath;
	private String shopdesc;
	private int stateid;
	@Override
	public String toString() {
		return "Shop [userid=" + userid + ", shopid=" + shopid + ", shopname=" + shopname + ", startmoney=" + startmoney
				+ ", endmoney=" + endmoney + ", endname=" + endname + ", starttime=" + starttime + ", endtime="
				+ endtime + ", imgpath=" + imgpath + ", shopdesc=" + shopdesc + ", stateid=" + stateid + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
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
	public String getEndname() {
		return endname;
	}
	public void setEndname(String endname) {
		this.endname = endname;
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
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public String getShopdesc() {
		return shopdesc;
	}
	public void setShopdesc(String shopdesc) {
		this.shopdesc = shopdesc;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public Shop(int userid, int shopid, String shopname, int startmoney, int endmoney, String endname, Date starttime,
			Date endtime, String imgpath, String shopdesc, int stateid) {
		super();
		this.userid = userid;
		this.shopid = shopid;
		this.shopname = shopname;
		this.startmoney = startmoney;
		this.endmoney = endmoney;
		this.endname = endname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.imgpath = imgpath;
		this.shopdesc = shopdesc;
		this.stateid = stateid;
	}
	public Shop() {
		super();
	}
	
	
}
