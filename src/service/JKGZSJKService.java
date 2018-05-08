package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.JKGZSJK;

/**
 * 监考工作
 * @author simple
 *
 */

public class JKGZSJKService {
	
		private final static String insertSQL = "insert into t_jkgzsjk(id,rydm,xm,jkcs,je,isdel)"
	            + " VALUES (?,?,?,?,?,?)";
				
		private final static String updateSQL =	"update t_jkgzsjk set rydm = ?, xm = ?, jkcs = ?, je = ? where id = ?";

	
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			JKGZSJK jkgzsjk = null;
			List<JKGZSJK > dataList = excelUtils.analysisExcel(path, JKGZSJK.class);
			int listSize = 0;
			if(dataList != null)
				listSize = dataList.size();
			
			for(int i = 0; i < listSize; i++) {
				jkgzsjk = dataList.get(i);					
				DataBaseUtils.update(insertSQL,jkgzsjk.getID(),jkgzsjk.getRYDM(),
						jkgzsjk.getXM(), jkgzsjk.getJKCS(), jkgzsjk.getJE(),0);
				}
		}
		
		
		/**
		 * 更新监考工作数据库数据
		 * @param jxddbtjcsj
		 */
		public void updateData(JKGZSJK jkgzsjk) {
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(jkgzsjk.getISDEL() == 0) {
				DataBaseUtils.update(insertSQL,jkgzsjk.getRYDM(),jkgzsjk.getXM(),jkgzsjk.getJKCS(),
						jkgzsjk.getJE(), jkgzsjk.getID());
			}else if(jkgzsjk.getISDEL() == 2){
				DataBaseUtils.update(updateSQL,jkgzsjk.getID(),jkgzsjk.getRYDM(),jkgzsjk.getXM(),
						jkgzsjk.getJKCS(),jkgzsjk.getJE(), 0);
			}	
		}
}
