package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.MFSFSGZSJK;

public class MFSFSGZSJKService {
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		MFSFSGZSJK mfsfsgzsjk = null;
		List<MFSFSGZSJK > list = excelUtils.analysisExcel(path, MFSFSGZSJK.class);
		String sql = "insert into t_mfsfsgzsjk(id,rydm,xm,zdgzlhj,gzlcj,sqskksf,pgzylc,sqzbf,hj,isdel)"
	            + " values (?,?,?,?,?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			mfsfsgzsjk = list.get(i);			
			DataBaseUtils.update(sql, mfsfsgzsjk.getID(),mfsfsgzsjk.getRYDM(),mfsfsgzsjk.getXM(),
					mfsfsgzsjk.getZDGZLHJ(),mfsfsgzsjk.getGZLCJ(), mfsfsgzsjk.getSQSKKSF(), mfsfsgzsjk.getPGZYLC(),
					mfsfsgzsjk.getSQZBF(), mfsfsgzsjk.getHJ(), 0);
		}
		
		/*for(int i = list.size()/2; i < list.size(); i++) {
			mfsfsgzsjk = list.get(i);			
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), mfsfsgzsjk.getMFSFSGZSJK(),
					mfsfsgzsjk.getJLJE(), 0);
		}*/
	}
	
	
	/**
	 * 更新免费师范生工作数据表数据
	 * @param mfsfsgzsjk
	 */
	public void updateData(MFSFSGZSJK mfsfsgzsjk) {
		if(mfsfsgzsjk.getISDEL() == 0) {
			String sql = "update t_mfsfsgzsjk set rydm=?,xm=?,zdgzlhj=?,gzlcj=?,sqskksf=?,"
					+ "pgzylc=?,sqzbf=?,hj=? where id=?"
		            + " values (?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql,mfsfsgzsjk.getRYDM(), mfsfsgzsjk.getXM(), 
					mfsfsgzsjk.getZDGZLHJ(),mfsfsgzsjk.getGZLCJ(), mfsfsgzsjk.getSQSKKSF(),
					mfsfsgzsjk.getPGZYLC(),mfsfsgzsjk.getSQZBF(), mfsfsgzsjk.getHJ(), mfsfsgzsjk.getID());
		}else if(mfsfsgzsjk.getISDEL() == 2){
			String sql = "insert into t_mfsfsgzsjk(id,rydm,xm,zdgzlhj,gzlcj,sqskksf,pgzylc,sqzbf,hj,isdel)"
		            + " values (?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, mfsfsgzsjk.getID(),mfsfsgzsjk.getRYDM(), mfsfsgzsjk.getXM(), 
					mfsfsgzsjk.getZDGZLHJ(),mfsfsgzsjk.getGZLCJ(), mfsfsgzsjk.getSQSKKSF(),
					mfsfsgzsjk.getPGZYLC(),mfsfsgzsjk.getSQZBF(), mfsfsgzsjk.getHJ(), 0);
		}
	}
}
