package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import bean.JXGZLSJK;
import config.DefalutValue;
import utils.DataBaseUtils;
import utils.excelUtils;

public class JXGZLSJKService {

	private final static String insertSQL = "insert into t_jxgzlsjk(id,rydm,xm,jrzqk,zwgzl,bky,bkqty,bke,"
            +"bkqte,bktk,yjsjxgzly,yjszdgzly,yjsjxgzle,yjszdgzle,gzlhj"
            +",isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	

	private final static String updateSQL = "update t_jxgzlsjk set rydm = ?, xm = ?, jrzqk = ?, zwgzl = ?, bky = ?,"
			+ "bkqty = ?, bke = ?, bkqte = ?, bktk = ?, yjsjxgzly = ?, yjszdgzly = ?,"
            +"yjsjxgzle = ?, yjszdgzle = ?, gzlhj = ? where id = ?";			

	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		JXGZLSJK jxgzlsjk = null;
		List<JXGZLSJK > dataList = excelUtils.analysisExcel(path, JXGZLSJK.class);
		int listSize = 0;
		if(dataList != null)
			listSize = dataList.size();
		for(int i = 0; i < listSize; i++) {
			jxgzlsjk = dataList.get(i);
			DataBaseUtils.update(insertSQL, jxgzlsjk.getID(), jxgzlsjk.getRYDM(), jxgzlsjk.getXM(),
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
		if(jxgzlsjk.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(updateSQL, jxgzlsjk.getRYDM(), jxgzlsjk.getXM(),jxgzlsjk.getJRZQK(),
					jxgzlsjk.getZWGZL(), jxgzlsjk.getBKY(), jxgzlsjk.getBKQTY(),jxgzlsjk.getBKE(),
					jxgzlsjk.getBKQTE(), jxgzlsjk.getBKTK(), jxgzlsjk.getYJSJXGZLY(),
					jxgzlsjk.getYJSZDGZLY(),jxgzlsjk.getYJSJXGZLE(), jxgzlsjk.getYJSZDGZLE(), 
					jxgzlsjk.getGZLHJ(), jxgzlsjk.getID());
		
		}else if(jxgzlsjk.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
				DataBaseUtils.update(insertSQL, jxgzlsjk.getID(), jxgzlsjk.getRYDM(), jxgzlsjk.getXM(),
					jxgzlsjk.getJRZQK(), jxgzlsjk.getZWGZL(), jxgzlsjk.getBKY(), jxgzlsjk.getBKQTY(),
					jxgzlsjk.getBKE(), jxgzlsjk.getBKQTE(), jxgzlsjk.getBKTK(), jxgzlsjk.getYJSJXGZLY(),
					jxgzlsjk.getYJSZDGZLY(),jxgzlsjk.getYJSJXGZLE(), jxgzlsjk.getYJSZDGZLE(), 
					jxgzlsjk.getGZLHJ(), 0);	
		}
		
	}
}
