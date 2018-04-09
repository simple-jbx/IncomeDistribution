package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZGSJXS;

public class ZGSJXSService {
	
	/**
	 * 查询在岗时间系数表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_zgsjxs where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据RYDM查询单条数据
	 * @param RYDM
	 * @return ZGSJXS
	 */
	public static ZGSJXS getData(String RYDM) {
		String sql = "select * from t_zgsjxs where rydm = ? and isdel = ?";
		return DataBaseUtils.queryForBean(sql, ZGSJXS.class, RYDM, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZGSJXS zgsjxs = null;
		List<ZGSJXS > list = excelUtils.analysisExcel(path, ZGSJXS.class);
		String sql = "insert into t_zgsjxs(id,rydm,xm,zgys,zgxs,zgqksm,isdel)"
	            + " VALUES (?,?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			zgsjxs = list.get(i);			
			DataBaseUtils.update(sql, zgsjxs.getID(), zgsjxs.getRYDM(), zgsjxs.getXM(),
					zgsjxs.getZGYS(), zgsjxs.getZGXS(), zgsjxs.getZGQKSM(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_zgsjxs set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新在岗时间系数数据
	 * @param zgsjxs
	 */
	public void updateData(ZGSJXS zgsjxs) {
		if(zgsjxs.getISDEL() == 0) {
			String sql = "update t_zgsjxs set id = ?, rydm = ?, xm = ?, zgys = ?, zgxs = ?, zgqksm = ?"
					+ " where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, zgsjxs.getID(), zgsjxs.getRYDM(), zgsjxs.getXM(),
					zgsjxs.getZGYS(), zgsjxs.getZGXS(), zgsjxs.getZGQKSM(), zgsjxs.getID(), 0);
		}else if(zgsjxs.getISDEL() == 2){
			String sql = "insert into t_zgsjxs(id,rydm,xm,zgys,zgxs,zgqksm,isdel)"
		            + " VALUES (?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, zgsjxs.getID(), zgsjxs.getRYDM(), zgsjxs.getXM(),
					zgsjxs.getZGYS(), zgsjxs.getZGXS(), zgsjxs.getZGQKSM(), 0);
		}
		
	}
}
