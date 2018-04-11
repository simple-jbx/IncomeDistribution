package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XXPYSJK;

public class XXPYSJKService {
	
	/**
	 * 查询学校评优数据表所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_xxpysjk where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据人员代码查询单条数据
	 * @return XXPYSJK
	 */
	public static XXPYSJK getData(String Rydm) {
		String sql = "select * from t_xxpysjk where rydm = ? and isdel = ?";
		return DataBaseUtils.queryForBean(sql, XXPYSJK.class, Rydm, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XXPYSJK xxpysjk = null;
		List<XXPYSJK > list = excelUtils.analysisExcel(path, XXPYSJK.class);
		String sql = "insert into t_xxpysjk(id,rydm,xm,xxkhyx,jlhj,isdel) VALUES (?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			xxpysjk = list.get(i);
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), xxpysjk.getRYDM(), 
					xxpysjk.getXM(), xxpysjk.getXXKHYX(), xxpysjk.getJLHJ(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_xxpysjk set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新学校评优表中数据
	 * @param xxpysjk
	 */
	public void updateData(XXPYSJK xxpysjk) {
		if(xxpysjk.getISDEL() == 0) {
			String sql = "update t_xxpysjk set rydm = ?, xm = ?, xxkhyx = ?,"
					+ "jlhj = ? where id = ?";			
			DataBaseUtils.update(sql, xxpysjk.getRYDM(), xxpysjk.getXM(), xxpysjk.getXXKHYX(),
					xxpysjk.getJLHJ(), xxpysjk.getID());

		}else if(xxpysjk.getISDEL() == 2){
			String sql = "insert into t_xxpysjk(id,rydm,xm,xxkhyx,jlhj,isdel) VALUES (?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, xxpysjk.getID(), xxpysjk.getRYDM(), 
					xxpysjk.getXM(), xxpysjk.getXXKHYX(), xxpysjk.getJLHJ(), 0);

		}
		
	}
}
