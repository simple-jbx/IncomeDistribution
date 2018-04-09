package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.KYFSTJB;

public class KYFSTJBService {
	
	/**
	 * 查询科研成果基础数据库中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_kyfstjb where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		KYFSTJB kyfstjb = null;
		List<KYFSTJB > list = excelUtils.analysisExcel(path, KYFSTJB.class);
		String sql = "insert into t_kyfstjb(id,gh,xm,lwfs,xmfs,zzfs,zlfs"
				+"isdel) VALUES (?,?,?,?,?,?,?,?)";
		for(int i = 0; i < list.size(); i++) {
			kyfstjb = list.get(i);				
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), kyfstjb.getGH(), kyfstjb.getXM(),
					kyfstjb.getLWFS(), kyfstjb.getXMFS(), kyfstjb.getZZFS(), kyfstjb.getZLFS(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_kyfstjb set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新科研成果基础数据库
	 * @param elylxydhkq
	 */
	public void updateData(KYFSTJB kyfstjb) {
		if(kyfstjb.getISDEL() == 0) {
			String sql = "update t_kyfstjb set gh = ?, xm = ?, lwfs = ?, xmfs = ?, zzfs = ?,"
					+ "zlfs = ? where id = ?";			
			DataBaseUtils.update(sql, kyfstjb.getGH(), kyfstjb.getXM(), kyfstjb.getLWFS(), 
					kyfstjb.getXMFS(), kyfstjb.getZZFS(), kyfstjb.getZLFS(), kyfstjb.getID());
		}else if(kyfstjb.getISDEL() == 2){
			String sql = "insert into t_kyfstjb(id,gh,xm,lwfs,xmfs,zzfs,zlfs,"
					+"isdel) VALUES (?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, kyfstjb.getID(), kyfstjb.getGH(), kyfstjb.getXM(),
					kyfstjb.getLWFS(), kyfstjb.getXMFS(), kyfstjb.getZZFS(), kyfstjb.getZLFS(), 0);
		}	
	}
}
