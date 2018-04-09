package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.GZLJJKXXB;

public class GZLJJKXXBService {
	
	/**
	 * 查询工作量及监考信息表表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_gzljjkxxb where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		GZLJJKXXB gzljjkxxb = null;
		List<GZLJJKXXB > list = excelUtils.analysisExcel(path, GZLJJKXXB.class);
		for(int i = 0; i < list.size(); i++) {
			gzljjkxxb = list.get(i);
			String sql = "insert into t_gzljjkxxb(xh,jsxm,ggkgzly,zykgzly,qtgzly,ggkgzle,zykgzle,"
					+ "qtgzle,bkxj,yjsgzl,hj,bz,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, gzljjkxxb.getXH(), gzljjkxxb.getJSXM(), gzljjkxxb.getGGKGZLY(),
					gzljjkxxb.getZYKGZLE(), gzljjkxxb.getQTGZLE(), gzljjkxxb.getGGKGZLE(),
					gzljjkxxb.getZYKGZLE(), gzljjkxxb.getQTGZLE(), gzljjkxxb.getBKXJ(), 
					gzljjkxxb.getYJSGZL(), gzljjkxxb.getHJ(), gzljjkxxb.getBZ(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_gzljjkxxb set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新2016年学院大会考勤数据
	 * @param elylxydhkq
	 */
	public void updateData(GZLJJKXXB gzljjkxxb) {
		String selectSQL = "select * from t_gzljjkxxb where id = ? and isdel = ?";
		GZLJJKXXB selectGZLJJKXXB = DataBaseUtils.queryForBean(selectSQL, GZLJJKXXB.class, gzljjkxxb.getID(), 0);

		if(selectGZLJJKXXB != null) {
			String sql = "update t_zhtxgrdfjlxx set xh = ?, jsxm = ?, ggkgzly = ?, zykgzly = ?,"
					+ "qtgzly = ?, ggkgzle = ?, zykgzle = ?, qtgzle = ?, bkxj = ?, yjsgzl = ?,"
					+ "hj = ?, bz = ?  where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, gzljjkxxb.getXH(), gzljjkxxb.getJSXM(), gzljjkxxb.getGGKGZLY(),
					gzljjkxxb.getZYKGZLE(), gzljjkxxb.getQTGZLE(), gzljjkxxb.getGGKGZLE(),
					gzljjkxxb.getZYKGZLE(), gzljjkxxb.getQTGZLE(), gzljjkxxb.getBKXJ(), 
					gzljjkxxb.getYJSGZL(), gzljjkxxb.getHJ(), gzljjkxxb.getBZ(), gzljjkxxb.getID(), 0); 
		}else {
			String sql = "insert into t_gzljjkxxb(xh,jsxm,ggkgzly,zykgzly,qtgzly,ggkgzle,zykgzle,"
					+ "qtgzle,bkxj,yjsgzl,hj,bz,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, gzljjkxxb.getXH(), gzljjkxxb.getJSXM(), gzljjkxxb.getGGKGZLY(),
					gzljjkxxb.getZYKGZLE(), gzljjkxxb.getQTGZLE(), gzljjkxxb.getGGKGZLE(),
					gzljjkxxb.getZYKGZLE(), gzljjkxxb.getQTGZLE(), gzljjkxxb.getBKXJ(), 
					gzljjkxxb.getYJSGZL(), gzljjkxxb.getHJ(), gzljjkxxb.getBZ(), 0); 
		}
		
	}
}
