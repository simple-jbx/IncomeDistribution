package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import bean.LW;
import utils.DataBaseUtils;
import utils.excelUtils;

public class LWService {

	/**
	 * 查询本论文表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_lw where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		LW lw = null;
		List<LW > list = excelUtils.analysisExcel(path, LW.class);
		
		for(int i = 0; i < list.size(); i++) {
			lw = list.get(i);
			String sql = "insert into t_lw(lwtm, dyzz, zzsx, zzpx,syzz,zzrs,fbhcbsj,fbkwhlwj,lwjb"
		            + ",xxsm,shzt,sftj,kydf,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql,lw.getLWTM(), lw.getDYZZ(), lw.getZZSX(), lw.getZZPX(), lw.getSYZZ(), lw.getZZRS(), lw.getFBHCBSJ(), lw.getFBKWHLWJ(),
					lw.getLWJB(), lw.getXXSM(), lw.getSHZT(), lw.getSFTJ(), lw.getKYDF(), 0);
			}
	}
	
	
	/**
	 * 根据人员代码删除对应数据
	 * @param gH
	 */
	public void deleteByRydm(String lwtm) {
		String sql = "update t_lw set isdel = ? where lwtm = ?";
		DataBaseUtils.update(sql, 1, lwtm);
	}
	
	
	/**
	 * 更新本单位奖酬金发放总报表数据
	 * @param gqry
	 */
	public void updateData(LW lw) {
		
		//System.out.println(bdwjcjffzbb.getRYDM());
		String selectSQL = "select * from t_lw where lwtm = ? and isdel = ?";		
		LW selectLW = DataBaseUtils.queryForBean(selectSQL, LW.class, lw.getLWTM(), 0);
		//System.out.print(selectBDWJCJFFZBB);
		if(selectLW != null) {
			
			String sql = "update t_lw set dyzz = ?, zzsx = ?, zzpx = ?, syzz = ?, zzrs = ?"
		            + ", fbhcbsj = ?, fbkwhlwj = ?, lwjb = ?, xxsm = ?, shzt = ?, sftj = ?, kydf = ? where lwtm = ? and isdel = ?";
			DataBaseUtils.update(sql, lw.getDYZZ(), lw.getZZSX(), lw.getZZPX(), lw.getSYZZ(), lw.getZZRS(), lw.getFBHCBSJ(), lw.getFBKWHLWJ(),
					lw.getLWJB(), lw.getXXSM(), lw.getSHZT(), lw.getSFTJ(), lw.getKYDF(), lw.getLWTM(), 0);
		}else {
			String sql = "insert into t_lw(lwtm, dyzz, zzsx, zzpx,syzz,zzrs,fbhcbsj,fbkwhlwj,lwjb"
		            + ",xxsm,shzt,sftj,kydf,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql,lw.getLWTM(), lw.getDYZZ(), lw.getZZSX(), lw.getZZPX(), lw.getSYZZ(), lw.getZZRS(), lw.getFBHCBSJ(), lw.getFBKWHLWJ(),
					lw.getLWJB(), lw.getXXSM(), lw.getSHZT(), lw.getSFTJ(), lw.getKYDF(), 0);
		}	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
