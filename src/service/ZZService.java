package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import bean.ZZ;
import utils.DataBaseUtils;
import utils.excelUtils;

public class ZZService {

	/**
	 * 查询著作表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_zz where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZZ zz = null;
		List<ZZ > list = excelUtils.analysisExcel(path,ZZ.class);
		
		for(int i = 0; i < list.size(); i++) {
			zz = list.get(i);
			String sql = "insert into t_zz(zztm,dyzz,zzpx,syzz,cbdw"
		            + ",cbsj,xxsm,zzlb,zzs,cbrs,shzt,sftj,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, zz.getZZTM(), zz.getDYZZ(), zz.getZZPX(), zz.getSYZZ(),
					zz.getCBDW(), zz.getCBSJ(), zz.getXXSM(), zz.getZZLB(), zz.getZZS(),
					zz.getCBRS(), zz.getSHZT(), zz.getSFTJ(), 0);
			}
	}
	
	
	/**
	 * 根据人员代码删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_zz set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新本单位奖酬金发放总报表数据
	 * @param gqry
	 */
	public void updateData(ZZ zz) {
		
		//System.out.println(bdwjcjffzbb.getRYDM());
		String selectSQL = "select * from t_wdwjcjffzbb where id = ? and isdel = ?";		
		ZZ selectZZ = DataBaseUtils.queryForBean(selectSQL, ZZ.class, zz.getID(), 0);
		//System.out.print(selectBDWJCJFFZBB);
		if(selectZZ != null) {
			
			String sql = "update t_zz set zztm = ?, dyzz = ?, zzpx = ?, syzz = ?, cbdw = ?"
		            + ", cbsj = ?, xxsm = ?, zzlb = ?, zzs = ?, cbrs = ?, shzt = ?, sftj = ? where id = ? and isdel = ?";
			DataBaseUtils.update(sql, zz.getZZTM(), zz.getDYZZ(), zz.getZZPX(), zz.getSYZZ(),
					zz.getCBDW(), zz.getCBSJ(), zz.getXXSM(), zz.getZZLB(), zz.getZZS(),
					zz.getCBRS(), zz.getSHZT(), zz.getSFTJ(), zz.getID(), 0);
		}else {
			String sql = "insert into t_zz(zztm,dyzz,zzpx,syzz,cbdw"
		            + ",cbsj,xxsm,zzlb,zzs,cbrs,shzt,sftj,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, zz.getZZTM(), zz.getDYZZ(), zz.getZZPX(), zz.getSYZZ(),
					zz.getCBDW(), zz.getCBSJ(), zz.getXXSM(), zz.getZZLB(), zz.getZZS(),
					zz.getCBRS(), zz.getSHZT(), zz.getSFTJ(), 0);
		}	
	}
}
