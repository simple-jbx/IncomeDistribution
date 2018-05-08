package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.JXDDBTSJK;

/**
 * 教学督导补贴
 * @author simple
 *
 */

public class JXDDBTSJKService {
	
		private final static String insertSQL = "insert into t_jxddbtjcsjk(id,rydm,xm,jxdd,hj,isdel)"
	            + " VALUES (?,?,?,?,?,?)";
				
		private final static String updateSQL = "update t_jxddbtjcsjk set rydm = ?, xm = ?, jxdd = ?, hj = ? where id = ?";

	
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			JXDDBTSJK jxddbtsjk = null;
			List<JXDDBTSJK > dataList = excelUtils.analysisExcel(path, JXDDBTSJK.class);
			int listSize = 0;
			if(dataList != null)
				listSize = dataList.size();
			for(int i = 0; i < listSize; i++) {
				jxddbtsjk = dataList.get(i);					
				DataBaseUtils.update(insertSQL,jxddbtsjk.getID(),jxddbtsjk.getRYDM(),
						jxddbtsjk.getXM(), jxddbtsjk.getJXDD(), jxddbtsjk.getHJ(),0);
				}
		}
		
	
		/**
		 * 更新教学督导补贴基础数据库数据
		 * @param jxddbtjcsj
		 */
		public void updateData(JXDDBTSJK jxddbtsjk) {
			if(jxddbtsjk.getISDEL() == 0) {
				DataBaseUtils.update(updateSQL,jxddbtsjk.getRYDM(),jxddbtsjk.getXM(),jxddbtsjk.getJXDD(),
						jxddbtsjk.getHJ(), jxddbtsjk.getID());
			}else if(jxddbtsjk.getISDEL() == 2){
				DataBaseUtils.update(insertSQL,jxddbtsjk.getID(),jxddbtsjk.getRYDM(),jxddbtsjk.getXM(),jxddbtsjk.getJXDD(),
						jxddbtsjk.getHJ(), 0);
			}	
		}
}
