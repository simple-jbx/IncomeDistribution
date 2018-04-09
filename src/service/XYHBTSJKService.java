package service;

import java.util.UUID;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XYHBTSJK;

public class XYHBTSJKService {
	
	
		/**
		 * 查询校运会补贴数据表中所有数据
		 * @return
		 */
		public List<Map<String, Object> > getData() {
			String sql = "select * from t_xyhbtsjk where isdel = ?";
			return DataBaseUtils.queryForList(sql, 0);
		}
		
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			XYHBTSJK xyhbtsjk = null;
			List<XYHBTSJK > list = excelUtils.analysisExcel(path, XYHBTSJK.class);
			String sql = "insert into t_xyhbtsjk(id,rydm,xm,xyhbz,je,isdel)"
		            + " VALUES (?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size(); i++) {
				xyhbtsjk = list.get(i);					
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),xyhbtsjk.getRYDM(),
						xyhbtsjk.getXM(), xyhbtsjk.getXYHBZ(), xyhbtsjk.getJE(),0);
				}
		}
		
		
		/**
		 * 根据id删除对应数据
		 * @param id
		 */
		public void deleteByID(String ID) {
			String sql = "update t_xyhbtsjk set isdel = ? where id = ?";
			DataBaseUtils.update(sql, 1, ID);
		}
		
		
		/**
		 * 更新校运会补贴数据
		 * @param xyhbtsjk
		 */
		public void updateData(XYHBTSJK xyhbtsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(xyhbtsjk.getISDEL() == 0) {
				String sql = "update t_xyhbtsjk set rydm = ?, xm = ?, xyhbz = ?, je = ? where id = ?";
				DataBaseUtils.update(sql,xyhbtsjk.getRYDM(),xyhbtsjk.getXM(),xyhbtsjk.getXYHBZ(),
						xyhbtsjk.getJE(), xyhbtsjk.getID());
			}else if(xyhbtsjk.getISDEL() == 2){
				String sql = "insert into t_xyhbtsjk(id,rydm,xm,xyhbz,je,isdel)"
			            + " VALUES (?,?,?,?,?,?)";
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),xyhbtsjk.getRYDM(),
						xyhbtsjk.getXM(), xyhbtsjk.getXYHBZ(), xyhbtsjk.getJE(),0);
			}	
		}
}
