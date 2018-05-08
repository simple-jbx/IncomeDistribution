package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XYHBTSJK;

/**
 * 校运会补贴
 * @author simple
 *
 */

public class XYHBTSJKService {
	
		private final static String insertSQL = "insert into t_xyhbtsjk(id,rydm,xm,xyhbz,je,isdel)"
	            + " VALUES (?,?,?,?,?,?)";
		
		private final static String updateSQL =	"update t_xyhbtsjk set rydm = ?, xm = ?, xyhbz = ?, je = ?"
				+ " where id = ?";

		
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			XYHBTSJK xyhbtsjk = null;
			List<XYHBTSJK > dataList = excelUtils.analysisExcel(path, XYHBTSJK.class);
			int listSize = 0;
			if(dataList != null)
				listSize = dataList.size();
			for(int i = 0; i < listSize; i++) {
				xyhbtsjk = dataList.get(i);					
				DataBaseUtils.update(insertSQL,xyhbtsjk.getID(),xyhbtsjk.getRYDM(),xyhbtsjk.getXM(),
						xyhbtsjk.getXYHBZ(), xyhbtsjk.getJE(),0);
				}
		}
		
		
		
		/**
		 * 更新校运会补贴数据
		 * @param xyhbtsjk
		 */
		public void updateData(XYHBTSJK xyhbtsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(xyhbtsjk.getISDEL() == 0) {
				DataBaseUtils.update(updateSQL,xyhbtsjk.getRYDM(),xyhbtsjk.getXM(),xyhbtsjk.getXYHBZ(),
						xyhbtsjk.getJE(), xyhbtsjk.getID());
			}else if(xyhbtsjk.getISDEL() == 2){
				DataBaseUtils.update(insertSQL,xyhbtsjk.getID(),xyhbtsjk.getRYDM(),xyhbtsjk.getXM(),
						xyhbtsjk.getXYHBZ(), xyhbtsjk.getJE(),0);
			}	
		}
}
