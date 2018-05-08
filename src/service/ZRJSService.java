package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.ZRJS;
import utils.DataBaseUtils;
import utils.excelUtils;

/**
 * 专任教师人员
 * @author simple
 *
 */
public class ZRJSService {
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZRJS updateObject = null;
		int listSize = 0;
		List<ZRJS > listOfObject = excelUtils.analysisExcel(path, ZRJS.class);
		String sql = "insert into t_zrjs(id,rydm,xm,zgsjxs,khgzl,zgzlhj,cgzl,cgzljcj,kyjcj,jsxfjj,rjj,bzxcgjl,"
				+ "jkgz,zbgz,xxpy,xypy,jxdd,dbbt,xyhbt,zjbt,hfbt,xwbt,gzbc,zbbt,jyshdjf,dypcjcj,depcrjj,msgzcj,"
				+ "kqkf,msgzbf,csbjksjfh,ylbfhkcje,dspcfphj,sjzjcj,tzje,sjxy,sfje,nd,isdel)"
	            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		listSize = listOfObject.size();
		for(int i = 0; i < listSize; i++) {
			updateObject = listOfObject.get(i);					
			DataBaseUtils.update(sql,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getZGSJXS(),updateObject.getKHGZL(),updateObject.getZGZLHJ(),
					updateObject.getCGZL(),updateObject.getZGZLHJ(),updateObject.getKYJCJ(),
					updateObject.getJSXFJJ(),updateObject.getRJJ(),updateObject.getBZXCGJL(),
					updateObject.getJKGZ(),updateObject.getZBGZ(),updateObject.getXXPY(),
					updateObject.getXYPY(),updateObject.getJXDD(),updateObject.getDBBT(),
					updateObject.getXYHBT(),updateObject.getZJBT(),updateObject.getHFBT(),
					updateObject.getXWBT(),updateObject.getGZBC(),updateObject.getZBBT(),
					updateObject.getJYSHDJF(),updateObject.getDYPCJCJ(),updateObject.getDEPCRJJ(),
					updateObject.getMSGZCJ(),updateObject.getKQKF(),updateObject.getMSGZBF(),
					updateObject.getCSBJKSJFH(),updateObject.getYLBFHKCJE(),updateObject.getDSPCFPHJ(),
					updateObject.getSJZJCJ(),updateObject.getTZJE(),updateObject.getSJXY(),
					updateObject.getSFJE(),updateObject.getND(),
					config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新科研数据
	 * @param updateObject
	 */	
	public void updateData(ZRJS updateObject) {
		//System.out.println(jsxljshfwsj.getID());
		//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
		if(updateObject.getISDEL() == config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			String sql = "update t_zrjs set rydm=?,xm=?,zgsjxs=?,khgzl=?,zgzlhj=?,cgzl=?,cgzljcj=?,kyjcj=?,"
					+ "jsxfjj=?,rjj=?,bzxcgjl=?,jkgz=?,zbgz=?,xxpy=?,xypy=?,jxdd=?,dbbt=?,xyhbt=?,zjbt=?,"
					+ "hfbt=?,xwbt=?,gzbc=?,zbbt=?,jyshdjf=?,dypcjcj=?,depcrjj=?,msgzcj=?,kqkf=?,msgzbf=?,"
					+ "csbjksjfh=?,ylbfhkcje=?,dspcfphj=?,sjzjcj=?,tzje=?,sjxy=?,sfje=?,nd=? where id=?";
		   	DataBaseUtils.update(sql,updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getZGSJXS(),updateObject.getKHGZL(),updateObject.getZGZLHJ(),
					updateObject.getCGZL(),updateObject.getZGZLHJ(),updateObject.getKYJCJ(),
					updateObject.getJSXFJJ(),updateObject.getRJJ(),updateObject.getBZXCGJL(),
					updateObject.getJKGZ(),updateObject.getZBGZ(),updateObject.getXXPY(),
					updateObject.getXYPY(),updateObject.getJXDD(),updateObject.getDBBT(),
					updateObject.getXYHBT(),updateObject.getZJBT(),updateObject.getHFBT(),
					updateObject.getXWBT(),updateObject.getGZBC(),updateObject.getZBBT(),
					updateObject.getJYSHDJF(),updateObject.getDYPCJCJ(),updateObject.getDEPCRJJ(),
					updateObject.getMSGZCJ(),updateObject.getKQKF(),updateObject.getMSGZBF(),
					updateObject.getCSBJKSJFH(),updateObject.getYLBFHKCJE(),updateObject.getDSPCFPHJ(),
					updateObject.getSJZJCJ(),updateObject.getTZJE(),updateObject.getSJXY(),
					updateObject.getSFJE(),updateObject.getND(),updateObject.getID());
		}else if(updateObject.getISDEL() == config.DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			String sql = "insert into t_zrjs(id,rydm,xm,zgsjxs,khgzl,zgzlhj,cgzl,cgzljcj,kyjcj,jsxfjj,rjj,bzxcgjl,"
					+ "jkgz,zbgz,xxpy,xypy,jxdd,dbbt,xyhbt,zjbt,hfbt,xwbt,gzbc,zbbt,jyshdjf,dypcjcj,depcrjj,msgzcj,"
					+ "kqkf,msgzbf,csbjksjfh,ylbfhkcje,dspcfphj,sjzjcj,tzje,sjxy,sfje,nd,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			DataBaseUtils.update(sql,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getZGSJXS(),updateObject.getKHGZL(),updateObject.getZGZLHJ(),
					updateObject.getCGZL(),updateObject.getZGZLHJ(),updateObject.getKYJCJ(),
					updateObject.getJSXFJJ(),updateObject.getRJJ(),updateObject.getBZXCGJL(),
					updateObject.getJKGZ(),updateObject.getZBGZ(),updateObject.getXXPY(),
					updateObject.getXYPY(),updateObject.getJXDD(),updateObject.getDBBT(),
					updateObject.getXYHBT(),updateObject.getZJBT(),updateObject.getHFBT(),
					updateObject.getXWBT(),updateObject.getGZBC(),updateObject.getZBBT(),
					updateObject.getJYSHDJF(),updateObject.getDYPCJCJ(),updateObject.getDEPCRJJ(),
					updateObject.getMSGZCJ(),updateObject.getKQKF(),updateObject.getMSGZBF(),
					updateObject.getCSBJKSJFH(),updateObject.getYLBFHKCJE(),updateObject.getDSPCFPHJ(),
					updateObject.getSJZJCJ(),updateObject.getTZJE(),updateObject.getSJXY(),
					updateObject.getSFJE(),updateObject.getND(),
					config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}	
	}
}
