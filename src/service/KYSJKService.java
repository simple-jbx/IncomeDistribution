package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.KYFSTJB;

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
		KYFSTJB kyfstjb = null;
		List<KYFSTJB > list = excelUtils.analysisExcel(path, KYFSTJB.class);
		for(int i = 0; i < list.size(); i++) {
			kyfstjb = list.get(i);
			String sql = "insert into t_kyfstjb(xm,zc,lwdf,xmdf,zzdf"
		            + ",zldf,cgcn,dfhj,zcc,bzf,cefz,kyjcfs,cejdf,kyjcjj"
					+",kycejj,kyjlhj,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, kyfstjb.getXM(), kyfstjb.getZC(), kyfstjb.getLWDF(), kyfstjb.getXMDF(),
					kyfstjb, kyfstjb.getZLDF(), kyfstjb.getCGCN(), kyfstjb.getDFHJ(), kyfstjb.getZCC(),
					kyfstjb.getBZF(), kyfstjb.getCEFZ(), kyfstjb.getKYJCFS(), kyfstjb.getCEJDF(), kyfstjb.getKYJCJJ(),
					kyfstjb.getKYCEJJ(), kyfstjb.getKYJLHJ(), 0);
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
	public void updateData(KYFSTJB kyfstjb) {
		String selectSQL = "select * from t_kyfstjb where id = ? and isdel = ?";
		KYFSTJB selectKYFSTJB = DataBaseUtils.queryForBean(selectSQL, KYFSTJB.class, kyfstjb.getID(), 0);

		if(selectKYFSTJB != null) {
			String sql = "update t_kyfstjb set xm = ?, zc = ?, lwdf = ?, xmdf = ?, zzdf = ?,"
					+ "zldf = ?, zgcn = ?, dfhj = ?, zcc = ?, bzf = ?, cefz = ?, kyjcfs = ?,"
					+"cejdf = ?, kyjcjj = ?, kycejj = ?, kyjlhj = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, kyfstjb.getXM(), kyfstjb.getZC(), kyfstjb.getLWDF(), kyfstjb.getXMDF(),
					kyfstjb.getZZDF(), kyfstjb.getZLDF(), kyfstjb.getCGCN(), kyfstjb.getDFHJ(), kyfstjb.getZCC(),
					kyfstjb.getBZF(), kyfstjb.getCEFZ(), kyfstjb.getKYJCFS(), kyfstjb.getCEJDF(), kyfstjb.getKYJCJJ(),
					kyfstjb.getKYCEJJ(), kyfstjb.getKYJLHJ(), kyfstjb.getID(), 0);
		}else {
			String sql = "insert into t_kyfstjb(xm,zc,lwdf,xmdf,zzdf"
		            + ",zldf,cgcn,dfhj,zcc,bzf,cefz,kyjcfs,cejdf,kyjcjj"
					+",kycejj,kyjlhj,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, kyfstjb.getXM(), kyfstjb.getZC(), kyfstjb.getLWDF(), kyfstjb.getXMDF(),
					kyfstjb.getZZDF(), kyfstjb.getZLDF(), kyfstjb.getCGCN(), kyfstjb.getDFHJ(), kyfstjb.getZCC(),
					kyfstjb.getBZF(), kyfstjb.getCEFZ(), kyfstjb.getKYJCFS(), kyfstjb.getCEJDF(), kyfstjb.getKYJCJJ(),
					kyfstjb.getKYCEJJ(), kyfstjb.getKYJLHJ(), 0);
		}
		
	}
}
