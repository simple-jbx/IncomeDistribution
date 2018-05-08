package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.SBXXFFBSJK;

//创收补缴税金返还
public class SBXXFFBSJKService {
	
		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			SBXXFFBSJK sbxxffbsjk = null;
			List<SBXXFFBSJK > list = excelUtils.analysisExcel(path, SBXXFFBSJK.class);
			String sql = "insert into t_sbxxffbsjk(id,bmdm,rydm,xm,bmmc,jx,xz,gq,qt,nzjje,sfzhm,yhkh,cssl,"
					+ "lxdh,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size(); i++) {
				sbxxffbsjk = list.get(i);					
				DataBaseUtils.update(sql,sbxxffbsjk.getID(),sbxxffbsjk.getBMDM(),sbxxffbsjk.getRYDM(),
						sbxxffbsjk.getXM(),sbxxffbsjk.getBMMC(),sbxxffbsjk.getJX(),sbxxffbsjk.getXZ(),
						sbxxffbsjk.getGQ(),sbxxffbsjk.getQT(),sbxxffbsjk.getNZJJE(),sbxxffbsjk.getSFZHM(),
						sbxxffbsjk.getYHKH(),sbxxffbsjk.getCSSL(),sbxxffbsjk.getLXDH(),0);
			}
		}
		
		
		/**
		 * 更新创收补缴税金返还数据
		 * @param sbxxffbsjk
		 */	
		public void updateData(SBXXFFBSJK sbxxffbsjk) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(sbxxffbsjk.getISDEL() == 0) {
				String sql = "update t_sbxxffbsjk set bmdm=?,rydm=?,xm=?,bmmc=?,jx=?,xz=?,gq=?,qt=?,nzjje=?,"
						+ "sfzhm=?,yhkh=?,cssl=?,lxdh=? where id = ?";
				DataBaseUtils.update(sql,sbxxffbsjk.getBMDM(),sbxxffbsjk.getRYDM(),sbxxffbsjk.getXM(),
						sbxxffbsjk.getBMMC(),sbxxffbsjk.getJX(),sbxxffbsjk.getXZ(),sbxxffbsjk.getGQ(),
						sbxxffbsjk.getQT(),sbxxffbsjk.getNZJJE(),sbxxffbsjk.getSFZHM(),sbxxffbsjk.getYHKH(),
						sbxxffbsjk.getCSSL(),sbxxffbsjk.getLXDH(),sbxxffbsjk.getID());
			}else if(sbxxffbsjk.getISDEL() == 2){
				String sql = "insert into t_sbxxffbsjk(id,bmdm,rydm,xm,bmmc,jx,xz,gq,qt,nzjje,sfzhm,yhkh,cssl,"
						+ "lxdh,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				DataBaseUtils.update(sql,sbxxffbsjk.getID(),sbxxffbsjk.getBMDM(),sbxxffbsjk.getRYDM(),
						sbxxffbsjk.getXM(),sbxxffbsjk.getBMMC(),sbxxffbsjk.getJX(),sbxxffbsjk.getXZ(),
						sbxxffbsjk.getGQ(),sbxxffbsjk.getQT(),sbxxffbsjk.getNZJJE(),sbxxffbsjk.getSFZHM(),
						sbxxffbsjk.getYHKH(),sbxxffbsjk.getCSSL(),sbxxffbsjk.getLXDH(),0);
		}	
		}
}
