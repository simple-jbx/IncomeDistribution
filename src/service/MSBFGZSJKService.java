package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;

import utils.excelUtils;
import bean.MSBFGZSJK;
import config.DefalutValue;

public class MSBFGZSJKService {
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	private final static String INSERT_SQL = "insert into t_msbfgzsjk(id,rydm,xm,msdsgzl,gzlbzj,ffje,nd,isdel) "
			+ "values (?,?,?,?,?,?,?)";
	private final static String UPDATE_SQL = "update t_msbfgzsjk set rydm = ?, xm = ?, msdsgzl = ?, gzlbzj = ?,"
			+ " ffje = ?, nd = ? where id = ?";
	
	public void save2DB(String path) throws IOException, SQLException {
		MSBFGZSJK saveObject = null;
		List<MSBFGZSJK > listObject = excelUtils.analysisExcel(path, MSBFGZSJK.class);
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		for(int i = 0; i < listSize; i++) {
			saveObject = listObject.get(i);					
			DataBaseUtils.update(INSERT_SQL,saveObject.getID(),saveObject.getRYDM(),saveObject.getXM(),
					saveObject.getMSDSGZL(),saveObject.getGZLBZJ(), saveObject.getFFJE(), saveObject.getND(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新
	 * @param updateObject
	 */
	public static void updateData(MSBFGZSJK updateObject) {
		if(updateObject.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(UPDATE_SQL,updateObject.getRYDM(),updateObject.getXM(),updateObject.getID(),
					updateObject.getMSDSGZL(),updateObject.getGZLBZJ(), updateObject.getFFJE(), updateObject.getND(),
					updateObject.getID());
		}else if(updateObject.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(INSERT_SQL,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getMSDSGZL(),updateObject.getGZLBZJ(), updateObject.getFFJE(), updateObject.getND(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}	
	}
	
	
	
	/**
	 * 批量更新
	 * @param listObject
	 */
	public static void updateData(List<MSBFGZSJK> listObject) {
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		MSBFGZSJK updateObject = new MSBFGZSJK();
		for(int i = 0; i < listSize; i++) {
			updateObject = listObject.get(i);
			updateData(updateObject);
		}
	}
}
