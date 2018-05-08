package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.JSXLJSHFWSJ;;

/**
 * 竞赛训练及社会服务
 * @author simple
 *
 */

public class JSXLJSHFWSJService {
	
		private final static String insertSQL = "insert into t_jsxljshfwsj(id,rydm,xm,jsjf,shfwjf,zf,jlje,isdel)"
	            + " VALUES (?,?,?,?,?,?,?,?)";
		
		private final static String updateSQL = "update t_jsxljshfwsj set xm = ?, rydm = ?, xm = ?, jsjf = ?, shfwjf = ?, zf = ?,"
	            + "jlje = ? where id = ?";
		
		
		/**
		* 根据上传文件将数据存入数据库
		* @param path
		* @throws IOException
		* @throws SQLException
		*/
		public void save2DB(String path) throws IOException, SQLException {
			JSXLJSHFWSJ jsxljshfwsj = null;
			List<JSXLJSHFWSJ > list = excelUtils.analysisExcel(path, JSXLJSHFWSJ.class);
			
			for(int i = 0; i < list.size(); i++) {
				jsxljshfwsj = list.get(i);					
				DataBaseUtils.update(insertSQL,jsxljshfwsj.getID(),jsxljshfwsj.getRYDM(),jsxljshfwsj.getXM(),
						jsxljshfwsj.getJSJF(), jsxljshfwsj.getSHFWJF(), jsxljshfwsj.getZF(),
						jsxljshfwsj.getJLJE(), 0);
				}
			}
		
		
		
		/**
		 * 更新竞赛训练及社会服务数据(单条更新)
		 * @param jsxljshfwsj
		 */
		public void updateData(JSXLJSHFWSJ jsxljshfwsj) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(jsxljshfwsj.getISDEL() == 0) {
					DataBaseUtils.update(updateSQL,jsxljshfwsj.getXM(),jsxljshfwsj.getRYDM(),jsxljshfwsj.getXM(),
						jsxljshfwsj.getJSJF(), jsxljshfwsj.getSHFWJF(), jsxljshfwsj.getZF(),
						jsxljshfwsj.getJLJE(), jsxljshfwsj.getID());
			}else if(jsxljshfwsj.getISDEL() == 2){
				DataBaseUtils.update(insertSQL,jsxljshfwsj.getID(),jsxljshfwsj.getRYDM(),jsxljshfwsj.getXM(),
						jsxljshfwsj.getJSJF(), jsxljshfwsj.getSHFWJF(), jsxljshfwsj.getZF(),
						jsxljshfwsj.getJLJE(), 0);
			}	
		}
		
		
		/**
		 * @description 批量更新
		 * @param
		 * @author simple
		 */
		//TODO...
		public void updateList() {
			
		}
		
}
