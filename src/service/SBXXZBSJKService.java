package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.SBXXZBSJK;

public class SBXXZBSJKService {

		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			SBXXZBSJK sbxxzbsjk = null;
			List<SBXXZBSJK > list = excelUtils.analysisExcel(path, SBXXZBSJK.class);
			String sql = "insert into t_sbxxzbsjk(id,bmdm,rydm,xm,bmmc,nzjje,tzje,sqsf,cssl,skcs,sfje,lxdh,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size(); i++) {
				sbxxzbsjk = list.get(i);					
				DataBaseUtils.update(sql,sbxxzbsjk.getID(),sbxxzbsjk.getBMDM(),sbxxzbsjk.getRYDM(),sbxxzbsjk.getXM(),
						sbxxzbsjk.getBMMC(),sbxxzbsjk.getNZJJE(),sbxxzbsjk.getTZJE(),sbxxzbsjk.getSQSF(),
						sbxxzbsjk.getCSSL(),sbxxzbsjk.getSKCS(),sbxxzbsjk.getSFJE(),sbxxzbsjk.getLXDH(),0);
			}
		}

		
		/**
		 * 更新场馆负责人数据
		 * @param sbxxzbsjk
		 */	
		public void updateData(SBXXZBSJK sbxxzbsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(sbxxzbsjk.getISDEL() == 0) {
				String sql = "update t_sbxxzbsjk set bmdm=?,rydm=?,xm=?,bmmc=?,nzjje=?,tzje=?,sqsf=?,cssl=?,"
						+ "skcs=?,sfje=?,lxdh=? where id = ?";
				DataBaseUtils.update(sql,sbxxzbsjk.getBMDM(),sbxxzbsjk.getRYDM(),sbxxzbsjk.getXM(),
						sbxxzbsjk.getBMMC(),sbxxzbsjk.getNZJJE(),sbxxzbsjk.getTZJE(),sbxxzbsjk.getSQSF(),
						sbxxzbsjk.getCSSL(),sbxxzbsjk.getSKCS(),sbxxzbsjk.getSFJE(),sbxxzbsjk.getLXDH(),
						sbxxzbsjk.getID());
	}else if(sbxxzbsjk.getISDEL() == 2){
				String sql = "insert into t_sbxxzbsjk(id,bmdm,rydm,xm,bmmc,nzjje,tzje,sqsf,cssl,skcs,sfje,lxdh,isdel)"
			            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
				DataBaseUtils.update(sql,sbxxzbsjk.getID(),sbxxzbsjk.getBMDM(),sbxxzbsjk.getRYDM(),sbxxzbsjk.getXM(),
						sbxxzbsjk.getBMMC(),sbxxzbsjk.getNZJJE(),sbxxzbsjk.getTZJE(),sbxxzbsjk.getSQSF(),
						sbxxzbsjk.getCSSL(),sbxxzbsjk.getSKCS(),sbxxzbsjk.getSFJE(),sbxxzbsjk.getLXDH(),0);
			}	
		}
}
