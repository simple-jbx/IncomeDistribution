package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.YH;

public class YHService {
	
	/**
	 * 查询用户表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_yh where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	public YH getYH(String gh) {
		String sql = "select * from t_yh where gh = ? isdel = ?";
		return DataBaseUtils.queryForBean(sql, YH.class, gh, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		YH yh = null;
		List<YH > list = excelUtils.analysisExcel(path, YH.class);
		String sql = "insert into t_yh(id, gh,xm,zc,isdel) VALUES (?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			yh = list.get(i);
			DataBaseUtils.update(sql, yh.getID(), yh.getGH(), yh.getXM(), yh.getZC(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_yh set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新获奖数据
	 * @param zgsjxsgz
	 */
	public void updateData(YH yh) {
		
		if(yh.getISDEL() == 0) {
			String sql = "update t_zgsjxsgz set gh = ?, xm = ?, zc = ?, where id = ?";			
			DataBaseUtils.update(sql, yh.getGH(), yh.getXM(), yh.getZC(), yh.getID());

		}else if(yh.getISDEL() == 2){
			String sql = "insert into t_yh(id,gh,xm,zc,isdel) VALUES (?,?,?,?,?)";
			DataBaseUtils.update(sql, yh.getID(), yh.getGH(), yh.getXM(), yh.getZC(), 0);

		}
		
	}
}
