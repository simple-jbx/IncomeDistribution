package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZC;

public class ZCService {
	
	/**
	 * 查询职称科研标准分表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_zc where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZC zc = null;
		List<ZC > list = excelUtils.analysisExcel(path, ZC.class);
		String sql = "insert into t_zc(id,zc,kybzf,isdel) VALUES (?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			zc= list.get(i);
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), zc.getZC(), 
					zc.getKYBZF(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_zc set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新获奖数据
	 * @param zgsjxsgz
	 */
	public void updateData(ZC zc) {
		String selectSQL = "select * from t_zc where id = ? and isdel = ?";
		ZC selectZGSJXSGZ = DataBaseUtils.queryForBean(selectSQL, ZC.class, zc.getID(), 0);

		if(selectZGSJXSGZ != null) {
			String sql = "update t_zc set zc = ?, kybzf = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, zc.getZC(), zc.getKYBZF(), zc.getID(), zc.getISDEL());

		}else {
			String sql = "insert into t_zc(id,zc,kybzf,isdel) VALUES (?,?,?,?)";		
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), zc.getZC(), 
					zc.getKYBZF(), 0);
		}
		
	}
}
