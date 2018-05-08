package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.JYSHDJFSJK;

public class JYSHDJFSJKService {
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		JYSHDJFSJK jyshdjfsjk = null;
		List<JYSHDJFSJK > list = excelUtils.analysisExcel(path, JYSHDJFSJK.class);
		String sql = "insert into t_jyshdjfsjk(id,rydm,xm,jyshdjf,jc,hj,isdel) values (?,?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			jyshdjfsjk = list.get(i);
			DataBaseUtils.update(sql, jyshdjfsjk.getID(),jyshdjfsjk.getRYDM(),jyshdjfsjk.getXM(),
					jyshdjfsjk.getJYSHDJF(), jyshdjfsjk.getJC(),jyshdjfsjk.getHJ(),0);
		}
	}
	
	
	/**
	 * 更新教研室活动经费表数据
	 * @param jyshdjfsjk
	 */
	public void updateData(JYSHDJFSJK jyshdjfsjk) {
		if(jyshdjfsjk.getISDEL() == 0) {
			String sql = "update t_jyshdjfsjk set rydm=?, xm=?, jyshdjf=?, jc=?, hj=? where id=?";			
			DataBaseUtils.update(sql, jyshdjfsjk.getXM(), jyshdjfsjk.getJYSHDJF(), jyshdjfsjk.getJC(),
					jyshdjfsjk.getHJ(), jyshdjfsjk.getID(), 0);
		}else if(jyshdjfsjk.getISDEL() == 2){
			String sql = "insert into t_jyshdjfsjk(id,rydm,xm,jyshdjf,jc,hj,isdel) values (?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, jyshdjfsjk.getID(),jyshdjfsjk.getRYDM(),jyshdjfsjk.getXM(), 
					jyshdjfsjk.getJYSHDJF(), jyshdjfsjk.getJC(),jyshdjfsjk.getHJ(), 0);
		}
		
	}
}
