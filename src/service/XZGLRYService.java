package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XZGLRY;

public class XZGLRYService {
	
	/**
	 * 查询行政管理人员表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_xzglry where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XZGLRY xzglry = null;
		List<XZGLRY > list = excelUtils.analysisExcel(path, XZGLRY.class);
		for(int i = 0; i < list.size(); i++) {
			xzglry = list.get(i);
			String sql = "insert into t_xzglry(dw,gh,xm,zgsjxs,zwxs,kqxs,bzxs,qydhcs,xyzbcs,"
		            + "bkjktj,xzpjj,xypjj,jthdbt,xyhbt,xwgjbt,hfbt,bzxcgjl,xxkhyxjl,xypyjl,"
		            + "hdzjf,jxdd,khjc,dypcjcj,depcjcj,jcjhj,ylbfhkcje,sjzjcj,isdel) "
		            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, xzglry.getDW(), xzglry.getGH(), xzglry.getXM(), xzglry.getZGSJXS(),
					xzglry.getZWXS(), xzglry.getKQXS(), xzglry.getBZXS(), xzglry.getQYDHCS(), xzglry.getXYZBCS(),
					xzglry.getBKJKTJ(), xzglry.getXZPJJ(), xzglry.getXYPJJ(), xzglry.getJTHDBT(), xzglry.getXYHBT(),
					xzglry.getXWGJBT(), xzglry.getHFBT(), xzglry.getBZXCGJL(), xzglry.getXXKHYXJL(), xzglry.getXYPYJL(),
					xzglry.getHDZJF(), xzglry.getJXDD(), xzglry.getKHJC(), xzglry.getDYPCJCJ(), xzglry.getDEPCJCJ(), 
					xzglry.getJCJHJ(), xzglry.getYLBFHKCJE(), xzglry.getSJZJCJ(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_xzglry set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新行政管理人员数据
	 * @param xzglry
	 */
	public void updateData(XZGLRY xzglry) {
		String selectSQL = "select * from t_xzglry where id = ? and isdel = ?";
		XZGLRY selectXZGLRY = DataBaseUtils.queryForBean(selectSQL, XZGLRY.class, xzglry.getID(), 0);

		if(selectXZGLRY != null) {
			String sql = "update t_xzglry set dw = ?, gh = ?, xm = ?, zgsjxs = ?, zwxs = ?,"
					+ "kqxs = ?, bzxs = ?, qydhcs = ?, xyzbcs = ?, bkjktj = ?, xzpjj = ?,"
					+ "xypjj = ?, jthdbt = ?, xyhbt = ?, xwgjbt = ?, hfbt = ?, bzxcgjl = ?,"
					+ "xxkhyxjl = ?, xypyjl = ?, hdzjf = ?, jxdd = ?, khjc = ?, dypcjcj = ?"
					+ "depcjcj = ?, jcjhj = ?, ylbfhkcje = ?, sjzjcj = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, xzglry.getDW(), xzglry.getGH(), xzglry.getXM(), xzglry.getZGSJXS(),
					xzglry.getZWXS(), xzglry.getKQXS(), xzglry.getBZXS(), xzglry.getQYDHCS(), xzglry.getXYZBCS(),
					xzglry.getBKJKTJ(), xzglry.getXZPJJ(), xzglry.getXYPJJ(), xzglry.getJTHDBT(), xzglry.getXYHBT(),
					xzglry.getXWGJBT(), xzglry.getHFBT(), xzglry.getBZXCGJL(), xzglry.getXXKHYXJL(), xzglry.getXYPYJL(),
					xzglry.getHDZJF(), xzglry.getJXDD(), xzglry.getKHJC(), xzglry.getDYPCJCJ(), xzglry.getDEPCJCJ(), 
					xzglry.getJCJHJ(), xzglry.getYLBFHKCJE(), xzglry.getSJZJCJ(), xzglry.getID(), 0);
		}else {
			String sql = "insert into t_xzglry(dw,gh,xm,zgsjxs,zwxs,kqxs,bzxs,qydhcs,xyzbcs,"
		            + "bkjktj,xzpjj,xypjj,jthdbt,xyhbt,xwgjbt,hfbt,bzxcgjl,xxkhyxjl,xypyjl,"
		            + "hdzjf,jxdd,khjc,dypcjcj,depcjcj,jcjhj,ylbfhkcje,sjzjcj,isdel) "
		            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, xzglry.getDW(), xzglry.getGH(), xzglry.getXM(), xzglry.getZGSJXS(),
					xzglry.getZWXS(), xzglry.getKQXS(), xzglry.getBZXS(), xzglry.getQYDHCS(), xzglry.getXYZBCS(),
					xzglry.getBKJKTJ(), xzglry.getXZPJJ(), xzglry.getXYPJJ(), xzglry.getJTHDBT(), xzglry.getXYHBT(),
					xzglry.getXWGJBT(), xzglry.getHFBT(), xzglry.getBZXCGJL(), xzglry.getXXKHYXJL(), xzglry.getXYPYJL(),
					xzglry.getHDZJF(), xzglry.getJXDD(), xzglry.getKHJC(), xzglry.getDYPCJCJ(), xzglry.getDEPCJCJ(), 
					xzglry.getJCJHJ(), xzglry.getYLBFHKCJE(), xzglry.getSJZJCJ(), 0);
		}
		
	}
}
