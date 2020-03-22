package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.accp.pojo.GoShop;
import com.accp.vo.gos;
import com.accp.vo.govo;
import com.accp.vo.showVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface GoShopDao  extends BaseMapper<GoShop>{
	
	@Select("SELECT goid,username,gotime,gomoney FROM goshop g INNER JOIN `user` u ON g.`userid`=u.`userid` where shopid=#{0} ORDER BY gomoney DESC")
	public List<gos> findGoShopVo(String shopid);
	@Select("SELECT startmoney FROM shop WHERE shopid=#{0}")
	public int findGoStartMoney(int shopid);
	@Select("SELECT g.`gomoney`,u.`username` FROM goshop g INNER JOIN `user` u ON g.`userid`=u.`userid` WHERE shopid =#{0}  ORDER BY g.`gomoney` DESC")
	public List<govo> getGo(int shopid);
}
