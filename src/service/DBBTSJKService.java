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
	
	/**
	 * 查询读博补贴数据表所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_dbbtsjk where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
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
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_dbbtsjk set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
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
