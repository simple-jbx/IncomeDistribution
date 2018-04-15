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
	 * 返回某表中的单条数据
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
		return DataBaseUtils.queryForBean(sql, clazz, Rydm, 0);
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
}
