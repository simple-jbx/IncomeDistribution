package service;

import java.util.UUID;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZJHDBTSJK;

public class ZJHDBTSJKService {
	
	
		/**
		 * 查询照金活动数据表中所有数据
		 * @return
		 */
		public List<Map<String, Object> > getData() {
			String sql = "select * from t_zjhdbtsjk where isdel = ?";
			return DataBaseUtils.queryForList(sql, 0);
		}
		
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			ZJHDBTSJK zjhdbtsjk = null;
			List<ZJHDBTSJK > list = excelUtils.analysisExcel(path, ZJHDBTSJK.class);
			String sql = "insert into t_zjhdbtsjk(id,rydm,xm,zjhd,hj,isdel)"
		            + " VALUES (?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size(); i++) {
				zjhdbtsjk = list.get(i);					
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),zjhdbtsjk.getRYDM(),
						zjhdbtsjk.getXM(), zjhdbtsjk.getZJHD(), zjhdbtsjk.getHJ(),0);
				}
		}
		
		
		/**
		 * 根据id删除对应数据
		 * @param id
		 */
		public void deleteByID(String ID) {
			String sql = "update t_zjhdbtsjk set isdel = ? where id = ?";
			DataBaseUtils.update(sql, 1, ID);
		}
		
		
		/**
		 * 更新校运会补贴数据
		 * @param zjhdbtsjk
		 */	
		public void updateData(ZJHDBTSJK zjhdbtsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(zjhdbtsjk.getISDEL() == 0) {
				String sql = "update t_zjhdbtsjk set rydm = ?, xm = ?, zjhd = ?, hj = ? where id = ?";
				DataBaseUtils.update(sql,zjhdbtsjk.getRYDM(),zjhdbtsjk.getXM(),zjhdbtsjk.getZJHD(),
						zjhdbtsjk.getHJ(), zjhdbtsjk.getID());
			}else if(zjhdbtsjk.getISDEL() == 2){
				String sql = "insert into t_zjhdbtsjk(id,rydm,xm,zjhd,hj,isdel)"
			            + " VALUES (?,?,?,?,?,?)";
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),zjhdbtsjk.getRYDM(),
						zjhdbtsjk.getXM(), zjhdbtsjk.getZJHD(), zjhdbtsjk.getHJ(),0);
			}	
		}
}
