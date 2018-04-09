package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XYQTRY;

public class XYQTRYService {
	
	/**
	 * 查询学院其他人员表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_xyqtry where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XYQTRY xyqtry = null;
		List<XYQTRY > list = excelUtils.analysisExcel(path, XYQTRY.class);
		for(int i = 0; i < list.size(); i++) {
			xyqtry = list.get(i);
			String sql = "insert into t_gzljjkxxb(gh,xm,zb,cgzl,cgzljj,jxdd,jthd,"
					+ "jcjhj,isdel) VALUES (?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, xyqtry.getGH(), xyqtry.getXM(), xyqtry.getZB(),
					xyqtry.getCGZL(), xyqtry.getCGZLJL(), xyqtry.getJXDD(),xyqtry.getJTHD(),
					xyqtry.getJCJHJ(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_xyqtry set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新2016年学院大会考勤数据
	 * @param elylxydhkq
	 */
	public void updateData(XYQTRY xyqtry) {
		String selectSQL = "select * from t_xyqtry where id = ? and isdel = ?";
		XYQTRY selectXYQTRY = DataBaseUtils.queryForBean(selectSQL, XYQTRY.class, xyqtry.getID(), 0);

		if(selectXYQTRY != null) {
			String sql = "update t_zhtxgrdfjlxx set gh = ?, xm = ?, zb = ?, zgzl = ?,"
					+ "cgzljj = ?, jxdd = ?, jthd = ?, jcjhj = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, xyqtry.getGH(), xyqtry.getXM(), xyqtry.getZB(),
					xyqtry.getCGZL(), xyqtry.getCGZLJL(), xyqtry.getJXDD(),xyqtry.getJTHD(),
					xyqtry.getJCJHJ(), xyqtry.getID(), 0); 
		}else {
			String sql = "insert into t_gzljjkxxb(gh,xm,zb,cgzl,cgzljj,jxdd,jthd,"
					+ "jcjhj,isdel) VALUES (?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, xyqtry.getGH(), xyqtry.getXM(), xyqtry.getZB(),
					xyqtry.getCGZL(), xyqtry.getCGZLJL(), xyqtry.getJXDD(),xyqtry.getJTHD(),
					xyqtry.getJCJHJ(), 0); 
		}
		
	}
}
