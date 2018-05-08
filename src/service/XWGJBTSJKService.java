package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XWGJBTSJK;

/**
 * 新闻稿件补贴
 * @author simple
 *
 */

public class XWGJBTSJKService {
	
	private final static String insertSQL = "insert into t_xwgjbtsjk(id,rydm,xm,xwgjbt,hj,isdel)"
			+ " VALUES (?,?,?,?,?,?)";	
	private final static String updateSQL =  "update t_xwgjbtsjk set rydm = ?, xm = ?, xwgjbt = ?, hj = ?"
			+ " where id = ?";

	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XWGJBTSJK xwgjbtsjk = null;
		List<XWGJBTSJK > dataList = excelUtils.analysisExcel(path, XWGJBTSJK.class);
		int listSize = 0;
		if(dataList != null)
			listSize = dataList.size();
		for(int i = 0; i < listSize; i++) {
			xwgjbtsjk = dataList.get(i);
			DataBaseUtils.update(insertSQL, xwgjbtsjk.getID(), xwgjbtsjk.getRYDM(), xwgjbtsjk.getXM(),
					xwgjbtsjk.getXWGJBT(), xwgjbtsjk.getHJ(), 0);
		}
	}
	
	
	/**
	 * 更新新闻稿件补贴数据数据
	 * @param xwgjbtsjk
	 */
	public void updateData(XWGJBTSJK xwgjbtsjk) {
		//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
		if(xwgjbtsjk.getISDEL() == 0) {
			DataBaseUtils.update(updateSQL,xwgjbtsjk.getRYDM(),xwgjbtsjk.getXM(),xwgjbtsjk.getXWGJBT(),
					xwgjbtsjk.getHJ(), xwgjbtsjk.getID());
		}else if(xwgjbtsjk.getISDEL() == 2){
			DataBaseUtils.update(insertSQL,xwgjbtsjk.getID(),xwgjbtsjk.getRYDM(),
					xwgjbtsjk.getXM(), xwgjbtsjk.getXWGJBT(), xwgjbtsjk.getHJ(),0);
		}	
	}
}
