package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZBTXBTSJK;

public class ZBTXBTSJKService {
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZBTXBTSJK zbtxbtsjk = null;
		List<ZBTXBTSJK > list = excelUtils.analysisExcel(path, ZBTXBTSJK.class);
		String sql = "insert into t_zbtxbtsjk(id,rydm,xm,dfxm,nx,jlje,isdel) VALUES (?,?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			zbtxbtsjk = list.get(i);
			DataBaseUtils.update(sql, zbtxbtsjk.getID(), zbtxbtsjk.getRYDM(), zbtxbtsjk.getXM(),
					zbtxbtsjk.getDFXM(), zbtxbtsjk.getNX(), zbtxbtsjk.getJLJE(), 0);
		}
	}
	
	
	/**
	 * 更新指标体系补贴数据
	 * @param zbtxbtsjk
	 */
	public void updateData(ZBTXBTSJK zbtxbtsjk) {
		//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
		if(zbtxbtsjk.getISDEL() == 0) {
			String sql = "update t_zbtxbtsjk set rydm = ?, xm = ?, dfxm = ?, nx = ?, jlje = ? where id = ?";
			DataBaseUtils.update(sql,zbtxbtsjk.getRYDM(),zbtxbtsjk.getXM(),zbtxbtsjk.getDFXM(), zbtxbtsjk.getNX(),
					zbtxbtsjk.getJLJE(), zbtxbtsjk.getID());
		}else if(zbtxbtsjk.getISDEL() == 2){
			String sql = "insert into t_zbtxbtsjk(id,rydm,xm,dfxm,nx,jlje,isdel) VALUES (?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, zbtxbtsjk.getID(), zbtxbtsjk.getRYDM(), zbtxbtsjk.getXM(),
					zbtxbtsjk.getDFXM(), zbtxbtsjk.getNX(), zbtxbtsjk.getJLJE(), 0);
		}	
	}
}
