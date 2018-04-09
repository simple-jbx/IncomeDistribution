package service;

import java.util.UUID;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.JKGZSJK;

public class JKGZSJKService {
	
	
		/**
		 * 查询监考工作数据表中所有数据
		 * @return
		 */
		public List<Map<String, Object> > getData() {
			String sql = "select * from t_jkgzsjk where isdel = ?";
			return DataBaseUtils.queryForList(sql, 0);
		}
		
		
		/**
		 * 查询个人监考工作数据
		 * @param Gh
		 * @return
		 */
		public JKGZSJK getData(String Gh) {
			String sql = "select * from t_jkgzsjk where rydm = ? and isdel = ?";
			return DataBaseUtils.queryForBean(sql, JKGZSJK.class, Gh, 0);
		}
		
		
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			JKGZSJK jkgzsjk = null;
			List<JKGZSJK > list = excelUtils.analysisExcel(path, JKGZSJK.class);
			String sql = "insert into t_jkgzsjk(id,rydm,xm,jkcs,je,isdel)"
		            + " VALUES (?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size(); i++) {
				jkgzsjk = list.get(i);					
				DataBaseUtils.update(sql,UUID.randomUUID().toString(),jkgzsjk.getRYDM(),
						jkgzsjk.getXM(), jkgzsjk.getJKCS(), jkgzsjk.getJE(),0);
				}
		}
		
		
		/**
		 * 根据id删除对应数据
		 * @param id
		 */
		public void deleteByID(String ID) {
			String sql = "update t_jkgzsjk set isdel = ? where id  = ?";
			DataBaseUtils.update(sql, 1, ID);
		}
		
		
		/**
		 * 更新监考工作数据库数据
		 * @param jxddbtjcsj
		 */
		public void updateData(JKGZSJK jkgzsjk) {
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(jkgzsjk.getISDEL() == 0) {
				String sql = "update t_jkgzsjk set rydm = ?, xm = ?, jkcs = ?, je = ? where id = ?";
				DataBaseUtils.update(sql,jkgzsjk.getRYDM(),jkgzsjk.getXM(),jkgzsjk.getJKCS(),
						jkgzsjk.getJE(), jkgzsjk.getID());
			}else if(jkgzsjk.getISDEL() == 2){
				String sql = "insert into t_jkgzsjk(id,rydm,xm,jkcs,je,isdel)"
			            + " VALUES (?,?,?,?,?,?)";
				DataBaseUtils.update(sql,jkgzsjk.getID(),jkgzsjk.getRYDM(),jkgzsjk.getXM(),
						jkgzsjk.getJKCS(),jkgzsjk.getJE(), 0);
			}	
		}
}
