package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ELYLBZXCG;

public class ELYLBZXCGService {
	
	/**
	 * 查询2016标志性成果表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_elylbzxcg where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ELYLBZXCG elylbzxcg = null;
		List<ELYLBZXCG > list = excelUtils.analysisExcel(path, ELYLBZXCG.class);
		for(int i = 0; i < list.size(); i++) {
			elylbzxcg = list.get(i);
			String sql = "insert into t_elylbzxcg(cgmc,cgjb,xm,cgpm,bl,zje"
		            + ",je,isdel) VALUES (?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, elylbzxcg.getCGMC(), elylbzxcg.getCGJB(), elylbzxcg.getXM(),
					elylbzxcg.getCGPM(), elylbzxcg.getBL(), elylbzxcg.getZJE(), elylbzxcg.getJE(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_elybzxcg set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新2016标志性成果数据
	 * @param elylbzxcg
	 */
	public void updateData(ELYLBZXCG elylbzxcg) {
		String selectSQL = "select * from t_elylbzxcg where id = ? and isdel = ?";
		ELYLBZXCG selectELYLBZXCG = DataBaseUtils.queryForBean(selectSQL, ELYLBZXCG.class, elylbzxcg.getID(), 0);

		if(selectELYLBZXCG != null) {
			String sql = "update t_elylxydhkq set cgmc = ?, cgjb = ?, xm = ?, cgpm = ?, bl = ?, zje = ?,"
					+ "je = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, elylbzxcg.getCGMC(), elylbzxcg.getCGJB(), elylbzxcg.getXM(),
					elylbzxcg.getCGPM(), elylbzxcg.getBL(), elylbzxcg.getZJE(), elylbzxcg.getJE(), elylbzxcg.getID(), 0);
		}else {
			String sql = "insert into t_elylbzxcg(cgmc,cgjb,xm,cgpm,bl,zje"
		            + ",je,isdel) VALUES (?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, elylbzxcg.getCGMC(), elylbzxcg.getCGJB(), elylbzxcg.getXM(),
					elylbzxcg.getCGPM(), elylbzxcg.getBL(), elylbzxcg.getZJE(), elylbzxcg.getJE(), 0);
		}
		
	}
}
