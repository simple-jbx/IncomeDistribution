package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZBGZSJK;

public class ZBGZSJKService {
	
		private final static String insertSQL = "insert into t_zbgzsjk(id,rydm,xm,zbcs,ffje,isdel)"
	            + " VALUES (?,?,?,?,?,?)";
		private final static String updateSQL =  "update t_zbgzsjk set rydm = ?, xm = ?, zbcs = ?, ffje = ?"
				+ " where id = ?";

		
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			ZBGZSJK zbgzsjk = null;
			List<ZBGZSJK > dataList = excelUtils.analysisExcel(path, ZBGZSJK.class);
			int listSize = 0;
			if(dataList != null)
				 listSize = dataList.size();
			for(int i = 0; i < listSize; i++) {
				zbgzsjk = dataList.get(i);					
				DataBaseUtils.update(insertSQL,zbgzsjk.getID(),zbgzsjk.getRYDM(),
						zbgzsjk.getXM(), zbgzsjk.getZBCS(), zbgzsjk.getFFJE(),0);
				}
		}
		
		
		/**
		 * 更新值班工作数据库数据
		 * @param zbgzsjk
		 */
		public void updateData(ZBGZSJK zbgzsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(zbgzsjk.getISDEL() == 0) {
				DataBaseUtils.update(insertSQL,zbgzsjk.getRYDM(),zbgzsjk.getXM(),zbgzsjk.getZBCS(),
						zbgzsjk.getFFJE(), zbgzsjk.getID());
			}else if(zbgzsjk.getISDEL() == 2){
				DataBaseUtils.update(updateSQL,zbgzsjk.getID(),zbgzsjk.getRYDM(),zbgzsjk.getXM(),
						zbgzsjk.getZBCS(),zbgzsjk.getFFJE(), 0);
			}	
		}
}
