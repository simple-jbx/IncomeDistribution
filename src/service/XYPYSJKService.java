package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XYPYSJK;

/**
 * 学院评优
 * @author simple
 *
 */
public class XYPYSJKService {
	
	private final static String insertSQL = "insert into t_xxpysjk(id,rydm,xm,xykhyx,jlhj,isdel) VALUES (?,?,?,?,?,?)";	
			
	private final static String updateSQL = "update t_xypysjk set rydm = ?, xm = ?, xypy = ?,"
			+ "jlhj = ? where id = ?";			
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XYPYSJK xypysjk = null;
		List<XYPYSJK > dataList = excelUtils.analysisExcel(path, XYPYSJK.class);
		int listSize = 0;
		if(dataList != null)
			listSize = dataList.size();
		for(int i = 0; i < listSize; i++) {
			xypysjk = dataList.get(i);
			DataBaseUtils.update(insertSQL, xypysjk.getID(), xypysjk.getRYDM(), 
					xypysjk.getXM(), xypysjk.getXYPY(), xypysjk.getJLHJ(), 0);
		}
	}
	
	
	/**
	 * 更新学校评优表中数据
	 * @param xxpysjk
	 */
	public void updateData(XYPYSJK xypysjk) {
		if(xypysjk.getISDEL() == 0) {
				DataBaseUtils.update(updateSQL, xypysjk.getRYDM(), xypysjk.getXM(), xypysjk.getXYPY(),
					xypysjk.getJLHJ(), xypysjk.getID());

		}else if(xypysjk.getISDEL() == 2){
			DataBaseUtils.update(insertSQL, xypysjk.getID(), xypysjk.getRYDM(), 
					xypysjk.getXM(), xypysjk.getXYPY(), xypysjk.getJLHJ(), 0);

		}
		
	}
}
