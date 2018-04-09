package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import bean.ZL;
import utils.DataBaseUtils;
import utils.excelUtils;

public class ZLService {

	/**
	 * 查询本专利表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_zl where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZL zl = null;
		List<ZL > list = excelUtils.analysisExcel(path, ZL.class);
		
		for(int i = 0; i < list.size(); i++) {
			zl = list.get(i);
			String sql = "insert into t_zl(zlmc, zlh, zlzsbh, dyfmhsjr, gsyx, zlfmhsjr, zzpx, qtfmhsjr, zllx"
		            + ",sqrq,shqrq,shzt,zlqr,cysl,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql,zl.getZLMC(), zl.getZLH(), zl.getZLZSBH(), zl.getDYFMHSJR(), zl.getGSYX(), zl.getZLFMHSJR(),
					zl.getZZPX(), zl.getSQRQ(), zl.getSHQRQ(), zl.getSHZT(), zl.getZLQR(), zl.getCYSL(), 0);
			}
	}
	
	
	/**
	 * 根据人员代码删除对应数据
	 * @param gH
	 */
	public void deleteByRydm(String ID) {
		String sql = "update t_zl set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新本单位奖酬金发放总报表数据
	 * @param gqry
	 */
	public void updateData(ZL zl) {
		
		//System.out.println(bdwjcjffzbb.getRYDM());
		String selectSQL = "select * from t_zl where id = ? and isdel = ?";		
		ZL selectZL = DataBaseUtils.queryForBean(selectSQL, ZL.class, zl.getID(), 0);
		//System.out.print(selectBDWJCJFFZBB);
		if(selectZL != null) {
			
			String sql = "update t_zl set zlmc = ?, zlh = ?, zlzsbh = ?, dyfmshjr = ?, gsyx = ?"
		            + ", zlfmhsjr = ?, zzpx = ?, qtfmhsjr = ?, zllx = ?, sqrq = ?, shqrq = ?, "
		            + "shzt = ?, zlqr = ?, cysl = ? where id = ? and isdel = ?";
			DataBaseUtils.update(sql,zl.getZLMC(), zl.getZLH(), zl.getZLZSBH(), zl.getDYFMHSJR(), zl.getGSYX(), zl.getZLFMHSJR(),
					zl.getZZPX(), zl.getSQRQ(), zl.getSHQRQ(), zl.getSHZT(), zl.getZLQR(), zl.getCYSL(), zl.getID(), 0);
		}else {
			String sql = "insert into t_zl(zlmc, zlh, zlzsbh, dyfmhsjr, gsyx, zlfmhsjr, zzpx, qtfmhsjr, zllx"
		            + ",sqrq,shqrq,shzt,zlqr,cysl,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql,zl.getZLMC(), zl.getZLH(), zl.getZLZSBH(), zl.getDYFMHSJR(), zl.getGSYX(), zl.getZLFMHSJR(),
					zl.getZZPX(), zl.getSQRQ(), zl.getSHQRQ(), zl.getSHZT(), zl.getZLQR(), zl.getCYSL(), 0);
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
