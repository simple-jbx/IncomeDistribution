package service;

import java.util.List;
import java.util.Map;
import annotation.Table;
import utils.DataBaseUtils;

/**
 * Service中的公共方法
 * @author simple
 */
public class commonService {
	
	/**
	 * 获取某表中的所有数据
	 * @param clazz
	 * @return
	 */
	public static List<Map<String, Object> > getAllData(Class<?> clazz) {
		
		Table table = (Table) clazz.getAnnotation(Table.class);
		String tableName = table.tableName();
		if(tableName == null)
			tableName = "";
		String sql = "select * from " + tableName + " where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	/**
	 * 获取某表中的所有数据
	 * @param clazz
	 * @return
	 */
	public static List<Map<String, Object> > getAllData(Class<?> clazz, String year) {
		if(year.equals("All")) {
			return getAllData(clazz);
		}else {
			Table table = (Table) clazz.getAnnotation(Table.class);
			String tableName = table.tableName();
			if(tableName == null)
				tableName = "";
			String sql = "select * from " + tableName + " where nd=? and isdel=?";
			return DataBaseUtils.queryForList(sql, year, 0);
		}	
	}
	
	
	/**
	 * 根据人员代码返回个人数据
	 * @param clazz
	 * @param Rydm
	 * @return
	 */
	public static <T> T getDataByRydm(Class<?> clazz, String Rydm) {
		Table table = (Table) clazz.getAnnotation(Table.class);
		String tableName = table.tableName();
		if(tableName == null)
			tableName = "";
		String sql = "select * from " + tableName + " where rydm = ? and isdel = ?";
		//System.out.println(sql + " " + Rydm);
		return DataBaseUtils.queryForBean(sql, clazz, Rydm, 0);
	}
	
	public static <T> T getDataByRydm(Class<?> clazz, String Rydm, String year) {
		if(year.equals("All")) {
			return getDataByRydm(clazz, Rydm);
		}else {
			Table table = (Table) clazz.getAnnotation(Table.class);
			String tableName = table.tableName();
			if(tableName == null)
				tableName = "";
			String sql = "select * from " + tableName + " where rydm=? and nd=? and isdel=?";
			//System.out.println(sql + " " + Rydm);
			return DataBaseUtils.queryForBean(sql, clazz, Rydm, year, 0);
		}
	}
	
	
	/**
	 * 根据id删除某表对应数据
	 * @param id
	 */
	public static void deleteByID(Class<?> clazz, String iD) {
		Table table = (Table) clazz.getAnnotation(Table.class);
		String tableName = table.tableName();
		if(tableName == null)
			tableName = "";
		String sql = "update " + tableName + " set isdel = ? where id  = ?";
		DataBaseUtils.update(sql, 1, iD);
	}
	
	
	public static void deleteByIDList(Class<?> clazz, List<String> list) {
		Table table = (Table) clazz.getAnnotation(Table.class);
		String tableName = table.tableName();
		if(tableName == null)
			tableName = "";
		String sql = "update " + tableName + " set isdel = ? where id  = ?";
		int listSize = list.size();
		for(int i=0; i<listSize; i++) {
			DataBaseUtils.update(sql, 1, list.get(i));
		}
		
	}
}
