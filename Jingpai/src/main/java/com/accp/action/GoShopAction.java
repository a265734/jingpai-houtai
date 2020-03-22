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

import com.accp.biz.GoShopBiz;
import com.accp.pojo.GoShop;
import com.accp.pojo.Shop;
import com.accp.vo.gos;
import com.accp.vo.showIng;
import com.accp.vo.showVo;

@RestController
@RequestMapping("/api/gos")
public class GoShopAction {
	@Autowired
	private GoShopBiz biz;
	
	@GetMapping("/{shopid}")
	public List<gos> getGos(@PathVariable String shopid){
		return biz.getGos(shopid);
	}
	@PostMapping("/go/add")
	public Map<String, Object> addGos(@RequestBody GoShop go){
		Map<String, Object> map=new HashMap<String, Object>();
		if(biz.selectHaveGo(go)==-1) {
			map.put("code", "505");
			map.put("msg", "竞拍金额不得低于起拍价");
		}else if(biz.selectGoTime(go)==-1) {
			map.put("code", "400");
			map.put("msg", "无法连续竞拍，请稍后!");
		}else if(biz.selectGoMoney(go)==-1) {
			map.put("code", "500");
			map.put("msg", "竞拍金额不得低于最高竞拍价");
		}else if(biz.addGos(go)>=1) {
			map.put("code", "200");
			map.put("msg", "恭喜你,竞拍成功!");
		}else {
			map.put("code", "404");
			map.put("msg", "竞拍失败！");
		}
		return map;
	}
	
	@GetMapping("/show")
	public List<Shop> getShow(){
		return biz.getGoShow();
	}
	
	@GetMapping("/showing")
	public List<showIng> getShowIng(){
		biz.getShowIng().forEach(i->{
			System.out.println(i);
		});
		return biz.getShowIng();
	}
}
