package com.accp.pojo;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
@TableName("goshop")
public class GoShop {
	@TableId(value = "goid",type = IdType.AUTO)
	private int goid;   
	private int shopid; 
	private int userid; 
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date gotime; 
	private int gomoney;
	@Override
	public String toString() {
		return "GoShop [goid=" + goid + ", shopid=" + shopid + ", userid=" + userid + ", gotime=" + gotime
				+ ", gomoney=" + gomoney + "]";
	}
	public GoShop(int goid, int shopid, int userid, Date gotime, int gomoney) {
		super();
		this.goid = goid;
		this.shopid = shopid;
		this.userid = userid;
		this.gotime = gotime;
		this.gomoney = gomoney;
	}
	public GoShop() {
		super();
	}
	public int getGoid() {
		return goid;
	}
	public void setGoid(int goid) {
		this.goid = goid;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	
	
}
