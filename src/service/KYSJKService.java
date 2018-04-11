package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.KYCGJCSJK;

public class KYSJKService {
	
	/**
	 * 查询科研分数统计表中所有数据
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
		KYCGJCSJK kycgjcsjk = null;
		List<KYCGJCSJK > list = excelUtils.analysisExcel(path, KYCGJCSJK.class);
		for(int i = 0; i < list.size(); i++) {
			kycgjcsjk = list.get(i);
			String sql = "insert into t_kyfstjb(xm,zc,lwdf,xmdf,zzdf"
		            + ",zldf,cgcn,dfhj,zcc,bzf,cefz,kyjcfs,cejdf,kyjcjj"
					+",kycejj,kyjlhj,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, kycgjcsjk.getXM(), kycgjcsjk.getZC(), kycgjcsjk.getLWDF(), kycgjcsjk.getXMDF(),
					kycgjcsjk, kycgjcsjk.getZLDF(), kycgjcsjk.getCGCN(), kycgjcsjk.getDFHJ(), kycgjcsjk.getZCC(),
					kycgjcsjk.getBZF(), kycgjcsjk.getCEFZ(), kycgjcsjk.getKYJCFS(), kycgjcsjk.getCEJDF(), kycgjcsjk.getKYJCJJ(),
					kycgjcsjk.getKYCEJJ(), kycgjcsjk.getKYJLHJ(), 0);
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
	 * 更新2016年学院大会考勤数据
	 * @param elylxydhkq
	 */
	public void updateData(KYCGJCSJK kycgjcsjk) {
		String selectSQL = "select * from t_kyfstjb where id = ? and isdel = ?";
		KYCGJCSJK selectKYFSTJB = DataBaseUtils.queryForBean(selectSQL, KYCGJCSJK.class, kycgjcsjk.getID(), 0);

		if(selectKYFSTJB != null) {
			String sql = "update t_kyfstjb set xm = ?, zc = ?, lwdf = ?, xmdf = ?, zzdf = ?,"
					+ "zldf = ?, zgcn = ?, dfhj = ?, zcc = ?, bzf = ?, cefz = ?, kyjcfs = ?,"
					+"cejdf = ?, kyjcjj = ?, kycejj = ?, kyjlhj = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, kycgjcsjk.getXM(), kycgjcsjk.getZC(), kycgjcsjk.getLWDF(), kycgjcsjk.getXMDF(),
					kycgjcsjk.getZZDF(), kycgjcsjk.getZLDF(), kycgjcsjk.getCGCN(), kycgjcsjk.getDFHJ(), kycgjcsjk.getZCC(),
					kycgjcsjk.getBZF(), kycgjcsjk.getCEFZ(), kycgjcsjk.getKYJCFS(), kycgjcsjk.getCEJDF(), kycgjcsjk.getKYJCJJ(),
					kycgjcsjk.getKYCEJJ(), kycgjcsjk.getKYJLHJ(), kycgjcsjk.getID(), 0);
		}else {
			String sql = "insert into t_kyfstjb(xm,zc,lwdf,xmdf,zzdf"
		            + ",zldf,cgcn,dfhj,zcc,bzf,cefz,kyjcfs,cejdf,kyjcjj"
					+",kycejj,kyjlhj,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, kycgjcsjk.getXM(), kycgjcsjk.getZC(), kycgjcsjk.getLWDF(), kycgjcsjk.getXMDF(),
					kycgjcsjk.getZZDF(), kycgjcsjk.getZLDF(), kycgjcsjk.getCGCN(), kycgjcsjk.getDFHJ(), kycgjcsjk.getZCC(),
					kycgjcsjk.getBZF(), kycgjcsjk.getCEFZ(), kycgjcsjk.getKYJCFS(), kycgjcsjk.getCEJDF(), kycgjcsjk.getKYJCJJ(),
					kycgjcsjk.getKYCEJJ(), kycgjcsjk.getKYJLHJ(), 0);
		}
		
	}
}
