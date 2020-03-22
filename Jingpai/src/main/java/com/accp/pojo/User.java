package com.accp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user")
public class User {
	@TableId(value = "userid",type = IdType.AUTO)
	private int userid;
	private String userzh;
	private String userpwd;
	private String username;
	private int roleid;
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userzh=" + userzh + ", userpwd=" + userpwd + ", username=" + username
				+ ", roleid=" + roleid + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserzh() {
		return userzh;
	}
	public void setUserzh(String userzh) {
		this.userzh = userzh;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public User(int userid, String userzh, String userpwd, String username, int roleid) {
		super();
		this.userid = userid;
		this.userzh = userzh;
		this.userpwd = userpwd;
		this.username = username;
		this.roleid = roleid;
	}
	public User() {
		super();
	}
	
}
