package com.accp.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.UserBiz;
import com.accp.pojo.User;

@RestController
@RequestMapping("/api/users")
public class UserAction {
	@Autowired
	private UserBiz biz;
	
	@GetMapping("/user/{name}/{password}")
	public Map<String, Object> getUserLogin(@PathVariable String name,@PathVariable String password) {
		Map<String, Object> map=new HashMap<String, Object>();
		User user=biz.userLogin(name, password);
		if(user!=null) {
			map.put("code", "200");
			map.put("msg", "登陆成功");
			map.put("user", user);
			map.put("index", user.getRoleid());
		}else {
			map.put("code", "400");
			map.put("msg", "登陆失败");
		}
		return map;
	}
	
	@PostMapping("/user/add")
	public Map<String, Object> addUser(@RequestBody User user){
		Map<String, Object> map=new HashMap<String, Object>();
		if(biz.selectByUser(user)!=null) {
			map.put("code", "500");
			map.put("msg", "此账户已存在");
			return map;
		}
		if(biz.addUser(user)>=1) {
			map.put("code", "200");
			map.put("msg", "注册成功");
		}else {
			map.put("code", "400");
			map.put("msg", "注册失败");
		}
		return map;
	}
}
