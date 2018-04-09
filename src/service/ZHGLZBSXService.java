package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZHGLZBSX;

public class ZHGLZBSXService {
	
	/**
	 * 查询综合管理指标时效所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_zhglzbsx where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZHGLZBSX zhglzbsx = null;
		List<ZHGLZBSX > list = excelUtils.analysisExcel(path, ZHGLZBSX.class);
		String sql = "insert into t_zhglzbsx(id,zhglzbsx,jlje,isdel)"
	            + " VALUES (?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			zhglzbsx = list.get(i);			
			DataBaseUtils.update(sql, UUID.randomUUID().toString().replaceAll("-", ""),
					zhglzbsx.getZHGLZBSX(),zhglzbsx.getJLJE(), 0);
		}
		
		/*for(int i = list.size()/2; i < list.size(); i++) {
			zhglzbsx = list.get(i);			
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), zhglzbsx.getZHGLZBSX(),
					zhglzbsx.getJLJE(), 0);
		}*/
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_zhglzbsx set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新在岗时间系数数据
	 * @param zgsjxs
	 */
	public void updateData(ZHGLZBSX zhglzbsx) {
		if(zhglzbsx.getISDEL() == 0) {
			String sql = "update t_zhglzbsx set zhglzbsx = ?, jlje = ?"
					+ " where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, zhglzbsx.getZHGLZBSX(), zhglzbsx.getJLJE(), zhglzbsx.getID(), 0);
		}else if(zhglzbsx.getISDEL() == 2){
			String sql = "insert into t_zhglzbsx(id,zhglzbsx,jlje,isdel)"
		            + " VALUES (?,?,?,?)";	
			DataBaseUtils.update(sql,zhglzbsx.getID(), zhglzbsx.getZHGLZBSX(),
					zhglzbsx.getJLJE(), 0);
		}
	}
}
