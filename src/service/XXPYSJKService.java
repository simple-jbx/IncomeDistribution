package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;

import utils.excelUtils;
import bean.XXPYSJK;
import config.DefalutValue;

public class XXPYSJKService {
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	private final static String INSERT_SQL = "insert into t_xxpysjk(id,rydm,xm,xxkhyx,jlhj,"
			+ "nd,isdel) values (?,?,?,?,?,?,?)";
	private final static String UPDATE_SQL = "update t_xxpysjk set rydm = ?, xm = ?, xxkhyx = ?, jlhj = ?,"
			+ "nd = ? where id = ?";
	
	public void save2DB(String path) throws IOException, SQLException {
		XXPYSJK saveObject = null;
		List<XXPYSJK > listObject = excelUtils.analysisExcel(path, XXPYSJK.class);
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		for(int i = 0; i < listSize; i++) {
			saveObject = listObject.get(i);					
			DataBaseUtils.update(INSERT_SQL,saveObject.getID(),saveObject.getRYDM(),saveObject.getXM(),
					saveObject.getXXKHYX(), saveObject.getJLHJ(), saveObject.getND(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新
	 * @param updateObject
	 */
	public static void updateData(XXPYSJK updateObject) {
		if(updateObject.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(UPDATE_SQL,updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getXXKHYX(), updateObject.getJLHJ(),updateObject.getND(),updateObject.getID());
		}else if(updateObject.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(INSERT_SQL,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getXXKHYX(), updateObject.getJLHJ(), updateObject.getND(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}	
	}
	
	
	
	/**
	 * 批量更新
	 * @param listObject
	 */
	public static void updateData(List<XXPYSJK> listObject) {
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		XXPYSJK updateObject = new XXPYSJK();
		for(int i = 0; i < listSize; i++) {
			updateObject = listObject.get(i);
			updateData(updateObject);
		}
	}
}
