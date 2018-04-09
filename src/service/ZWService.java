package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZW;

public class ZWService {
	
	/**
	 * 查询职务与职务系数表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_zw where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZW zw = null;
		List<ZW > list = excelUtils.analysisExcel(path, ZW.class);
		String sql = "insert into t_zw(id,zw,zwxs,isdel) VALUES (?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			zw= list.get(i);
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), zw.getZW(), 
					zw.getZWXS(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_zw set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新获奖数据
	 * @param zgsjxsgz
	 */
	public void updateData(ZW zw) {
		String selectSQL = "select * from t_zw where id = ? and isdel = ?";
		ZW selectzw = DataBaseUtils.queryForBean(selectSQL, ZW.class, zw.getID(), 0);
		if(selectzw != null) {
			String sql = "update t_zw set zw = ?, zwxs = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, zw.getZW(), zw.getZWXS(), zw.getID(), zw.getISDEL());

		}else {
			String sql = "insert into t_zw(id,zw,zwxs,isdel) VALUES (?,?,?,?)";			
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), zw.getZW(), 
					zw.getZWXS(), 0);
		}
		
	}
}
