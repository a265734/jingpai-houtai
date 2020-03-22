package com.accp.vo;

public class findByVo {
	private String name;
	private String desc;
	private String start;
	private String end;
	private int money;
	private int pagenum;
	private int pagesize;
	private int userid;
	@Override
	public String toString() {
		return "findByVo [name=" + name + ", desc=" + desc + ", start=" + start + ", end=" + end + ", money=" + money
				+ ", pagenum=" + pagenum + ", pagesize=" + pagesize + ", userid=" + userid + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public findByVo(String name, String desc, String start, String end, int money, int pagenum, int pagesize,
			int userid) {
		super();
		this.name = name;
		this.desc = desc;
		this.start = start;
		this.end = end;
		this.money = money;
		this.pagenum = pagenum;
		this.pagesize = pagesize;
		this.userid = userid;
	}
	public findByVo() {
		super();
	}
	
	
}
