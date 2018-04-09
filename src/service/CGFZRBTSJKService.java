package service;

import java.util.UUID;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.CGFZRBTSJK;

public class CGFZRBTSJKService {
	
	
		/**
		 * 查询场馆负责人补贴数据表中所有数据
		 * @return
		 */
		public List<Map<String, Object> > getData() {
			String sql = "select * from t_cgfzrbtsjk where isdel = ?";
			return DataBaseUtils.queryForList(sql, 0);
		}
		
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			CGFZRBTSJK cgfzrbtsjk = null;
			List<CGFZRBTSJK > list = excelUtils.analysisExcel(path, CGFZRBTSJK.class);
			String sql = "insert into t_cgfzrbtsjk(id,rydm,xm,cgfzrbt,hj,isdel)"
		            + " VALUES (?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size(); i++) {
				cgfzrbtsjk = list.get(i);					
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),cgfzrbtsjk.getRYDM(),
						cgfzrbtsjk.getXM(), cgfzrbtsjk.getCGFZRBT(), cgfzrbtsjk.getHJ(),0);
				}
		}
		
		
		/**
		 * 根据id删除对应数据
		 * @param id
		 */
		public void deleteByID(String ID) {
			String sql = "update t_cgfzrbtsjk set isdel = ? where id = ?";
			DataBaseUtils.update(sql, 1, ID);
		}
		
		
		/**
		 * 更新话费补贴数据
		 * @param cgfzrbtsjk
		 */	
		public void updateData(CGFZRBTSJK cgfzrbtsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(cgfzrbtsjk.getISDEL() == 0) {
				String sql = "update t_cgfzrbtsjk set rydm = ?, xm = ?, cgfzrbt = ?, hj = ? where id = ?";
				DataBaseUtils.update(sql,cgfzrbtsjk.getRYDM(),cgfzrbtsjk.getXM(),cgfzrbtsjk.getCGFZRBT(),
						cgfzrbtsjk.getHJ(), cgfzrbtsjk.getID());
			}else if(cgfzrbtsjk.getISDEL() == 2){
				String sql = "insert into t_cgfzrbtsjk(id,rydm,xm,cgfzrbt,hj,isdel)"
			            + " VALUES (?,?,?,?,?,?)";
				DataBaseUtils.update(sql,cgfzrbtsjk.getID(),cgfzrbtsjk.getRYDM(),
						cgfzrbtsjk.getXM(), cgfzrbtsjk.getCGFZRBT(), cgfzrbtsjk.getHJ(),0);
			}	
		}
}
