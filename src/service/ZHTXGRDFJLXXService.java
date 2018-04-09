package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZHTXGRDFJLXX;

public class ZHTXGRDFJLXXService {
	
	/**
	 * 查询综合体系个人得分奖励信息表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_zhtxgrdfjlxx where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZHTXGRDFJLXX zhtxgrdfjlxx = null;
		List<ZHTXGRDFJLXX > list = excelUtils.analysisExcel(path, ZHTXGRDFJLXX.class);
		for(int i = 0; i < list.size(); i++) {
			zhtxgrdfjlxx = list.get(i);
			String sql = "insert into t_zhtxgrdfjlxx(xm,dfxm,nx,jlje,isdel) VALUES (?,?,?,?,?)";	
			DataBaseUtils.update(sql, zhtxgrdfjlxx.getXM(), zhtxgrdfjlxx.getDFXM(), zhtxgrdfjlxx.getNX(),
					zhtxgrdfjlxx.getJLJE(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_zhtxgrdfjlxx set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新2016年学院大会考勤数据
	 * @param elylxydhkq
	 */
	public void updateData(ZHTXGRDFJLXX zhtxgrdfjlxx) {
		String selectSQL = "select * from t_zhtxgrdfjlxx where id = ? and isdel = ?";
		ZHTXGRDFJLXX selectZHTXGRDFJLXX = DataBaseUtils.queryForBean(selectSQL, ZHTXGRDFJLXX.class, zhtxgrdfjlxx.getID(), 0);

		if(selectZHTXGRDFJLXX != null) {
			String sql = "update t_zhtxgrdfjlxx set xm = ?, dfxm = ?, nx = ?, jlje = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, zhtxgrdfjlxx.getXM(), zhtxgrdfjlxx.getDFXM(), zhtxgrdfjlxx.getNX(),
					zhtxgrdfjlxx.getJLJE(), zhtxgrdfjlxx.getID(), 0);
		}else {
			String sql = "insert into t_elylxydhkq(xm,dfxm,nx,jlje,isdel) VALUES (?,?,?,?,?)";	
			DataBaseUtils.update(sql, zhtxgrdfjlxx.getXM(), zhtxgrdfjlxx.getDFXM(), zhtxgrdfjlxx.getNX(),
					zhtxgrdfjlxx.getJLJE(), 0);
		}
		
	}
}
