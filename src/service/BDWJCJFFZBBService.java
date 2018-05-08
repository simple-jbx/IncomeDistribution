package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.BDWJCJFFZBB;


public class BDWJCJFFZBBService {
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		BDWJCJFFZBB bdwjcjffzbb = null;
		List<BDWJCJFFZBB > list = excelUtils.analysisExcel(path, BDWJCJFFZBB.class);
		String sql = "insert into t_bdwjcjffzbb(id,bmdm,rydm,xm,bmmc,jx,xz,gq,qt,nzjje,cssl,nd,isdel)"
	            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			bdwjcjffzbb = list.get(i);
			DataBaseUtils.update(sql,bdwjcjffzbb.getBMDM(),bdwjcjffzbb.getRYDM(),bdwjcjffzbb.getXM(),
				bdwjcjffzbb.getBMMC(),bdwjcjffzbb.getJX(),bdwjcjffzbb.getXZ(),bdwjcjffzbb.getGQ(),
				bdwjcjffzbb.getQT(),bdwjcjffzbb.getNZJJE(),bdwjcjffzbb.getCSSL(),bdwjcjffzbb.getND(),
				config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新本单位奖酬金发放总报表数据
	 * @param gqry
	 */
	public void updateData(BDWJCJFFZBB bdwjcjffzbb) {
		
		//System.out.println(bdwjcjffzbb.getRYDM());
			//System.out.print(selectBDWJCJFFZBB);
		if(bdwjcjffzbb.getISDEL() == config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			
			String sql = "update t_bdwjcjffzbb set bmdm=?, rydm=?, xm=?, bmmc=?, jx=?, gq=?,qt=?, nzjje=?,"
					+ "cssl=?, nd=? where rydm=? and isdel=?";
			DataBaseUtils.update(sql,bdwjcjffzbb.getBMDM(),bdwjcjffzbb.getRYDM(),bdwjcjffzbb.getXM(),
					bdwjcjffzbb.getBMMC(),bdwjcjffzbb.getJX(),bdwjcjffzbb.getXZ(),bdwjcjffzbb.getGQ(),
					bdwjcjffzbb.getQT(),bdwjcjffzbb.getNZJJE(),bdwjcjffzbb.getCSSL(),bdwjcjffzbb.getND(),
					bdwjcjffzbb.getID());
		}else if(bdwjcjffzbb.getISDEL() == config.DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			String sql = "insert into t_bdwjcjffzbb(id,bmdm,rydm,xm,bmmc,jx,xz,gq,qt,nzjje,cssl,nd,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql,bdwjcjffzbb.getID(),bdwjcjffzbb.getBMDM(),bdwjcjffzbb.getRYDM(),bdwjcjffzbb.getXM(),
					bdwjcjffzbb.getBMMC(),bdwjcjffzbb.getJX(),bdwjcjffzbb.getXZ(),bdwjcjffzbb.getGQ(),
					bdwjcjffzbb.getQT(),bdwjcjffzbb.getNZJJE(),bdwjcjffzbb.getCSSL(),bdwjcjffzbb.getND(),
					config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}	
	}
}
