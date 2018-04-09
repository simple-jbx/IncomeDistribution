package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZJ;

public class ZJService {
	
	/**
	 * 查询职务与职务系数表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_zj where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZJ zj = null;
		List<ZJ > list = excelUtils.analysisExcel(path, ZJ.class);
		String sql = "insert into t_zj(id,zj,zjxs,dj,isdel) VALUES (?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			zj = list.get(i);
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), zj.getZJ(), 
					zj.getZJXS(), zj.getDJ(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_zj set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新获奖数据
	 * @param zgsjxsgz
	 */
	public void updateData(ZJ zj) {
		String selectSQL = "select * from t_zw where id = ? and isdel = ?";
		ZJ selectzw = DataBaseUtils.queryForBean(selectSQL, ZJ.class, zj.getID(), 0);
		if(selectzw != null) {
			String sql = "update t_zj set zj = ?, zjxs = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, zj.getZJ(), zj.getZJXS(), zj.getDJ(), zj.getISDEL());

		}else {
			String sql = "insert into t_zj(id,zj,zjxs,dj,isdel) VALUES (?,?,?,?,?)";	
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), zj.getZJ(), 
					zj.getZJXS(), zj.getDJ(), 0);
		}
		
	}
}
