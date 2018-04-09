package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import bean.XWBTSJ;
import utils.DataBaseUtils;
import utils.excelUtils;

public class XWBTSJService {

	/**
	 * 查询本新闻补贴数据表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_xwbtsj where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XWBTSJ xwbtsj = null;
		List<XWBTSJ > list = excelUtils.analysisExcel(path, XWBTSJ.class);
		
		for(int i = 0; i < list.size(); i++) {
			xwbtsj = list.get(i);
			String sql = "insert into t_zl(gh, xm, xwnr, cs, bz, sfje, isdel)"
		            + " VALUES (?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql,xwbtsj.getGH(), xwbtsj.getXM(), xwbtsj.getXWNR(), xwbtsj.getCS(), xwbtsj.getBZ()
					,xwbtsj.getSFJE(), 0);
			}
	}
	
	
	/**
	 * 根据人员代码删除对应数据
	 * @param gH
	 */
	public void deleteByRydm(String ID) {
		String sql = "update t_xwbtsj set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新本单位奖酬金发放总报表数据
	 * @param gqry
	 */
	public void updateData(XWBTSJ xwbtsj) {
		
		//System.out.println(bdwjcjffzbb.getRYDM());
		String selectSQL = "select * from t_xwbtsj where id = ? and isdel = ?";		
		XWBTSJ selectXWBTSJ = DataBaseUtils.queryForBean(selectSQL, XWBTSJ.class, xwbtsj.getID(), 0);
		//System.out.print(selectBDWJCJFFZBB);
		if(selectXWBTSJ != null) {
			
			String sql = "update t_xwbtsj set gh = ?, xm = ?, xwnr = ?, cs = ?, bz = ?"
		            + ", sfje = ? where id = ? and isdel = ?";
			DataBaseUtils.update(sql,xwbtsj.getGH(), xwbtsj.getXM(), xwbtsj.getXWNR(), xwbtsj.getCS(), xwbtsj.getBZ()
					,xwbtsj.getSFJE(), xwbtsj.getID(), 0);
		}else {
			String sql = "insert into t_zl(gh, xm, xwnr, cs, bz, sfje, isdel)"
		            + " VALUES (?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql,xwbtsj.getGH(), xwbtsj.getXM(), xwbtsj.getXWNR(), xwbtsj.getCS(), xwbtsj.getBZ()
					,xwbtsj.getSFJE(), 0);
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
