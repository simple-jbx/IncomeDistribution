package service;

import java.util.UUID;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZBGZSJK;

public class ZBGZSJKService {
	
	
		/**
		 * 查询值班工作数据库中所有数据
		 * @return
		 */
		public List<Map<String, Object> > getData() {
			String sql = "select * from t_zbgzsjk where isdel = ?";
			return DataBaseUtils.queryForList(sql, 0);
		}
		
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			ZBGZSJK zbgzsjk = null;
			List<ZBGZSJK > list = excelUtils.analysisExcel(path, ZBGZSJK.class);
			String sql = "insert into t_zbgzsjk(id,rydm,xm,zbcs,ffje,isdel)"
		            + " VALUES (?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size(); i++) {
				zbgzsjk = list.get(i);					
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),zbgzsjk.getRYDM(),
						zbgzsjk.getXM(), zbgzsjk.getZBCS(), zbgzsjk.getFFJE(),0);
				}
		}
		
		
		/**
		 * 根据id删除对应数据
		 * @param id
		 */
		public void deleteByID(String ID) {
			String sql = "update t_zbgzsjk set isdel = ? where id  = ?";
			DataBaseUtils.update(sql, 1, ID);
		}
		
		
		/**
		 * 更新值班工作数据库数据
		 * @param zbgzsjk
		 */
		public void updateData(ZBGZSJK zbgzsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(zbgzsjk.getISDEL() == 0) {
				String sql = "update t_zbgzsjk set rydm = ?, xm = ?, zbcs = ?, ffje = ? where id = ?";
				DataBaseUtils.update(sql,zbgzsjk.getRYDM(),zbgzsjk.getXM(),zbgzsjk.getZBCS(),
						zbgzsjk.getFFJE(), zbgzsjk.getID());
			}else if(zbgzsjk.getISDEL() == 2){
				String sql = "insert into t_zbgzsjk(id,rydm,xm,zbcs,ffje,isdel)"
			            + " VALUES (?,?,?,?,?,?)";
				DataBaseUtils.update(sql,zbgzsjk.getID(),zbgzsjk.getRYDM(),zbgzsjk.getXM(),
						zbgzsjk.getZBCS(),zbgzsjk.getFFJE(), 0);
			}	
		}
}
