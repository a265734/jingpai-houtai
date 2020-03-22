package com.accp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.ShopBiz;
import com.accp.pojo.Shop;
import com.accp.vo.findByVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/shops")
public class ShopAction {
	@Autowired
	private ShopBiz biz;
	
	@PostMapping
	public PageInfo<Shop> getShop(@RequestBody findByVo vo){
		return biz.getShop(vo,"");
	}
	@PostMapping("/all")
	public PageInfo<Shop> getShops(@RequestBody findByVo vo){
		return biz.getShop(vo,"1");
	}
	
	@PostMapping("/shop/modify")
	public Map<String , Object> modifyShop(@RequestBody Shop shop){
		Map<String, Object> map=new HashMap<String, Object>();
		if(biz.modifyShop(shop)>=1) {
			map.put("code", "200");
			map.put("msg", "修改成功");
		}else{
			map.put("code", "500");
			map.put("msg", "修改失败!");
		}
		return map;
	}
	
	@PostMapping("/shop/add")
	public Map<String , Object> addShop(@RequestBody Shop shop){
		
		Map<String, Object> map=new HashMap<String, Object>();
		if(biz.addShop(shop)>=1) {
			map.put("code", "200");
			map.put("msg", "新增成功");
		}else{
			map.put("code", "500");
			map.put("msg", "新增失败!");
		}
		return map;
	}
	
	@PostMapping("/shop/remove/{shopid}")
	public Map<String , Object> removeShop(@PathVariable String shopid){
		Map<String, Object> map=new HashMap<String, Object>();
		if(biz.removeShop(shopid)>=1) {
			map.put("code", "200");
			map.put("msg", "删除成功");
		}else{
			map.put("code", "500");
			map.put("msg", "删除失败!");
		}
		return map;
	}
}
