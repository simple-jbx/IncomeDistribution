package service;

import java.util.UUID;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.JSXLJSHFWSJ;;

public class JSXLJSHFWSJService {
	
	
		/**
		 * 查询竞赛训练及社会服务数据中所有数据
		 * @return
		 */
		public List<Map<String, Object> > getData() {
			String sql = "select * from t_jsxljshfwsj where isdel = ?";
			return DataBaseUtils.queryForList(sql, 0);
		}
		
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			JSXLJSHFWSJ jsxljshfwsj = null;
			List<JSXLJSHFWSJ > list = excelUtils.analysisExcel(path, JSXLJSHFWSJ.class);
			String sql = "insert into t_jsxljshfwsj(id,gh,xm,jsjf,shfwjf,zf,jlje,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size()/2; i++) {
				jsxljshfwsj = list.get(i);					
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),jsxljshfwsj.getGH(),jsxljshfwsj.getXM(),
						jsxljshfwsj.getJSJF(), jsxljshfwsj.getSHFWJF(), jsxljshfwsj.getZF(),
						jsxljshfwsj.getJLJE(), 0);
				}
			
			for(int i = list.size()/2; i < list.size(); i++) {
				jsxljshfwsj = list.get(i);					
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),jsxljshfwsj.getGH(),jsxljshfwsj.getXM(),
						jsxljshfwsj.getJSJF(), jsxljshfwsj.getSHFWJF(), jsxljshfwsj.getZF(),
						jsxljshfwsj.getJLJE(), 0);
				}
		}
		
		
		/**
		 * 根据id删除对应数据
		 * @param id
		 */
		public void deleteByID(String ID) {
			String sql = "update t_jsxljshfwsj set isdel = ? where id  = ?";
			DataBaseUtils.update(sql, 1, ID);
		}
		
		
		/**
		 * 更新竞赛训练及社会服务数据
		 * @param jsxljshfwsj
		 */
		public void updateData(JSXLJSHFWSJ jsxljshfwsj) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(jsxljshfwsj.getISDEL() == 0) {
				String sql = "update t_jsxljshfwsj set xm = ?, gh = ?, xm = ?, jsjf = ?, shfwjf = ?, zf = ?,"
			            + "jlje = ? where id = ?";
				DataBaseUtils.update(sql,jsxljshfwsj.getXM(),jsxljshfwsj.getGH(),jsxljshfwsj.getXM(),
						jsxljshfwsj.getJSJF(), jsxljshfwsj.getSHFWJF(), jsxljshfwsj.getZF(),
						jsxljshfwsj.getJLJE(), jsxljshfwsj.getID());
			}else if(jsxljshfwsj.getISDEL() == 2){
				String sql = "insert into t_jsxljshfwsj(id,gh,xm,jsjf,shfwjf,zf,jlje,isdel)"
			            + " VALUES (?,?,?,?,?,?,?,?)";	
				DataBaseUtils.update(sql,jsxljshfwsj.getID(),jsxljshfwsj.getGH(),jsxljshfwsj.getXM(),
						jsxljshfwsj.getJSJF(), jsxljshfwsj.getSHFWJF(), jsxljshfwsj.getZF(),
						jsxljshfwsj.getJLJE(), 0);
			}	
		}
}
