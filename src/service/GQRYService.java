package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.GQRY;
public class GQRYService {
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		GQRY gqry = null;
		List<GQRY > list = excelUtils.analysisExcel(path, GQRY.class);
		String sql = "insert into t_gqry(id,rydm,xm,gw,zgsjxs,zcxs,kqxs,fpxs,nzbzjj,sfpjjl,xxpyjl,xypyjl,"
				+ "xyhbt,zjhdbt,dypcfphj,depcrjj,kqkf,bfhkc,dspfphj,hjje,isdel)"
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			gqry = list.get(i);
			DataBaseUtils.update(sql, gqry.getID(),gqry.getRYDM(),gqry.getXM(),gqry.getGW(),gqry.getZGSJXS(),
					gqry.getZCXS(), gqry.getKQXS(),gqry.getFPXS(),gqry.getNZBZJJ(),gqry.getSFPJJL(),gqry.getXXPYJL(),
					gqry.getXYPYJL(),gqry.getXYHBT(), gqry.getZJHDBT(), gqry.getDYPCFPHJ(),gqry.getDEPCRJJ(),
					gqry.getKQKF(),gqry.getBFHKC(),gqry.getDSPFPHJ(),gqry.getHJJE(),0);
		}
	}
	
	
	/**
	 * 更新工勤人员数据
	 * @param gqry
	 */
	public void updateData(GQRY gqry) {
		//System.out.println(gqry.toJson());
		if(gqry.getISDEL() == 0) {
			String sql = "update t_gqry set rydm=?,xm=?,gw=?,zgsjxs=?,zcxs=?,kqxs=?,fpxs=?,nzbzjj=?,"
					+ "sfpjjl=?,xxpyjl=?,xypyjl=?,xyhbt=?,zjhdbt=?,dypcfphj=?,depcrjj=?,kqkf=?,bfhkc=?,"
					+ "dspfphj=?,hjje=? where id=?";			
			DataBaseUtils.update(sql,gqry.getRYDM(),gqry.getXM(),gqry.getGW(),gqry.getZGSJXS(),
					gqry.getZCXS(), gqry.getKQXS(),gqry.getFPXS(),gqry.getNZBZJJ(),gqry.getSFPJJL(),gqry.getXXPYJL(),
					gqry.getXYPYJL(),gqry.getXYHBT(), gqry.getZJHDBT(), gqry.getDYPCFPHJ(),gqry.getDEPCRJJ(),
					gqry.getKQKF(),gqry.getBFHKC(),gqry.getDSPFPHJ(),gqry.getHJJE(),gqry.getID());
		}else if(gqry.getISDEL() == 2){
			String sql = "insert into t_gqry(id,rydm,xm,gw,zgsjxs,zcxs,kqxs,fpxs,nzbzjj,sfpjjl,xxpyjl,xypyjl,"
					+ "xyhbt,zjhdbt,dypcfphj,depcrjj,kqkf,bfhkc,dspfphj,hjje,isdel)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, gqry.getID(),gqry.getRYDM(),gqry.getXM(),gqry.getGW(),gqry.getZGSJXS(),
					gqry.getZCXS(), gqry.getKQXS(),gqry.getFPXS(),gqry.getNZBZJJ(),gqry.getSFPJJL(),
					gqry.getXXPYJL(),gqry.getXYPYJL(),gqry.getXYHBT(), gqry.getZJHDBT(), gqry.getDYPCFPHJ(),
					gqry.getDEPCRJJ(),gqry.getKQKF(),gqry.getBFHKC(),gqry.getDSPFPHJ(),gqry.getHJJE(),0);
		}
		
	}
}
