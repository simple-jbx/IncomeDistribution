package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.JYSHDJFSJK;

public class JYSHDJFSJKService {
	
	/**
	 * 查询教研室活动经费表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_jyshdjfsjk where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
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
			DataBaseUtils.update(sql, UUID.randomUUID().toString().replaceAll("-", ""),
					jyshdjfsjk.getRYDM(),jyshdjfsjk.getXM(), jyshdjfsjk.getJYSHDJF(), jyshdjfsjk.getJC(),
					jyshdjfsjk.getHJ(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param ID
	 */
	public void deleteByID(String ID) {
		String sql = "update t_jyshdjfsjk set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新教研室活动经费表数据
	 * @param jyshdjfsjk
	 */
	public void updateData(JYSHDJFSJK jyshdjfsjk) {
		if(jyshdjfsjk.getISDEL() == 0) {
			String sql = "update t_jyshdjfsjk set rydm = ?, xm = ?, jyshdjf = ?, jc = ?, hj = ? where id = ?";			
			DataBaseUtils.update(sql, jyshdjfsjk.getXM(), jyshdjfsjk.getJYSHDJF(), jyshdjfsjk.getJC(),
					jyshdjfsjk.getHJ(), jyshdjfsjk.getID(), 0);
		}else if(jyshdjfsjk.getISDEL() == 2){
			String sql = "insert into t_jyshdjfsjk(id,rydm,xm,jyshdjf,jc,hj,isdel) values (?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, jyshdjfsjk.getID(),jyshdjfsjk.getRYDM(),jyshdjfsjk.getXM(), 
					jyshdjfsjk.getJYSHDJF(), jyshdjfsjk.getJC(),jyshdjfsjk.getHJ(), 0);
		}
		
	}
}
