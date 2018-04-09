package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.BDWJCJFFZBB;


public class BDWJCJFFZBBService {
	/**
	 * 查询本单位奖酬金发放总报表表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_bdwjcjffzbb where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		BDWJCJFFZBB bdwjcjffzbb = null;
		List<BDWJCJFFZBB > list = excelUtils.analysisExcel(path, BDWJCJFFZBB.class);
		
		for(int i = 0; i < list.size(); i++) {
			bdwjcjffzbb = list.get(i);
			String sql = "insert into t_bdwjcjffzbb(xh,rydm,xm,bmmc,yfnzj,grtzje"
		            + ",nzjhj,nzjks,nzjsf,sfzhm,yhkh,dhhm,bz,qzqr,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, bdwjcjffzbb.getXH(), bdwjcjffzbb.getRYDM(), bdwjcjffzbb.getXM(), bdwjcjffzbb.getBMMC(), bdwjcjffzbb.getYFNZJ(),
					bdwjcjffzbb.getGRTZJE(), bdwjcjffzbb.getNZJHJ(), bdwjcjffzbb.getNZJKS(), bdwjcjffzbb.getNZJSF(), bdwjcjffzbb.getSFZHM(), bdwjcjffzbb.getYHKH(), bdwjcjffzbb.getDHHM(), 
					bdwjcjffzbb.getBZ(), bdwjcjffzbb.getQZQR(), 0);
			}
	}
	
	
	/**
	 * 根据人员代码删除对应数据
	 * @param gH
	 */
	public void deleteByRydm(String Rydm) {
		String sql = "update t_bdwjcjffzbb set isdel = ? where rydm = ?";
		DataBaseUtils.update(sql, 1, Rydm);
	}
	
	
	/**
	 * 更新本单位奖酬金发放总报表数据
	 * @param gqry
	 */
	public void updateData(BDWJCJFFZBB bdwjcjffzbb) {
		
		//System.out.println(bdwjcjffzbb.getRYDM());
		String selectSQL = "select * from t_bdwjcjffzbb where rydm = ? and isdel = ?";		
		BDWJCJFFZBB selectBDWJCJFFZBB = DataBaseUtils.queryForBean(selectSQL, BDWJCJFFZBB.class, bdwjcjffzbb.getRYDM(), 0);
		//System.out.print(selectBDWJCJFFZBB);
		if(selectBDWJCJFFZBB != null) {
			
			String sql = "update t_bdwjcjffzbb set xh = ?, rydm = ?, xm = ?, bmmc = ?, yfnzj = ?, grtzje = ?"
		            + ", nzjhj = ?, nzjks = ?, nzjsf = ?, sfzhm = ?, yhkh = ?, dhhm = ?, bz = ?, qzqr = ? where rydm = ? and isdel = ?";
			DataBaseUtils.update(sql, bdwjcjffzbb.getXH(), bdwjcjffzbb.getRYDM(), bdwjcjffzbb.getXM(), bdwjcjffzbb.getBMMC(), bdwjcjffzbb.getYFNZJ(),
					bdwjcjffzbb.getGRTZJE(), bdwjcjffzbb.getNZJHJ(), bdwjcjffzbb.getNZJKS(), bdwjcjffzbb.getNZJSF(), bdwjcjffzbb.getSFZHM(),
					bdwjcjffzbb.getYHKH(), bdwjcjffzbb.getDHHM(), bdwjcjffzbb.getBZ(), bdwjcjffzbb.getQZQR(), bdwjcjffzbb.getRYDM(), 0);
		}else {
			String sql = "insert into t_bdwjcjffzbb(xh,rydm,xm,bmmc,yfnzj,grtzje"
		            + ",nzjhj,nzjks,nzjsf,sfzhm,yhkh,dhhm,bz,qzqr,isdel)"
		            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, bdwjcjffzbb.getXH(), bdwjcjffzbb.getRYDM(), bdwjcjffzbb.getXM(), bdwjcjffzbb.getBMMC(), bdwjcjffzbb.getYFNZJ(),
					bdwjcjffzbb.getGRTZJE(), bdwjcjffzbb.getNZJHJ(), bdwjcjffzbb.getNZJKS(), bdwjcjffzbb.getNZJSF(), bdwjcjffzbb.getSFZHM(), bdwjcjffzbb.getYHKH(), bdwjcjffzbb.getDHHM(), 
					bdwjcjffzbb.getBZ(), bdwjcjffzbb.getQZQR(), 0);
		}	
	}
}
