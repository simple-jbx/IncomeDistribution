package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import bean.JXGZLSJK;
import utils.DataBaseUtils;
import utils.excelUtils;

public class JXGZLSJKService {

	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		JXGZLSJK jxgzlsjk = null;
		List<JXGZLSJK > list = excelUtils.analysisExcel(path, JXGZLSJK.class);
		String sql = "insert into t_jxgzlsjk(id,rydm,xm,jrzqk,zwgzl,bky,bkqty,bke,"
			            +"bkqte,bktk,yjsjxgzly,yjszdgzly,yjsjxgzle,yjszdgzle,gzlhj"
			            +",isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			jxgzlsjk = list.get(i);
			DataBaseUtils.update(sql, jxgzlsjk.getID(), jxgzlsjk.getRYDM(), jxgzlsjk.getXM(),
					jxgzlsjk.getJRZQK(), jxgzlsjk.getZWGZL(), jxgzlsjk.getBKY(), jxgzlsjk.getBKQTY(),
					jxgzlsjk.getBKE(), jxgzlsjk.getBKQTE(), jxgzlsjk.getBKTK(), jxgzlsjk.getYJSJXGZLY(),
					jxgzlsjk.getYJSZDGZLY(),jxgzlsjk.getYJSJXGZLE(), jxgzlsjk.getYJSZDGZLE(), 
					jxgzlsjk.getGZLHJ(), 0);
		}
	}
	
	
	/**
	 * 更新教学工作量表中数据
	 * @param jxgzlsjk
	 */
	public void updateData(JXGZLSJK jxgzlsjk) {
		if(jxgzlsjk.getISDEL() == 0) {
			String sql = "update t_jxgzlsjk set rydm = ?, xm = ?, jrzqk = ?, zwgzl = ?, bky = ?,"
					+ "bkqty = ?, bke = ?, bkqte = ?, bktk = ?, yjsjxgzly = ?, yjszdgzly = ?,"
		            +"yjsjxgzle = ?, yjszdgzle = ?, gzlhj = ? where id = ?";			
			DataBaseUtils.update(sql, jxgzlsjk.getRYDM(), jxgzlsjk.getXM(),jxgzlsjk.getJRZQK(),
					jxgzlsjk.getZWGZL(), jxgzlsjk.getBKY(), jxgzlsjk.getBKQTY(),jxgzlsjk.getBKE(),
					jxgzlsjk.getBKQTE(), jxgzlsjk.getBKTK(), jxgzlsjk.getYJSJXGZLY(),
					jxgzlsjk.getYJSZDGZLY(),jxgzlsjk.getYJSJXGZLE(), jxgzlsjk.getYJSZDGZLE(), 
					jxgzlsjk.getGZLHJ(), jxgzlsjk.getID());
		
		}else if(jxgzlsjk.getISDEL() == 2){
			String sql = "insert into t_jxgzlsjk(id,rydm,xm,jrzqk,zwgzl,bky,bkqty,bke,"
		            +"bkqte,bktk,yjsjxgzly,yjszdgzly,yjsjxgzle,yjszdgzle,gzlhj"
		            +",isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, jxgzlsjk.getID(), jxgzlsjk.getRYDM(), jxgzlsjk.getXM(),
					jxgzlsjk.getJRZQK(), jxgzlsjk.getZWGZL(), jxgzlsjk.getBKY(), jxgzlsjk.getBKQTY(),
					jxgzlsjk.getBKE(), jxgzlsjk.getBKQTE(), jxgzlsjk.getBKTK(), jxgzlsjk.getYJSJXGZLY(),
					jxgzlsjk.getYJSZDGZLY(),jxgzlsjk.getYJSJXGZLE(), jxgzlsjk.getYJSZDGZLE(), 
					jxgzlsjk.getGZLHJ(), 0);	
		}
		
	}
}
