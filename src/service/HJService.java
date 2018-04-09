package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.HJ;

public class HJService {
	
	/**
	 * 查询获奖表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_hj where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		HJ hj = null;
		List<HJ > list = excelUtils.analysisExcel(path, HJ.class);
		for(int i = 0; i < list.size(); i++) {
			hj = list.get(i);
			String sql = "insert into t_elylxydhkq(jlmc,cgmc,hjzz,zzpx,fzjg,hjrq"
		            + ",xxsm,hjjb,hjdj,dwpm,sftj,shzt,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, hj.getJLMC(), hj.getCGMC(), hj.getHJZZ(), hj.getZZPX(),
					hj.getFZJG(), hj.getHJRQ(), hj.getXXSM(), hj.getHJJB(), hj.getDWPM(), hj.getSFTJ(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_elylxydhkq set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新获奖数据
	 * @param elylxydhkq
	 */
	public void updateData(HJ hj) {
		String selectSQL = "select * from t_hj where id = ? and isdel = ?";
		HJ selectHJ = DataBaseUtils.queryForBean(selectSQL, HJ.class, hj.getID(), 0);

		if(selectHJ != null) {
			String sql = "update t_hj set jlmc = ?, cgmc = ?, hjzz = ?, zzpx = ?, fzjg = ?, hjrq = ?,"
					+ "xxsm = ?, hjjb = ?, dwpm = ?, sftj = ?, shzt = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, hj.getJLMC(), hj.getCGMC(), hj.getHJZZ(), hj.getZZPX(),
					hj.getFZJG(), hj.getHJRQ(), hj.getXXSM(), hj.getHJJB(), hj.getDWPM(), hj.getSFTJ(), hj.getID(), 0);
		}else {
			String sql = "insert into t_elylxydhkq(jlmc,cgmc,hjzz,zzpx,fzjg,hjrq"
		            + ",xxsm,hjjb,hjdj,dwpm,sftj,shzt,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, hj.getJLMC(), hj.getCGMC(), hj.getHJZZ(), hj.getZZPX(),
					hj.getFZJG(), hj.getHJRQ(), hj.getXXSM(), hj.getHJJB(), hj.getDWPM(), hj.getSFTJ(), 0);
		}
		
	}
}
