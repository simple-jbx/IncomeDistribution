package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.CGFZRBTSJK;

/**
 * 场馆负责人补贴
 * @author simple
 *
 */

public class CGFZRBTSJKService {

		final static String insertSQL = "insert into t_cgfzrbtsjk(id,rydm,xm,cgfzrbt,isdel)"
	            + " VALUES (?,?,?,?,?)";
		final static String updateSQL = "update t_cgfzrbtsjk set rydm = ?, xm = ?, cgfzrbt = ? where id = ?";
		
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			CGFZRBTSJK cgfzrbtsjk = null;
			List<CGFZRBTSJK > dataList = excelUtils.analysisExcel(path, CGFZRBTSJK.class);
			int listSize = 0;
			if(dataList != null)
				listSize = dataList.size();
			for(int i = 0; i < listSize; i++) {
				cgfzrbtsjk = dataList.get(i);					
				DataBaseUtils.update(insertSQL,cgfzrbtsjk.getID(),cgfzrbtsjk.getRYDM(),
						cgfzrbtsjk.getXM(),cgfzrbtsjk.getCGFZRBT(),0);
			}
		}

		
		/**
		 * 更新场馆负责人数据
		 * @param cgfzrbtsjk
		 */	
		public void updateData(CGFZRBTSJK cgfzrbtsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(cgfzrbtsjk.getISDEL() == 0) {
				DataBaseUtils.update(updateSQL,cgfzrbtsjk.getRYDM(),cgfzrbtsjk.getXM(),cgfzrbtsjk.getCGFZRBT(),
						cgfzrbtsjk.getID());
			}else if(cgfzrbtsjk.getISDEL() == 2){
				DataBaseUtils.update(insertSQL,cgfzrbtsjk.getID(),cgfzrbtsjk.getRYDM(),
						cgfzrbtsjk.getXM(),cgfzrbtsjk.getCGFZRBT(),0);
			}	
		}
}
