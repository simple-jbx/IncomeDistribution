package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.KYCGJCSJK;

public class KYCGJCSJKService {
	
	/**
	 * 查询科研成果基础数据库中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_kycgjcsjk where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据人员代码查询对应人员科在研成果基础数据表中数据
	 * @return
	 */
	public static KYCGJCSJK getData(String Gh) {
		String sql = "select * from t_kycgjcsjk where gh = ? and isdel = ?";
		return DataBaseUtils.queryForBean(sql, KYCGJCSJK.class, Gh, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		KYCGJCSJK kycgjcsjk = null;
		List<KYCGJCSJK > list = excelUtils.analysisExcel(path, KYCGJCSJK.class);
		String sql = "insert into t_kycgjcsjk(id,gh,xm,lwfs,xmfs,zzfs,zlfs"
				+"isdel) VALUES (?,?,?,?,?,?,?,?)";
		for(int i = 0; i < list.size(); i++) {
			kycgjcsjk = list.get(i);				
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), kycgjcsjk.getGH(), kycgjcsjk.getXM(),
					kycgjcsjk.getLWFS(), kycgjcsjk.getXMFS(), kycgjcsjk.getZZFS(), kycgjcsjk.getZLFS(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_kycgjcsjk set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新科研成果基础数据库
	 * @param elylxydhkq
	 */
	public void updateData(KYCGJCSJK kycgjcsjk) {
		if(kycgjcsjk.getISDEL() == 0) {
			String sql = "update t_kycgjcsjk set gh = ?, xm = ?, lwfs = ?, xmfs = ?, zzfs = ?,"
					+ "zlfs = ? where id = ?";			
			DataBaseUtils.update(sql, kycgjcsjk.getGH(), kycgjcsjk.getXM(), kycgjcsjk.getLWFS(), 
					kycgjcsjk.getXMFS(), kycgjcsjk.getZZFS(), kycgjcsjk.getZLFS(), kycgjcsjk.getID());
		}else if(kycgjcsjk.getISDEL() == 2){
			String sql = "insert into t_kycgjcsjk(id,gh,xm,lwfs,xmfs,zzfs,zlfs,"
					+"isdel) VALUES (?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, kycgjcsjk.getID(), kycgjcsjk.getGH(), kycgjcsjk.getXM(),
					kycgjcsjk.getLWFS(), kycgjcsjk.getXMFS(), kycgjcsjk.getZZFS(), kycgjcsjk.getZLFS(), 0);
		}	
	}
}
