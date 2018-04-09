package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import bean.YJSGZSJ;
import utils.DataBaseUtils;
import utils.excelUtils;

public class YJSGZSJService {

	/**
	 * 查询研究生工作数据表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_yjsgzsj where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		YJSGZSJ yjsgzsj = null;
		List<YJSGZSJ > list = excelUtils.analysisExcel(path, YJSGZSJ.class);
		
		for(int i = 0; i < list.size(); i++) {
			yjsgzsj = list.get(i);
			String sql = "insert into t_yjsgzsj(gh,xm,yjsgzl,msksf,zbf"
		            + ",pgzy,msgzl,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, yjsgzsj.getGH(), yjsgzsj.getXM(), yjsgzsj.getYJSGZL(), yjsgzsj.getMSKSF(),
					yjsgzsj.getZBF(), yjsgzsj.getPGZY(), yjsgzsj.getMSGZL(), 0);
			}
	}
	
	
	/**
	 * 根据人员代码删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_yjsgzsj set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新本单位奖酬金发放总报表数据
	 * @param gqry
	 */
	public void updateData(YJSGZSJ yjsgzsj) {
		
		//System.out.println(bdwjcjffzbb.getRYDM());
		String selectSQL = "select * from t_yjsgzsj where id = ? and isdel = ?";		
		YJSGZSJ selectYJSGZSJ = DataBaseUtils.queryForBean(selectSQL, YJSGZSJ.class, yjsgzsj.getID(), 0);
		//System.out.print(selectBDWJCJFFZBB);
		if(selectYJSGZSJ != null) {
			
			String sql = "update t_wdwjcjffzbb set gh = ?, xm = ?, yjsgzl = ?, msksf = ?, zbf = ?"
		            + ", pgzy = ?, msgzl = ? where id = ? and isdel = ?";
			DataBaseUtils.update(sql, yjsgzsj.getGH(), yjsgzsj.getXM(), yjsgzsj.getYJSGZL(), yjsgzsj.getMSKSF(),
					yjsgzsj.getZBF(), yjsgzsj.getPGZY(), yjsgzsj.getMSGZL(), yjsgzsj.getID(), 0);
		}else {
			String sql = "insert into t_yjsgzsj(gh,xm,yjsgzl,msksf,zbf"
		            + ",pgzy,msgzl,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, yjsgzsj.getGH(), yjsgzsj.getXM(), yjsgzsj.getYJSGZL(), yjsgzsj.getMSKSF(),
					yjsgzsj.getZBF(), yjsgzsj.getPGZY(), yjsgzsj.getMSGZL(), 0);
		}	
	}
}
