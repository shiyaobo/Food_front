package cn.et.model.foodType;

import java.util.List;
import java.util.Map;

import cn.et.model.MysalDBUtils;

public class MyFoodType {
	public List<Map> getAllFoodType(){
		String sql="select * from foodType";
		return MysalDBUtils.query(sql);
	}
	
	public List<Map> getAllFood(){
		String sql="select * from food";
		return MysalDBUtils.query(sql);
	}
}
