package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;

import utils.excelUtils;
import bean.JTHDKQSJK;
import config.DefalutValue;

public class JTHDKQSJKService {
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	private final static String INSERT_SQL = "insert into t_jthdkqsjk(id,rydm,xm,wgwd,grsj,jey,jee,hjje,"
			+ "nd,isdel) values (?,?,?,?,?,?,?,?,?,?)";
	private final static String UPDATE_SQL = "update t_jthdkqsjk set rydm = ?, xm = ?, wgwd = ?, grsj = ?,"
			+ " jey = ?,jee = ?, hjje = ?, nd = ? where id = ?";
	
	public void save2DB(String path) throws IOException, SQLException {
		JTHDKQSJK saveObject = null;
		List<JTHDKQSJK > listObject = excelUtils.analysisExcel(path, JTHDKQSJK.class);
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		for(int i = 0; i < listSize; i++) {
			saveObject = listObject.get(i);					
			DataBaseUtils.update(INSERT_SQL,saveObject.getID(),saveObject.getRYDM(),saveObject.getXM(),
					saveObject.getWGWD(), saveObject.getGRSJ(),saveObject.getJEY(), saveObject.getJEE(), 
					saveObject.getHJJE(), saveObject.getND(),DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新
	 * @param updateObject
	 */
	public static void updateData(JTHDKQSJK updateObject) {
		if(updateObject.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(UPDATE_SQL,updateObject.getRYDM(),updateObject.getXM(),
				updateObject.getWGWD(),updateObject.getGRSJ(),updateObject.getJEY(), updateObject.getJEE(),
				updateObject.getHJJE(),updateObject.getND(),updateObject.getID());
		}else if(updateObject.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(INSERT_SQL,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
				updateObject.getWGWD(),updateObject.getGRSJ(),updateObject.getJEY(),updateObject.getJEE(),
				updateObject.getHJJE(),updateObject.getND(),0);
		}	
	}
	
	
	
	/**
	 * 批量更新
	 * @param listObject
	 */
	public static void updateData(List<JTHDKQSJK> listObject) {
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		JTHDKQSJK updateObject = new JTHDKQSJK();
		for(int i = 0; i < listSize; i++) {
			updateObject = listObject.get(i);
			updateData(updateObject);
		}
	}
}
