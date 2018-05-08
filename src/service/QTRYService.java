package service;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import utils.DataBaseUtils;
import config.DefalutValue;
import utils.excelUtils;
import bean.QTRY;
public class QTRYService {
	
	private final static String insertSQL = "insert into t_qtry(id,rydm,xm,zgsjxs,khgzl,zgzlhj,cgzl,cgzljcj,jxdd,dypcjcj,msgzbf,ylbfhkcje,"
			+ "dspcfphj,sjzjcj,nd,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	

	private final static String updateSQL = "update t_qtry set rydm=?,xm=?,zgsjxs=?,khgzl=?,zgzlhj=?,cgzl=?,cgzljcj=?,jxdd=?,"
			+ "dypcjcj=?,msgzbf=?,ylbfhkcje=?,dspcfphj=?,sjzjcj=?,nd=? where id=?"
			+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	

	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		QTRY qtry = null;
		List<QTRY > dataList = excelUtils.analysisExcel(path, QTRY.class);
		int listSize = 0;
		if(dataList != null)
			listSize = dataList.size();
		for(int i = 0; i < listSize; i++) {
			qtry = dataList.get(i);
			DataBaseUtils.update(insertSQL, qtry.getID(),qtry.getRYDM(),qtry.getXM(),qtry.getZGSJXS(),qtry.getKHGZL(),
					qtry.getZGZLHJ(),qtry.getCGZL(),qtry.getCGZLJCJ(),qtry.getJXDD(),qtry.getDYPCJCJ(),
					qtry.getMSGZBF(),qtry.getYLBFHKCJE(),qtry.getDSPCFPHJ(),qtry.getSJZJCJ(),qtry.getND(),
					config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新其他人员数据
	 * @param qtry
	 */
	public void updateData(QTRY qtry) {
		if(qtry.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
				DataBaseUtils.update(updateSQL,qtry.getRYDM(),qtry.getXM(),qtry.getZGSJXS(),qtry.getKHGZL(),
					qtry.getZGZLHJ(),qtry.getCGZL(),qtry.getCGZLJCJ(),qtry.getJXDD(),qtry.getDYPCJCJ(),
					qtry.getMSGZBF(),qtry.getYLBFHKCJE(),qtry.getDSPCFPHJ(),qtry.getSJZJCJ(),qtry.getND(),
					qtry.getID());
		}else if(qtry.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
				DataBaseUtils.update(insertSQL, qtry.getID(),qtry.getRYDM(),qtry.getXM(),qtry.getZGSJXS(),qtry.getKHGZL(),
					qtry.getZGZLHJ(),qtry.getCGZL(),qtry.getCGZLJCJ(),qtry.getJXDD(),qtry.getDYPCJCJ(),
					qtry.getMSGZBF(),qtry.getYLBFHKCJE(),qtry.getDSPCFPHJ(),qtry.getSJZJCJ(),qtry.getND(),
					config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
		
	}
}
