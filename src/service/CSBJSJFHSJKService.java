package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.CSBJSJFHSJK;

/**
 * 创收补缴税金返还
 * @author simple
 *
 */

public class CSBJSJFHSJKService {
		
	final static String insertSQL = "insert into t_csbjsjfhsjk(id,rydm,xm,ffje,sfjj,ksbl,ksje,sfje,isdel)"
            + " VALUES (?,?,?,?,?,?,?,?,?)";
	final static String updateSQL = "update t_csbjsjfhsjk set rydm=?,xm=?,ffje=?,sfjj=?,ksbl=?,ksje=?,sfje=?"
			+ " where id = ?";
	
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			CSBJSJFHSJK csbjsjfhsjk = null;
			List<CSBJSJFHSJK > dataList = excelUtils.analysisExcel(path, CSBJSJFHSJK.class);
			int listSize = 0;
			if(dataList != null)
				listSize = dataList.size();
			for(int i = 0; i < listSize; i++) {
				csbjsjfhsjk = dataList.get(i);					
				DataBaseUtils.update(insertSQL,csbjsjfhsjk.getID(),csbjsjfhsjk.getRYDM(),csbjsjfhsjk.getXM(),
						csbjsjfhsjk.getFFJE(),csbjsjfhsjk.getSFJJ(),csbjsjfhsjk.getKSBL(),csbjsjfhsjk.getKSJE(),
						csbjsjfhsjk.getSFJE(),0);
				}
		}
		
		
		/**
		 * 更新创收补缴税金返还数据
		 * @param csbjsjfhsjk
		 */	
		public void updateData(CSBJSJFHSJK csbjsjfhsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(csbjsjfhsjk.getISDEL() == 0) {
				DataBaseUtils.update(updateSQL,csbjsjfhsjk.getRYDM(),csbjsjfhsjk.getXM(),csbjsjfhsjk.getFFJE(),
						csbjsjfhsjk.getSFJJ(),csbjsjfhsjk.getKSBL(),csbjsjfhsjk.getKSJE(),csbjsjfhsjk.getSFJE(),
						csbjsjfhsjk.getID());
			}else if(csbjsjfhsjk.getISDEL() == 2){
				DataBaseUtils.update(insertSQL,csbjsjfhsjk.getID(),csbjsjfhsjk.getRYDM(),csbjsjfhsjk.getXM(),
						csbjsjfhsjk.getFFJE(),csbjsjfhsjk.getSFJJ(),csbjsjfhsjk.getKSBL(),csbjsjfhsjk.getKSJE(),
						csbjsjfhsjk.getSFJE(),0);
			}	
		}
}
