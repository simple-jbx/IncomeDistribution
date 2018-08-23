package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;

import utils.excelUtils;
import bean.XWGJBTSJK;
import config.DefalutValue;

public class XWGJBTSJKService {
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	private final static String INSERT_SQL = "insert into t_xwgjbtsjk(id,rydm,xm,xwgjbt,hj,nd,isdel) "
			+ "values (?,?,?,?,?,?,?,?,?,?)";
	private final static String UPDATE_SQL = "update t_xwgjbtsjk set rydm = ?, xm = ?, xwgjbt = ?, hj = ?,"
			+ " nd = ? where id = ?";
	
	public void save2DB(String path) throws IOException, SQLException {
		XWGJBTSJK saveObject = null;
		List<XWGJBTSJK > listObject = excelUtils.analysisExcel(path, XWGJBTSJK.class);
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		for(int i = 0; i < listSize; i++) {
			saveObject = listObject.get(i);					
			DataBaseUtils.update(INSERT_SQL,saveObject.getID(),saveObject.getRYDM(),saveObject.getXM(),
					saveObject.getXWGJBT(), saveObject.getHJ(), saveObject.getND(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新
	 * @param updateObject
	 */
	public static void updateData(XWGJBTSJK updateObject) {
		if(updateObject.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(UPDATE_SQL,updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getRYDM(),updateObject.getXM(),updateObject.getXWGJBT(),
					updateObject.getHJ(), updateObject.getND(),updateObject.getID());
		}else if(updateObject.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(INSERT_SQL,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getXWGJBT(), updateObject.getHJ(), updateObject.getND(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}	
	}
	
	
	
	/**
	 * 批量更新
	 * @param listObject
	 */
	public static void updateData(List<XWGJBTSJK> listObject) {
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		XWGJBTSJK updateObject = new XWGJBTSJK();
		for(int i = 0; i < listSize; i++) {
			updateObject = listObject.get(i);
			updateData(updateObject);
		}
	}
}
