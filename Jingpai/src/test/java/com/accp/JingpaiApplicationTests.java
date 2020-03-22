package com.accp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accp.biz.ShopBiz;
import com.accp.biz.UserBiz;
import com.accp.vo.findByVo;

@SpringBootTest
class JingpaiApplicationTests {
	@Autowired
	private UserBiz user;
	
	@Autowired
	private ShopBiz shop;
	@Test
	void contextLoads() {
		System.out.println(user.userLogin("admin", "123"));
	}
	
	@Test
	void shopInf() {
		
	}

}
