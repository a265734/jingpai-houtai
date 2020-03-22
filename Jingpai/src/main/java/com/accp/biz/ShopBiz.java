package com.accp.biz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.GoShopDao;
import com.accp.dao.ShopDao;
import com.accp.dao.UserDao;
import com.accp.pojo.GoShop;
import com.accp.pojo.Shop;
import com.accp.pojo.User;
import com.accp.vo.findByVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("shopBiz")
public class ShopBiz {
	@Autowired
	private ShopDao dao;
	@Autowired
	private GoShopDao goDao;
	@Autowired
	private UserDao userDao;
	public PageInfo<Shop> getShop(findByVo vo,String num){
		QueryWrapper<Shop> qw=Wrappers.query();
		System.out.println(vo);
		PageHelper.startPage(vo.getPagenum(), vo.getPagesize());
		if(vo.getName()!="") {
			qw.like("shopname", vo.getName());
		}
		if(vo.getDesc()!="") {
			qw.like("shopdesc", vo.getDesc());
		}
		if(vo.getStart()!="") {
			qw.like("starttime", vo.getStart());
		}
		if(vo.getEnd()!="") {
			qw.like("endtime", vo.getEnd());
		}
		if(vo.getMoney()!=0) {
			qw.eq("startmoney", vo.getMoney());
		}
		if(vo.getUserid()!=0) {
			qw.eq("userid", vo.getUserid());
		}
		
		qw.like("stateid", num);
		
		List<Shop> shops=dao.selectList(qw);
		for (Shop shop : shops) {
			Date date=new Date();
			if (date.getTime() > shop.getEndtime().getTime()) {
		       if(modifyStateAndName(shop)>=1) {
		    	   System.out.println("竞拍状态修改成功====");
		       }
		    }
		}
		PageInfo<Shop> page=new PageInfo<Shop>(shops);
		return page;
	}
	public GoShop getActionName(int shopid) {
		QueryWrapper<GoShop> qw=Wrappers.query();
		qw.eq("shopid", shopid).orderByDesc("gomoney").last("limit 1");
		return goDao.selectOne(qw);
	}
	public int modifyStateAndName(Shop shop) {
		GoShop go=getActionName(shop.getShopid());
		if(go==null) {
			shop.setEndname("流拍");
			shop.setEndmoney(0);
		}else {
			shop.setEndname(userDao.selectById(go.getUserid()).getUsername());
			shop.setEndmoney(go.getGomoney());
		}
		shop.setStateid(0);
		return dao.updateById(shop);
	}
	public int modifyShop(Shop shop) {
		return dao.updateById(shop);
	}
	
	public int addShop(Shop shop) {
		
		return dao.insert(shop);
	}
	
	public int removeShop(String shopid) {
		return dao.deleteById(shopid);
	}
}
