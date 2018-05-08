package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZJHDBTSJK;

public class ZJHDBTSJKService {
	
	final static String insertSQL = "insert into t_zjhdbtsjk(id,rydm,xm,zjhd,hj,isdel)"
		            + " VALUES (?,?,?,?,?,?)";
	final static String updateSQL = "update t_zjhdbtsjk set rydm = ?, xm = ?, zjhd = ?, hj = ? where id = ?";
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			ZJHDBTSJK zjhdbtsjk = null;
			List<ZJHDBTSJK > dataList = excelUtils.analysisExcel(path, ZJHDBTSJK.class);
			int listSize = 0;
			if(dataList != null)
				listSize = dataList.size();
			for(int i = 0; i < listSize; i++) {
				zjhdbtsjk = dataList.get(i);					
				DataBaseUtils.update(insertSQL,zjhdbtsjk.getID(),zjhdbtsjk.getRYDM(),
						zjhdbtsjk.getXM(), zjhdbtsjk.getZJHDBT(), zjhdbtsjk.getHJ(),0);
				}
		}
		
		
		public void updateData(ZJHDBTSJK zjhdbtsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(zjhdbtsjk.getISDEL() == 0) {
				DataBaseUtils.update(updateSQL,zjhdbtsjk.getRYDM(),zjhdbtsjk.getXM(),zjhdbtsjk.getZJHDBT(),
						zjhdbtsjk.getHJ(), zjhdbtsjk.getID());
			}else if(zjhdbtsjk.getISDEL() == 2){
				DataBaseUtils.update(insertSQL,zjhdbtsjk.getID(),zjhdbtsjk.getRYDM(),
						zjhdbtsjk.getXM(), zjhdbtsjk.getZJHDBT(), zjhdbtsjk.getHJ(),0);
			}	
		}
}
