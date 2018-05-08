package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.XZGLRY;
import utils.DataBaseUtils;
import utils.excelUtils;

/**
 * 行政管理人员
 * @author simple
 *
 */
public class XZGLRYService {
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XZGLRY updateObject = null;
		int listSize = 0;
		List<XZGLRY > listOfObject = excelUtils.analysisExcel(path, XZGLRY.class);
		String sql = "insert into t_xzglry(id,rydm,xm,zw,zj,zgxs,zyxs,kqxs,fpxs,xzpjj,xyrjj,bzxcgjl,jkgz,"
				+ "zbgz,xxpy,xypy,jxdd,dbbt,xyhbt,zjbt,hfbt,xwbt,jyshdjf,dypcjcj,depcjcj,rjce,msgzcj,kqkf,"
				+ "msgzbf,csbjsjfh,ylbfhkcje,dspcfphj,sjzjcj,tzje,sjxyje,sfje,nd,isdel)"
	            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		listSize = listOfObject.size();
		for(int i = 0; i < listSize; i++) {
			updateObject = listOfObject.get(i);					
			DataBaseUtils.update(sql,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getZW(),updateObject.getZJ(),updateObject.getZGXS(),updateObject.getZYXS(),
					updateObject.getKQXS(),updateObject.getFPXS(),updateObject.getXZPJJ(),
					updateObject.getXYRJJ(),updateObject.getBZXCGJL(),updateObject.getJKGZ(),
					updateObject.getZBGZ(),updateObject.getXXPY(),updateObject.getXYPY(),
					updateObject.getJXDD(),updateObject.getDBBT(),updateObject.getXYHBT(),
					updateObject.getZJBT(),updateObject.getHFBT(),updateObject.getXWBT(),
					updateObject.getJYSHDJF(),updateObject.getDYPCJCJ(),updateObject.getDEPCJCJ(),
					updateObject.getRJCE(),updateObject.getMSGZCJ(),updateObject.getKQKF(),
					updateObject.getMSGZBF(),updateObject.getCSBJSJFH(),updateObject.getYLBFHKCJE(),
					updateObject.getDSPCFPHJ(),updateObject.getSJZJCJ(),updateObject.getTZJE(),
					updateObject.getSJXYJE(),updateObject.getSFJE(),updateObject.getND(),
					config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新科研数据
	 * @param updateObject
	 */	
	public void updateData(XZGLRY updateObject) {
		//System.out.println(jsxljshfwsj.getID());
		//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
		if(updateObject.getISDEL() == config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			String sql = "update t_xzglry id=?,rydm=?,xm=?,zw=?,zj=?,zgxs=?,zyxs=?,kqxs=?,fpxs=?,xzpjj=?,"
					+ "xyrjj=?,bzxcgjl=?,jkgz=?,zbgz=?,xxpy=?,xypy=?,jxdd=?,dbbt=?,xyhbt=?,zjbt=?,hfbt=?,"
					+ "xwbt=?,jyshdjf=?,dypcjcj=?,depcjcj=?,rjce=?,msgzcj=?,kqkf=?,msgzbf=?,csbjsjfh=?,"
					+ "ylbfhkcje=?,dspcfphj=?,sjzjcj=?,tzje=?,sjxyje=?,sfje=?,nd=? where id=?"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql,updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getZW(),updateObject.getZJ(),updateObject.getZGXS(),updateObject.getZYXS(),
					updateObject.getKQXS(),updateObject.getFPXS(),updateObject.getXZPJJ(),
					updateObject.getXYRJJ(),updateObject.getBZXCGJL(),updateObject.getJKGZ(),
					updateObject.getZBGZ(),updateObject.getXXPY(),updateObject.getXYPY(),
					updateObject.getJXDD(),updateObject.getDBBT(),updateObject.getXYHBT(),
					updateObject.getZJBT(),updateObject.getHFBT(),updateObject.getXWBT(),
					updateObject.getJYSHDJF(),updateObject.getDYPCJCJ(),updateObject.getDEPCJCJ(),
					updateObject.getRJCE(),updateObject.getMSGZCJ(),updateObject.getKQKF(),
					updateObject.getMSGZBF(),updateObject.getCSBJSJFH(),updateObject.getYLBFHKCJE(),
					updateObject.getDSPCFPHJ(),updateObject.getSJZJCJ(),updateObject.getTZJE(),
					updateObject.getSJXYJE(),updateObject.getSFJE(),updateObject.getND(),
					updateObject.getID());
		}else if(updateObject.getISDEL() == config.DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			String sql = "insert into t_xzglry(id,rydm,xm,zw,zj,zgxs,zyxs,kqxs,fpxs,xzpjj,xyrjj,bzxcgjl,jkgz,"
					+ "zbgz,xxpy,xypy,jxdd,dbbt,xyhbt,zjbt,hfbt,xwbt,jyshdjf,dypcjcj,depcjcj,rjce,msgzcj,"
					+ "kqkf,msgzbf,csbjsjfh,ylbfhkcje,dspcfphj,sjzjcj,tzje,sjxyje,sfje,nd,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			DataBaseUtils.update(sql,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getZW(),updateObject.getZJ(),updateObject.getZGXS(),updateObject.getZYXS(),
					updateObject.getKQXS(),updateObject.getFPXS(),updateObject.getXZPJJ(),
					updateObject.getXYRJJ(),updateObject.getBZXCGJL(),updateObject.getJKGZ(),
					updateObject.getZBGZ(),updateObject.getXXPY(),updateObject.getXYPY(),
					updateObject.getJXDD(),updateObject.getDBBT(),updateObject.getXYHBT(),
					updateObject.getZJBT(),updateObject.getHFBT(),updateObject.getXWBT(),
					updateObject.getJYSHDJF(),updateObject.getDYPCJCJ(),updateObject.getDEPCJCJ(),
					updateObject.getRJCE(),updateObject.getMSGZCJ(),updateObject.getKQKF(),
					updateObject.getMSGZBF(),updateObject.getCSBJSJFH(),updateObject.getYLBFHKCJE(),
					updateObject.getDSPCFPHJ(),updateObject.getSJZJCJ(),updateObject.getTZJE(),
					updateObject.getSJXYJE(),updateObject.getSFJE(),updateObject.getND(),
					config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}	
	}
}
