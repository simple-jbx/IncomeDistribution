package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.JTHDKQSJK;


public class JTHDKQSJKService {
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		JTHDKQSJK jthdkqsjk = null;
		List<JTHDKQSJK > list = excelUtils.analysisExcel(path, JTHDKQSJK.class);
		String sql = "insert into t_jthdkqsjk(id,rydm,xm,wgwd,grsj,jey,jee,isdel)"
	            + " VALUES (?,?,?,?,?,?,?,?)";
		
		for(int i = 0; i < list.size()/2; i++) {
			jthdkqsjk = list.get(i);					
			DataBaseUtils.update(sql,jthdkqsjk.getID(),jthdkqsjk.getRYDM(),
					jthdkqsjk.getXM(), jthdkqsjk.getWGWD(), jthdkqsjk.getGRSJ(),
					jthdkqsjk.getJEY(), jthdkqsjk.getJEE(), jthdkqsjk.getHJJE(),0);
		}
		
		for(int i = list.size()/2; i < list.size(); i++) {
			jthdkqsjk = list.get(i);					
			DataBaseUtils.update(sql,jthdkqsjk.getID(),jthdkqsjk.getRYDM(),
					jthdkqsjk.getXM(), jthdkqsjk.getWGWD(), jthdkqsjk.getGRSJ(),
					jthdkqsjk.getJEY(), jthdkqsjk.getJEE(), jthdkqsjk.getHJJE(),0);
		}
	}
	
	
	/**
	 * 更新
	 * @param jxddbtjcsj
	 */
	public void updateData(JTHDKQSJK jthdkqsjk) {
		//System.out.println(jsxljshfwsj.getID());
		//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
		if(jthdkqsjk.getISDEL() == 0) {
			String sql = "update t_jthdkqsjk set rydm = ?, xm = ?, wgwd = ?, grsj = ?, jey = ?,"
					+ "jee = ?, hjje = ? where id = ?";
			DataBaseUtils.update(sql,jthdkqsjk.getRYDM(),jthdkqsjk.getXM(), jthdkqsjk.getWGWD(), 
					jthdkqsjk.getGRSJ(),jthdkqsjk.getJEY(), jthdkqsjk.getJEE(), jthdkqsjk.getHJJE(),
					jthdkqsjk.getID());
		}else if(jthdkqsjk.getISDEL() == 2){
			String sql = "insert into t_jthdkqsjk(id,rydm,xm,wgwd,grsj,jey,jee,hjje,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?)";
			DataBaseUtils.update(sql,jthdkqsjk.getID(),jthdkqsjk.getRYDM(),
					jthdkqsjk.getXM(), jthdkqsjk.getWGWD(), jthdkqsjk.getGRSJ(),
					jthdkqsjk.getJEY(), jthdkqsjk.getJEE(), jthdkqsjk.getHJJE(),0);
		}	
	}
}
