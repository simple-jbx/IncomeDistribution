package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;

import utils.excelUtils;
import bean.XYPYSJK;
import config.DefalutValue;

public class XYPYSJKService {
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	private final static String INSERT_SQL = "insert into t_xypysjk(id,rydm,xm,xypy,jlhj,"
			+ "nd,isdel) values (?,?,?,?,?,?,?)";
	private final static String UPDATE_SQL = "update t_xypysjk set rydm = ?, xm = ?, xypy = ?, jlhj = ?,"
			+ "nd = ? where id = ?";
	
	public void save2DB(String path) throws IOException, SQLException {
		XYPYSJK saveObjlhjct = null;
		List<XYPYSJK > listObjlhjct = excelUtils.analysisExcel(path, XYPYSJK.class);
		int listSize = 0;
		if(listObjlhjct != null)
			listSize = listObjlhjct.size();
		for(int i = 0; i < listSize; i++) {
			saveObjlhjct = listObjlhjct.get(i);					
			DataBaseUtils.update(INSERT_SQL,saveObjlhjct.getID(),saveObjlhjct.getRYDM(),saveObjlhjct.getXM(),
					saveObjlhjct.getXYPY(), saveObjlhjct.getJLHJ(), saveObjlhjct.getND(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新
	 * @param updateObject
	 */
	public static void updateData(XYPYSJK updateObject) {
		if(updateObject.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(UPDATE_SQL,updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getXYPY(), updateObject.getJLHJ(),updateObject.getND(),updateObject.getID());
		}else if(updateObject.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(INSERT_SQL,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getXYPY(), updateObject.getJLHJ(), updateObject.getND(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}	
	}
	
	
	
	/**
	 * 批量更新
	 * @param listObjlhjct
	 */
	public static void updateData(List<XYPYSJK> listObjlhjct) {
		int listSize = 0;
		if(listObjlhjct != null)
			listSize = listObjlhjct.size();
		XYPYSJK updateObject = new XYPYSJK();
		for(int i = 0; i < listSize; i++) {
			updateObject = listObjlhjct.get(i);
			updateData(updateObject);
		}
	}
}
