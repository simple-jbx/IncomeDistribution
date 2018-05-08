package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import config.DefalutValue;
import bean.BZXCGSJK;

public class BZXCGSJKService {
	
		private final static String insertSQL = "insert into t_bzxcgsjk(id,rydm,dyzz,zzpx,cgly,jb,fppx,fppxbl,jljebz,grjlje,isdel)"
	            + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		private final static String updateSQL = "update t_bzxcgsjk set rydm=?, dyzz=?, zzpx=?, cgly=?, jb=?, fppx=?, fppxbl=?, "
				+ "jljebz=?, grjlje=? where id = ?";
		
	
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			BZXCGSJK bzxcgsjk = null;
			List<BZXCGSJK > dataList = excelUtils.analysisExcel(path, BZXCGSJK.class);
			int listSize = 0;
			if(dataList != null)
				listSize = dataList.size();
			for(int i = 0; i < listSize; i++) {
				bzxcgsjk = dataList.get(i);					
				DataBaseUtils.update(insertSQL,bzxcgsjk.getID(),bzxcgsjk.getRYDM(),bzxcgsjk.getDYZZ(),bzxcgsjk.getZZPX(),
						bzxcgsjk.getCGLY(),bzxcgsjk.getJB(),bzxcgsjk.getFPPX(),bzxcgsjk.getFPPXBL(),bzxcgsjk.getJLJEBZ(),
						bzxcgsjk.getGRJLJE(),DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
				}
		}
		
		
		/**
		 * 更新标志性成果补贴数据
		 * @param bzxcgsjk
		 */	
		public void updateData(BZXCGSJK bzxcgsjk) {
			if(bzxcgsjk.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
				DataBaseUtils.update(updateSQL,bzxcgsjk.getRYDM(),bzxcgsjk.getDYZZ(),bzxcgsjk.getZZPX(),bzxcgsjk.getCGLY(),
						bzxcgsjk.getJB(),bzxcgsjk.getFPPX(),bzxcgsjk.getFPPXBL(),bzxcgsjk.getJLJEBZ(),
						bzxcgsjk.getGRJLJE(),bzxcgsjk.getID());
			}else if(bzxcgsjk.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
				DataBaseUtils.update(insertSQL,bzxcgsjk.getID(),bzxcgsjk.getRYDM(),bzxcgsjk.getDYZZ(),bzxcgsjk.getZZPX(),
						bzxcgsjk.getCGLY(),bzxcgsjk.getJB(),bzxcgsjk.getFPPX(),bzxcgsjk.getFPPXBL(),bzxcgsjk.getJLJEBZ(),
						bzxcgsjk.getGRJLJE(),0);
			}	
		}
}
