package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XXPYSJK;

/**
 * 学校评优
 * @author simple
 *
 */

public class XXPYSJKService {
	
	private final static String insertSQL = "insert into t_xxpysjk(id,rydm,xm,xxkhyx,jlhj,isdel) VALUES (?,?,?,?,?,?)";	

			
	private final static String updateSQL = "update t_xxpysjk set rydm = ?, xm = ?, xxkhyx = ?,"
			+ "jlhj = ? where id = ?";		

	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XXPYSJK xxpysjk = null;
		List<XXPYSJK > dataList = excelUtils.analysisExcel(path, XXPYSJK.class);
		int listSize = 0;
		if(dataList != null)
			listSize = dataList.size();
		for(int i = 0; i < listSize; i++) {
			xxpysjk = dataList.get(i);
			DataBaseUtils.update(insertSQL, xxpysjk, xxpysjk.getRYDM(), 
					xxpysjk.getXM(), xxpysjk.getXXKHYX(), xxpysjk.getJLHJ(), 0);
		}
	}
	
	
	/**
	 * 更新学校评优表中数据
	 * @param xxpysjk
	 */
	public void updateData(XXPYSJK xxpysjk) {
		if(xxpysjk.getISDEL() == 0) {
			DataBaseUtils.update(updateSQL, xxpysjk.getRYDM(), xxpysjk.getXM(), xxpysjk.getXXKHYX(),
					xxpysjk.getJLHJ(), xxpysjk.getID());

		}else if(xxpysjk.getISDEL() == 2){
			DataBaseUtils.update(insertSQL, xxpysjk.getID(), xxpysjk.getRYDM(), 
					xxpysjk.getXM(), xxpysjk.getXXKHYX(), xxpysjk.getJLHJ(), 0);

		}
		
	}
}
