package cn.et.model;

import java.util.List;
import java.util.Map;

public class MyDesk {
	public List<Map> getTablePageAll(){
		String sql="select * from desk";
		return MysalDBUtils.query(sql);
	}
}
