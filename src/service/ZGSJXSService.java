package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import config.DefalutValue;
import bean.ZGSJXS;

public class ZGSJXSService {
	
	private final static String insertSQL = "insert into t_updateObject(id,rydm,xm,zgys,zgxs,zgqksm,isdel)"
            + " VALUES (?,?,?,?,?,?,?)";	
			
	private final static String updateSQL = "update t_updateObject set id = ?, rydm = ?, xm = ?, zgys = ?,"
			+ " zgxs = ?, zgqksm = ? where id = ? and isdel = ?";			
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZGSJXS updateObject = null;
		List<ZGSJXS > dataList = excelUtils.analysisExcel(path, ZGSJXS.class);
		int listSize = 0;
		if(dataList != null)
			listSize = dataList.size();
		for(int i = 0; i < listSize; i++) {
			updateObject = dataList.get(i);			
			DataBaseUtils.update(insertSQL, updateObject.getID(), updateObject.getRYDM(), updateObject.getXM(),
					updateObject.getZGYS(), updateObject.getZGXS(), updateObject.getZGQKSM(), 
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新在岗时间系数数据
	 * @param updateObject
	 */
	public void updateData(ZGSJXS updateObject) {
		if(updateObject.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
				DataBaseUtils.update(updateSQL, updateObject.getID(), updateObject.getRYDM(), updateObject.getXM(),
					updateObject.getZGYS(), updateObject.getZGXS(), updateObject.getZGQKSM(), updateObject.getID(), 
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}else if(updateObject.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
				DataBaseUtils.update(insertSQL, updateObject.getID(), updateObject.getRYDM(), updateObject.getXM(),
					updateObject.getZGYS(), updateObject.getZGXS(), updateObject.getZGQKSM(), DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
		
	}
}
