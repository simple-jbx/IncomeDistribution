package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZRJSRY;
import java.util.UUID;

public class ZRJSRYService {
	/**
	 * 查询本单位奖酬金发放总报表表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_zrjsry where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZRJSRY zrjsry = null;
		List<ZRJSRY > list = excelUtils.analysisExcel(path, ZRJSRY.class);
		
		for(int i = 0; i < list.size(); i++) {
			zrjsry = list.get(i);
			String sql = "insert into t_zrjsry(jys, gh, xm, zc, gwxz, zgqksm,"
		            + "jjmgzlqk, zgsjxs, khgzl, btgzl, bksgzl, yjsgzl, zgzlhj,"
					+"cgzl, xyhycjcs, bkjktj, xyzbcs, cgzljcj, kyjj, rjj,  khyxjj,"
		            +"zhtxgrdfjl, bzxcgjl, jxddbt, dbbt, yxpy, jsxlshfwjj, jthdbthj,"
					+"xyhbt, hfbt, xwgjbt, sjtdebt, cgfzrjlhjtbce, csryjl, hdzjf,"
		            +"dypcjcj, depcrjj, jcjhj, ylbfhkcje, sjzjcj, isdel)"
					+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			DataBaseUtils.update(sql, zrjsry.getJYS(), zrjsry.getGH(), zrjsry.getXM(), zrjsry.getZC(), zrjsry.getGWXZ(),
					zrjsry.getZGQKSM(),zrjsry.getJJMGZLQK(), zrjsry.getZGSJXS(), zrjsry.getKHGZL(), zrjsry.getBTGZL(),
					zrjsry.getBKSGZL(), zrjsry.getYJSGZL(), zrjsry.getZGZLHJ(), zrjsry.getCGZL(), zrjsry.getXYHYCJCS(),
					zrjsry.getBKJKTJ(), zrjsry.getXYZBCS(), zrjsry.getCGZLJCJ(), zrjsry.getKYJJ(), zrjsry.getRJJ(),
					zrjsry.getKHYXJJ(), zrjsry.getZHTXGRDFJL(), zrjsry.getBZXCGJL(), zrjsry.getJXDDBT(), zrjsry.getDBBT(),
					zrjsry.getYXPY(), zrjsry.getJSXLSHFWJJ(), zrjsry.getJTHDBTHJ(), zrjsry.getXYHBT(), zrjsry.getHFBT(),
					zrjsry.getXWGJBT(), zrjsry.getSJTDEBT(), zrjsry.getCGFZRJLhJTBCE(), zrjsry.getCSRYJL(), zrjsry.getHDZJF(),
					zrjsry.getDYPCJCJ(), zrjsry.getDEPCRJJ(), zrjsry.getJCJHJ(), zrjsry.getYLBFHKCJE(), zrjsry.getSJZJCJ(),0);
			}
	}
	
	
	/**
	 * 根据人员代码删除对应数据
	 * @param gH
	 */
	public void deleteByRydm(String Id) {
		String sql = "update t_zrjsry set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, Id);
	}
	
	
	/**
	 * 更新本单位奖酬金发放总报表数据
	 * @param gqry
	 */
	public void updateData(ZRJSRY zrjsry) {
		
		//System.out.println(bdwjcjffzbb.getRYDM());
		String selectSQL = "select * from t_zrjsry where Id = ? and isdel = ?";		
		ZRJSRY selectZRJSRY = DataBaseUtils.queryForBean(selectSQL, ZRJSRY.class, zrjsry.getID(), 0);
		//System.out.print(selectBDWJCJFFZBB);
		if(selectZRJSRY  != null) {
			
			String sql = "update t_zrjsry set jys = ?, gh = ?, xm = ?, zc = ?, gwxz =?, zgqksm = ?"
		            + ", jjmgzlqk = ?, zgsjxs = ?, khgzl = ?, btgzl = ?, bksgzl = ?, yjsgzl = ?, zgzlhj = ?,"
					+"cgzl = ?, xyhycjcs = ?, bkjktj = ?, xyzbcs = ?, cgzljcj = ?, kyjj = ?, rjj = ?,  khyxjj = ?,"
		            +"zhtxgrdfjl = ?, bzxcgjl = ?, jxddbt = ?, dbbt = ?, yxpy = ?, jsxlshfwjj = ?, jthdbthj = ?,"
					+"xyhbt = ?, hfbt = ?, xwgjbt = ?, sjtdebt = ?, cgfzrjlhjtbce = ?, csryjl = ?, hdzjf = ?,"
		            +"dypcjcj = ?, depcrjj = ?, jcjhj = ?, ylbfhkcje = ?, sjzjcj = ?, isdel = ?";
			DataBaseUtils.update(sql, zrjsry.getJYS(), zrjsry.getGH(), zrjsry.getXM(), zrjsry.getZC(), zrjsry.getGWXZ(),
					zrjsry.getZGQKSM(),zrjsry.getJJMGZLQK(), zrjsry.getZGSJXS(), zrjsry.getKHGZL(), zrjsry.getBTGZL(),
					zrjsry.getBKSGZL(), zrjsry.getYJSGZL(), zrjsry.getZGZLHJ(), zrjsry.getCGZL(), zrjsry.getXYHYCJCS(),
					zrjsry.getBKJKTJ(), zrjsry.getXYZBCS(), zrjsry.getCGZLJCJ(), zrjsry.getKYJJ(), zrjsry.getRJJ(),
					zrjsry.getKHYXJJ(), zrjsry.getZHTXGRDFJL(), zrjsry.getBZXCGJL(), zrjsry.getJXDDBT(), zrjsry.getDBBT(),
					zrjsry.getYXPY(), zrjsry.getJSXLSHFWJJ(), zrjsry.getJTHDBTHJ(), zrjsry.getXYHBT(), zrjsry.getHFBT(),
					zrjsry.getXWGJBT(), zrjsry.getSJTDEBT(), zrjsry.getCGFZRJLhJTBCE(), zrjsry.getCSRYJL(), zrjsry.getHDZJF(),
					zrjsry.getDYPCJCJ(), zrjsry.getDEPCRJJ(), zrjsry.getJCJHJ(), zrjsry.getYLBFHKCJE(), zrjsry.getSJZJCJ(),0);
		}else {
			String sql = "insert into t_zrjsry(jys, gh, xm, zc, gwxz, zgqksm,"
		            + "jjmgzlqk, zgsjxs, khgzl, btgzl, bksgzl, yjsgzl, zgzlhj,"
					+"cgzl, xyhycjcs, bkjktj, xyzbcs, cgzljcj, kyjj, rjj,  khyxjj,"
		            +"zhtxgrdfjl, bzxcgjl, jxddbt, dbbt, yxpy, jsxlshfwjj, jthdbthj,"
					+"xyhbt, hfbt, xwgjbt, sjtdebt, cgfzrjlhjtbce, csryjl, hdzjf,"
		            +"dypcjcj, depcrjj, jcjhj, ylbfhkcje, sjzjcj, isdel)"
					+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			DataBaseUtils.update(sql, zrjsry.getJYS(), zrjsry.getGH(), zrjsry.getXM(), zrjsry.getZC(), zrjsry.getGWXZ(),
					zrjsry.getZGQKSM(),zrjsry.getJJMGZLQK(), zrjsry.getZGSJXS(), zrjsry.getKHGZL(), zrjsry.getBTGZL(),
					zrjsry.getBKSGZL(), zrjsry.getYJSGZL(), zrjsry.getZGZLHJ(), zrjsry.getCGZL(), zrjsry.getXYHYCJCS(),
					zrjsry.getBKJKTJ(), zrjsry.getXYZBCS(), zrjsry.getCGZLJCJ(), zrjsry.getKYJJ(), zrjsry.getRJJ(),
					zrjsry.getKHYXJJ(), zrjsry.getZHTXGRDFJL(), zrjsry.getBZXCGJL(), zrjsry.getJXDDBT(), zrjsry.getDBBT(),
					zrjsry.getYXPY(), zrjsry.getJSXLSHFWJJ(), zrjsry.getJTHDBTHJ(), zrjsry.getXYHBT(), zrjsry.getHFBT(),
					zrjsry.getXWGJBT(), zrjsry.getSJTDEBT(), zrjsry.getCGFZRJLhJTBCE(), zrjsry.getCSRYJL(), zrjsry.getHDZJF(),
					zrjsry.getDYPCJCJ(), zrjsry.getDEPCRJJ(), zrjsry.getJCJHJ(), zrjsry.getYLBFHKCJE(), zrjsry.getSJZJCJ(),0);
		}	
	}
}
