package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XYZHGLYFZPJFPJGB;

public class XYZHGLYFZPJFPJGBService {
	
	/**
	 * 查询学院综合管理与发展评价分配结果表所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_xyzhglyfzpjfpjgb where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XYZHGLYFZPJFPJGB xyzhglyfzpjfpjgb = null;
		List<XYZHGLYFZPJFPJGB > list = excelUtils.analysisExcel(path, XYZHGLYFZPJFPJGB.class);
		String sql = "insert into t_xyzhglyfzpjfpjgb(id,nd,jzgs,xkjs,dwjs,kxyjw,kxyjl,rcpyzl,rcpygm,"
				+ "shsyyshfw,fpjehj,cskyje,mfsfscj,qtsr,csjy,isdel)"
	            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			xyzhglyfzpjfpjgb = list.get(i);			
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), xyzhglyfzpjfpjgb.getND(),xyzhglyfzpjfpjgb.getJZGS(),
					xyzhglyfzpjfpjgb.getXKJS(),xyzhglyfzpjfpjgb.getDWJS(),xyzhglyfzpjfpjgb.getKXYJW(),
					xyzhglyfzpjfpjgb.getKXYJL(),xyzhglyfzpjfpjgb.getRCPYZL(),xyzhglyfzpjfpjgb.getRCPYGM(),
					xyzhglyfzpjfpjgb.getSHSYYSHFW(),xyzhglyfzpjfpjgb.getFPJEHJ(),xyzhglyfzpjfpjgb.getCSKYJE(),
					xyzhglyfzpjfpjgb.getMFSFSCJ(),xyzhglyfzpjfpjgb.getQTSR(),xyzhglyfzpjfpjgb.getCSJY(),0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_xyzhglyfzpjfpjgb set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新在岗时间系数数据
	 * @param zgsjxs
	 */
	public void updateData(XYZHGLYFZPJFPJGB xyzhglyfzpjfpjgb) {

		if(xyzhglyfzpjfpjgb.getISDEL() == 0) {
			String sql = "update t_xyzhglyfzpjfpjgb set nd=?,jzgs=?,xkjs=?,dwjs=?,kxyjw=?,kxyjl=?,rcpyzl=?,"
					+ "rcpygm=?,shsyyshfw=?,fpjehj=?,cskyje=?,mfsfscj=?,qtsr=?,csjy=?,isdel=? where id=?"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";				
			DataBaseUtils.update(sql, xyzhglyfzpjfpjgb.getND(),xyzhglyfzpjfpjgb.getJZGS(),
					xyzhglyfzpjfpjgb.getXKJS(),xyzhglyfzpjfpjgb.getDWJS(),xyzhglyfzpjfpjgb.getKXYJW(),
					xyzhglyfzpjfpjgb.getKXYJL(),xyzhglyfzpjfpjgb.getRCPYZL(),xyzhglyfzpjfpjgb.getRCPYGM(),
					xyzhglyfzpjfpjgb.getSHSYYSHFW(),xyzhglyfzpjfpjgb.getFPJEHJ(),xyzhglyfzpjfpjgb.getCSKYJE(),
					xyzhglyfzpjfpjgb.getMFSFSCJ(),xyzhglyfzpjfpjgb.getQTSR(),xyzhglyfzpjfpjgb.getCSJY(),0,
					xyzhglyfzpjfpjgb.getID());
		}else if(xyzhglyfzpjfpjgb.getISDEL() == 2){
			String sql = "insert into t_xyzhglyfzpjfpjgb(id,nd,jzgs,xkjs,dwjs,kxyjw,kxyjl,rcpyzl,rcpygm,"
					+ "shsyyshfw,fpjehj,cskyje,mfsfscj,qtsr,csjy,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), xyzhglyfzpjfpjgb.getND(),xyzhglyfzpjfpjgb.getJZGS(),
					xyzhglyfzpjfpjgb.getXKJS(),xyzhglyfzpjfpjgb.getDWJS(),xyzhglyfzpjfpjgb.getKXYJW(),
					xyzhglyfzpjfpjgb.getKXYJL(),xyzhglyfzpjfpjgb.getRCPYZL(),xyzhglyfzpjfpjgb.getRCPYGM(),
					xyzhglyfzpjfpjgb.getSHSYYSHFW(),xyzhglyfzpjfpjgb.getFPJEHJ(),xyzhglyfzpjfpjgb.getCSKYJE(),
					xyzhglyfzpjfpjgb.getMFSFSCJ(),xyzhglyfzpjfpjgb.getQTSR(),xyzhglyfzpjfpjgb.getCSJY(),0);
		}
		
	}
}
