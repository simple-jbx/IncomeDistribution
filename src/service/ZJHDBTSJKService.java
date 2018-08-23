package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;

import utils.excelUtils;
import bean.ZJHDBTSJK;
import config.DefalutValue;

public class ZJHDBTSJKService {
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	private final static String INSERT_SQL = "insert into t_hfbtsjk(id,rydm,xm,zjhdbt,hj,nd,isdel) "
			+ "values (?,?,?,?,?,?,?)";
	private final static String UPDATE_SQL = "update t_hfbtsjk set rydm = ?, xm = ?, zjhdbt = ?, hj = ?,"
			+ " nd = ? where id = ?";
	
	public void save2DB(String path) throws IOException, SQLException {
		ZJHDBTSJK saveObject = null;
		List<ZJHDBTSJK > listObject = excelUtils.analysisExcel(path, ZJHDBTSJK.class);
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		for(int i = 0; i < listSize; i++) {
			saveObject = listObject.get(i);					
			DataBaseUtils.update(INSERT_SQL,saveObject.getID(),saveObject.getRYDM(),saveObject.getXM(),
					saveObject.getZJHDBT(), saveObject.getHJ(), saveObject.getND(),DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新
	 * @param updateObject
	 */
	public static void updateData(ZJHDBTSJK updateObject) {
		if(updateObject.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(UPDATE_SQL,updateObject.getRYDM(),updateObject.getXM(),updateObject.getZJHDBT(),
					updateObject.getHJ(), updateObject.getND(),updateObject.getID());
		}else if(updateObject.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(INSERT_SQL,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getZJHDBT(), updateObject.getHJ(), updateObject.getND(),DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}	
	}
	
	
	
	/**
	 * 批量更新
	 * @param listObject
	 */
	public static void updateData(List<ZJHDBTSJK> listObject) {
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		ZJHDBTSJK updateObject = new ZJHDBTSJK();
		for(int i = 0; i < listSize; i++) {
			updateObject = listObject.get(i);
			updateData(updateObject);
		}
	}
}
