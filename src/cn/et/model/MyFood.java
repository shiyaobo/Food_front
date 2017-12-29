package cn.et.model;

import java.util.List;
import java.util.Map;
/**
 * 前端分页，
 * @author root
 *
 */
public class MyFood {
	public Integer getFoodListCount(String typeId){
		String sql="select count(rownum) as cr from FOOD t where t.typeid like '%"+typeId+"%'";
		List<Map> list=MysalDBUtils.query(sql);
		return Integer.parseInt(list.get(0).get("CR").toString());
	}
	
	/*
	 * 根据穿过来的菜品类型id来查询所符食物，并分页
	 */
	public PageTools getFoodList(Integer curpage,String typeId){
		Integer totalCount=getFoodListCount(typeId);
		PageTools pageTools=new PageTools(curpage, totalCount, 6);

		 StringBuffer sb=new StringBuffer();
	     String sql="select * from (select t.*,ft.typename,rownum rn from food t inner join foodtype ft on t.typeid=ft.typeid where t.typeid like '%"+typeId+"%' )"
	               + " where rn>="+pageTools.getStartIndex()+" and rn<="+pageTools.getEndIndex();
	       List<Map> result=MysalDBUtils.query(sql);
	       pageTools.setData(result);
	       return pageTools;
	}
	
}
