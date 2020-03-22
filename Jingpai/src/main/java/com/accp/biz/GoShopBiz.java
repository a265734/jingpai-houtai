package com.accp.biz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.dao.GoShopDao;
import com.accp.dao.ShopDao;
import com.accp.dao.UserDao;
import com.accp.pojo.GoShop;
import com.accp.pojo.Shop;
import com.accp.vo.gos;
import com.accp.vo.showIng;
import com.accp.vo.showVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Service("goshopBiz")
public class GoShopBiz {

	@Autowired
	private GoShopDao dao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private UserDao userDao;
	public List<gos> getGos(String shopid){
		return dao.findGoShopVo(shopid);
	}
	
	public int addGos(GoShop go) {
		return dao.insert(go);
	}
	
	public int selectGoMoney(GoShop go) {
		QueryWrapper<GoShop> qw=Wrappers.query();
		qw.eq("shopid", go.getShopid()).orderByDesc("gomoney").last("limit 1");
		if(dao.selectOne(qw)!=null) {
			if(go.getGomoney()<=dao.selectOne(qw).getGomoney()) {
				return -1;
			}
		}
		return 1;
	}
	public int selectHaveGo(GoShop go) {
		QueryWrapper<GoShop> qw=Wrappers.query();
		qw.eq("shopid", go.getShopid());
		if(dao.selectList(qw).size()==0) {
			if(go.getGomoney()<=dao.findGoStartMoney(go.getShopid())) {
				return -1;
			}
		}
		return 1;
	}
	public int selectGoTime(GoShop go){
		QueryWrapper<GoShop> qw=Wrappers.query();
		qw.eq("shopid", go.getShopid()).orderByDesc("gomoney").last("limit 1");
		if(dao.selectOne(qw)!=null) {
			if(go.getUserid()==dao.selectOne(qw).getUserid()) {
				return -1;
			}
		}
		return 1;
	}
	public List<Shop> getGoShow(){
		QueryWrapper<Shop> qw=Wrappers.query();
		qw.eq("stateid", 0);
		return shopDao.selectList(qw);
	}
	
	public List<showIng> getShowIng(){
		QueryWrapper<Shop> qw=Wrappers.query();
		qw.eq("stateid", 1);
		List<Shop> shops=shopDao.selectList(qw);
		List<showIng> showList=new ArrayList<showIng>();
		for (Shop shop : shops) {
			showIng show=new showIng(shop.getShopname(), shop.getStarttime(), shop.getEndtime(), shop.getStartmoney(), dao.getGo(shop.getShopid()));
			showList.add(show);
		}
		return showList;
	}
}
