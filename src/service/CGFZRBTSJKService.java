package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;

import utils.excelUtils;
import bean.CGFZRBTSJK;
import config.DefalutValue;

public class CGFZRBTSJKService {
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	private final static String INSERT_SQL = "insert into t_cgfzrbt(id,rydm,xm,cgfzrbt,hj,nd,isdel) "
			+ "values (?,?,?,?,?,?,?)";
	private final static String UPDATE_SQL = "update t_cgfzrbt set rydm = ?, xm = ?, cgfzrbt = ?, hj = ?,"
			+ " nd = ? where id = ?";
	
	public void save2DB(String path) throws IOException, SQLException {
		CGFZRBTSJK saveObject = null;
		List<CGFZRBTSJK > listObject = excelUtils.analysisExcel(path, CGFZRBTSJK.class);
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		for(int i = 0; i < listSize; i++) {
			saveObject = listObject.get(i);					
			DataBaseUtils.update(INSERT_SQL,saveObject.getID(),saveObject.getRYDM(),saveObject.getXM(),
					saveObject.getCGFZRBT(), saveObject.getHJ(), saveObject.getND(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新
	 * @param updateObject
	 */
	public static void updateData(CGFZRBTSJK updateObject) {
		if(updateObject.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(UPDATE_SQL,updateObject.getRYDM(),updateObject.getXM(),updateObject.getCGFZRBT(),
					updateObject.getHJ(), updateObject.getND(),updateObject.getID());
		}else if(updateObject.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(INSERT_SQL,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getCGFZRBT(), updateObject.getHJ(), updateObject.getND(),DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}	
	}
	
	
	
	/**
	 * 批量更新
	 * @param listObject
	 */
	public static void updateData(List<CGFZRBTSJK> listObject) {
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		CGFZRBTSJK updateObject = new CGFZRBTSJK();
		for(int i = 0; i < listSize; i++) {
			updateObject = listObject.get(i);
			updateData(updateObject);
		}
	}
}
