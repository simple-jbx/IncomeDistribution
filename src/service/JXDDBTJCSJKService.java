package service;

import java.util.UUID;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.JXDDBTJCSJK;


public class JXDDBTJCSJKService {
	
	
		/**
		 * 查询教学督导补贴基础数据库中所有数据
		 * @return
		 */
		public List<Map<String, Object> > getData() {
			String sql = "select * from t_jxddbtjcsjk where isdel = ?";
			return DataBaseUtils.queryForList(sql, 0);
		}
		
		/**
		 * 根据RYDM查询单条数据
		 * @param RYDM
		 * @return ZGSJXS
		 */
		public JXDDBTJCSJK getData(String RYDM) {
			String sql = "select * from t_jxddbtjcsjk where rydm = ? and isdel = ?";
			return DataBaseUtils.queryForBean(sql, JXDDBTJCSJK.class, RYDM, 0);
		}
		
		
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			JXDDBTJCSJK jxddbtjcsjk = null;
			List<JXDDBTJCSJK > list = excelUtils.analysisExcel(path, JXDDBTJCSJK.class);
			String sql = "insert into t_jxddbtjcsjk(id,rydm,xm,jxdd,hj,isdel)"
		            + " VALUES (?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size()/2; i++) {
				jxddbtjcsjk = list.get(i);					
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),jxddbtjcsjk.getRYDM(),
						jxddbtjcsjk.getXM(), jxddbtjcsjk.getJXDD(), jxddbtjcsjk.getHJ(),0);
				}
			
			for(int i = list.size()/2; i < list.size(); i++) {
				jxddbtjcsjk = list.get(i);					
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),jxddbtjcsjk.getRYDM(),
						jxddbtjcsjk.getXM(), jxddbtjcsjk.getJXDD(), jxddbtjcsjk.getHJ(),0);
				}
		}
		
		
		/**
		 * 根据id删除对应数据
		 * @param id
		 */
		public void deleteByID(String ID) {
			String sql = "update t_jxddbtjcsjk set isdel = ? where id  = ?";
			DataBaseUtils.update(sql, 1, ID);
		}
		
		
		/**
		 * 更新教学督导补贴基础数据库数据
		 * @param jxddbtjcsj
		 */
		public void updateData(JXDDBTJCSJK jxddbtjcsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(jxddbtjcsjk.getISDEL() == 0) {
				String sql = "update t_jxddbtjcsjk set rydm = ?, xm = ?, jxdd = ?, hj = ? where id = ?";
				DataBaseUtils.update(sql,jxddbtjcsjk.getRYDM(),jxddbtjcsjk.getXM(),jxddbtjcsjk.getJXDD(),
						jxddbtjcsjk.getHJ(), jxddbtjcsjk.getID());
			}else if(jxddbtjcsjk.getISDEL() == 2){
				String sql = "insert into t_jxddbtjcsjk(id,rydm,xm,jxdd,hj,isdel)"
			            + " VALUES (?,?,?,?,?,?)";
				DataBaseUtils.update(sql,jxddbtjcsjk.getID(),jxddbtjcsjk.getRYDM(),jxddbtjcsjk.getXM(),jxddbtjcsjk.getJXDD(),
						jxddbtjcsjk.getHJ(), 0);
			}	
		}
}
