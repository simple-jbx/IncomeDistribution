package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.GQRY;
public class GQRYService {
	
	/**
	 * 查询工勤人员表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_gqry where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		GQRY gqry = null;
		List<GQRY > list = excelUtils.analysisExcel(path, GQRY.class);
		//System.out.println(list.get(0).getXM());
		for(int i = 0; i < list.size(); i++) {
			gqry = list.get(i);
			String sql = "insert into t_gqry(gh,xm,zb,gw,zgsjxs,zcxs"
		            + ",kqxs,fpxs,nzbzjj,jthdcs,sfpjjl,xypyjl,jthdbt,xyhbt,khjc"
		            + ",dycfpjcjhj,decfpjcjhj,hjje,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, gqry.getGH(), gqry.getXM(), gqry.getZB(), gqry.getGW(), gqry.getZGSJXS(), gqry.getZCXS(), gqry.getKQXS(),
				    gqry.getFPXS(), gqry.getNZBZJJ(), gqry.getJTHDCS(), gqry.getSFPJJL(), gqry.getXYPYJL(), gqry.getJTHDBT(), gqry.getXYHBT(), gqry.getKHJC(),
					gqry.getDYCFPJCJHJ(), gqry.getDECFPJCJHJ(), gqry.getHJJE(), 0);
		}
	}
	
	
	/**
	 * 根据工号删除对应数据
	 * @param gH
	 */
	public void deleteByGh(String gH) {
		String sql = "update t_gqry set isdel = ? where gh = ?";
		DataBaseUtils.update(sql, 1, gH);
	}
	
	
	/**
	 * 更新工勤人员数据
	 * @param gqry
	 */
	public void updateData(GQRY gqry) {
		String selectSQL = "select * from t_gqry where gh = ? and isdel = ?";
		GQRY selectGQRY = DataBaseUtils.queryForBean(selectSQL, GQRY.class, gqry.getGH(), 0);
		if(selectGQRY != null) {
			String sql = "update t_gqry set xm = ?, zb = ?, gw = ?, zgsjxs = ?, zcxs = ?, kqxs = ?, fpxs = ?, nzbzjj = ?,"
					+ "jthdcs = ?, sfpjjl = ?, xypyjl = ?, jthdbt = ?, xyhbt = ?, khjc = ?, hjje = ? where gh = ?";			
			DataBaseUtils.update(sql, gqry.getXM(), gqry.getZB(), gqry.getGW(), gqry.getZGSJXS(), gqry.getZCXS(), gqry.getKQXS(), gqry.getFPXS(),
					gqry.getNZBZJJ(), gqry.getJTHDBT(), gqry.getSFPJJL(), gqry.getXYHBT(), gqry.getJTHDBT(), gqry.getXYHBT(), gqry.getKHJC(), gqry.getHJJE(), gqry.getGH());
		}else {
			String sql = "insert into t_gqry(gh,xm,zb,gw,zgsjxs,zcxs"
		            + ",kqxs,fpxs,nzbzjj,jthdcs,sfpjjl,xypyjl,jthdbt,xyhbt,khjc"
		            + ",dycfpjcjhj,decfpjcjhj,hjje,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, gqry.getGH(), gqry.getXM(), gqry.getZB(), gqry.getGW(), gqry.getZGSJXS(), gqry.getZCXS(), gqry.getKQXS(),
				    gqry.getFPXS(), gqry.getNZBZJJ(), gqry.getJTHDCS(), gqry.getSFPJJL(), gqry.getXYPYJL(), gqry.getJTHDBT(), gqry.getXYHBT(), gqry.getKHJC(),
					gqry.getDYCFPJCJHJ(), gqry.getDECFPJCJHJ(), gqry.getHJJE(), 0);
		}
		
	}
}
