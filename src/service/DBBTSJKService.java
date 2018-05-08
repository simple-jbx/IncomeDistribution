package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.DBBTSJK;

/**
 * 读博补贴
 * @author simple
 *
 */
public class DBBTSJKService {
	
	private final static String insertSQL = "insert into t_dbbtsjk(id,rydm,xm,db,hj,isdel) "
			+ "VALUES (?,?,?,?,?,?)";	

			
	private final static String updateSQL = "update t_dbbtsjkjk set rydm = ?, xm = ?, db = ?,"
			+ "hj = ? where id = ?";			
	
	
	public void save2DB(String path) throws IOException, SQLException {
		DBBTSJK dbbtsjk = null;
		List<DBBTSJK > dataList = excelUtils.analysisExcel(path, DBBTSJK.class);
		int listSize = 0;
		if(dataList != null)
			listSize = dataList.size();
		for(int i = 0; i < listSize; i++) {
			dbbtsjk = dataList.get(i);
			DataBaseUtils.update(insertSQL, dbbtsjk.getID(), dbbtsjk.getRYDM(), 
					dbbtsjk.getXM(), dbbtsjk.getDB(), dbbtsjk.getHJ(), 0);
		}
	}
	
	
	/**
	 * 更新读博补贴表中数据
	 * @param xxpysjk
	 */
	public void updateData(DBBTSJK dbbtsjk) {
		if(dbbtsjk.getISDEL() == 0) {
				DataBaseUtils.update(updateSQL, dbbtsjk.getRYDM(), dbbtsjk.getXM(), dbbtsjk.getDB(),
					dbbtsjk.getHJ(), dbbtsjk.getID());

		}else if(dbbtsjk.getISDEL() == 2){
			DataBaseUtils.update(insertSQL, dbbtsjk.getID(), dbbtsjk.getRYDM(), 
					dbbtsjk.getXM(), dbbtsjk.getDB(), dbbtsjk.getHJ(), 0);
		}
		
	}
}
