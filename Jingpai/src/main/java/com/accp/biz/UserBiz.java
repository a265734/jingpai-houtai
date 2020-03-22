package com.accp.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.UserDao;
import com.accp.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Service("userBiz")
public class UserBiz {
	@Autowired
	private UserDao dao;
	
	public User userLogin(String zh,String pwd) {
		QueryWrapper<User> qw=Wrappers.query();
		qw.eq("userzh", zh).eq("userpwd", pwd);
		return dao.selectOne(qw);
	}
	
	public int addUser(User user) {
		return dao.insert(user);
	}
	
	public User selectByUser(User user) {
		QueryWrapper<User> qw=Wrappers.query();
		qw.eq("userzh", user.getUserzh());
		return dao.selectOne(qw);
	}
}
