package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.HFBTSJK;

public class HFBTSJKService {
	
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			HFBTSJK hfbtsjk = null;
			List<HFBTSJK > list = excelUtils.analysisExcel(path, HFBTSJK.class);
			String sql = "insert into t_hfbtsjk(id,rydm,xm,hfbt,hj,isdel)"
		            + " VALUES (?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size(); i++) {
				hfbtsjk = list.get(i);					
				DataBaseUtils.update(sql,hfbtsjk.getID(),hfbtsjk.getRYDM(),hfbtsjk.getXM(),
						hfbtsjk.getHFBT(), hfbtsjk.getHJ(),0);
				}
		}
		
		
		/**
		 * 更新话费补贴数据
		 * @param hfbtsjk
		 */	
		public void updateData(HFBTSJK hfbtsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(hfbtsjk.getISDEL() == 0) {
				String sql = "update t_hfbtsjk set rydm = ?, xm = ?, hfbt = ?, hj = ? where id = ?";
				DataBaseUtils.update(sql,hfbtsjk.getRYDM(),hfbtsjk.getXM(),hfbtsjk.getHFBT(),
						hfbtsjk.getHJ(), hfbtsjk.getID());
			}else if(hfbtsjk.getISDEL() == 2){
				String sql = "insert into t_hfbtsjk(id,rydm,xm,hfbt,hj,isdel)"
			            + " VALUES (?,?,?,?,?,?)";
				DataBaseUtils.update(sql,hfbtsjk.getID(),hfbtsjk.getRYDM(),
						hfbtsjk.getXM(), hfbtsjk.getHFBT(), hfbtsjk.getHJ(),0);
			}	
		}
}
