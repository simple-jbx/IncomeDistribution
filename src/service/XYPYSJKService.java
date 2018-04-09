package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XYPYSJK;

public class XYPYSJKService {
	
	/**
	 * 查询学院评优数据表所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_xypysjk where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 查询表中单条数据
	 */
	public static XYPYSJK getData(String Rydm) {
		String sql = "select * from t_xypysjk where rydm = ? and isdel = ?";
		return DataBaseUtils.queryForBean(sql, XYPYSJK.class, Rydm, 0);
	}
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XYPYSJK xypysjk = null;
		List<XYPYSJK > list = excelUtils.analysisExcel(path, XYPYSJK.class);
		String sql = "insert into t_xxpysjk(id,rydm,xm,xykhyx,jlhj,isdel) VALUES (?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			xypysjk = list.get(i);
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), xypysjk.getRYDM(), 
					xypysjk.getXM(), xypysjk.getXYPY(), xypysjk.getJLHJ(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_xypysjk set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新学校评优表中数据
	 * @param xxpysjk
	 */
	public void updateData(XYPYSJK xypysjk) {
		if(xypysjk.getISDEL() == 0) {
			String sql = "update t_xypysjk set rydm = ?, xm = ?, xypy = ?,"
					+ "jlhj = ? where id = ?";			
			DataBaseUtils.update(sql, xypysjk.getRYDM(), xypysjk.getXM(), xypysjk.getXYPY(),
					xypysjk.getJLHJ(), xypysjk.getID());

		}else if(xypysjk.getISDEL() == 2){
			String sql = "insert into t_xypysjk(id,rydm,xm,xypy,jlhj,isdel) VALUES (?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, xypysjk.getID(), xypysjk.getRYDM(), 
					xypysjk.getXM(), xypysjk.getXYPY(), xypysjk.getJLHJ(), 0);

		}
		
	}
}
