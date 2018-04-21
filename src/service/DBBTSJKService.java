package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.DBBTSJK;

public class DBBTSJKService {
	
	public void save2DB(String path) throws IOException, SQLException {
		DBBTSJK dbbtsjk = null;
		List<DBBTSJK > list = excelUtils.analysisExcel(path, DBBTSJK.class);
		String sql = "insert into t_dbbtsjk(id,rydm,xm,db,hj,isdel) VALUES (?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			dbbtsjk = list.get(i);
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), dbbtsjk.getRYDM(), 
					dbbtsjk.getXM(), dbbtsjk.getDB(), dbbtsjk.getHJ(), 0);
		}
	}
	
	
	/**
	 * 更新读博补贴表中数据
	 * @param xxpysjk
	 */
	public void updateData(DBBTSJK dbbtsjk) {
		if(dbbtsjk.getISDEL() == 0) {
			String sql = "update t_dbbtsjkjk set rydm = ?, xm = ?, db = ?,"
					+ "hj = ? where id = ?";			
			DataBaseUtils.update(sql, dbbtsjk.getRYDM(), dbbtsjk.getXM(), dbbtsjk.getDB(),
					dbbtsjk.getHJ(), dbbtsjk.getID());

		}else if(dbbtsjk.getISDEL() == 2){
			String sql = "insert into t_dbbtsjk(id,rydm,xm,db,hj,isdel) VALUES (?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), dbbtsjk.getRYDM(), 
					dbbtsjk.getXM(), dbbtsjk.getDB(), dbbtsjk.getHJ(), 0);
		}
		
	}
}
