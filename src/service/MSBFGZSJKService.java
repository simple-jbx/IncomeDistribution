package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.MSBFGZSJK;

public class MSBFGZSJKService {
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		MSBFGZSJK msbfgzsjk = null;
		List<MSBFGZSJK > list = excelUtils.analysisExcel(path, MSBFGZSJK.class);
		String sql = "insert into t_msbfgzsjk(id,rydm,xm,msdsgzl,gzlbzj,ffje,isdel) VALUES (?,?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			msbfgzsjk = list.get(i);
			DataBaseUtils.update(sql, msbfgzsjk.getID(), msbfgzsjk.getRYDM(), msbfgzsjk.getXM(),
					msbfgzsjk.getMSDSGZL(), msbfgzsjk.getGZLBZJ(), msbfgzsjk.getFFJE(), 0);
		}
	}
	
	
	/**
	 * 更新指标体系补贴数据
	 * @param msbfgzsjk
	 */
	public void updateData(MSBFGZSJK msbfgzsjk) {
		//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
		if(msbfgzsjk.getISDEL() == 0) {
			String sql = "update t_msbfgzsjk set rydm = ?, xm = ?, msdsgzl = ?, gzlbzl = ?, ffje = ? "
					+ "where id = ?";
			DataBaseUtils.update(sql,msbfgzsjk.getRYDM(),msbfgzsjk.getXM(),msbfgzsjk.getMSDSGZL(), 
					msbfgzsjk.getGZLBZJ(),msbfgzsjk.getFFJE(), msbfgzsjk.getID());
		}else if(msbfgzsjk.getISDEL() == 2){
			String sql = "insert into t_msbfgzsjk(id,rydm,xm,msdsgzl,gzlbzj,ffje,isdel) VALUES (?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, msbfgzsjk.getID(), msbfgzsjk.getRYDM(), msbfgzsjk.getXM(),
					msbfgzsjk.getMSDSGZL(), msbfgzsjk.getGZLBZJ(), msbfgzsjk.getFFJE(), 0);
		}	
	}
}
