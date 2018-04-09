package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XM;

public class XMService {
	/**
	 * 查询本项目表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_xm where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XM xm = null;
		List<XM > list = excelUtils.analysisExcel(path, XM.class);
		
		for(int i = 0; i < list.size(); i++) {
			xm = list.get(i);
			String sql = "insert into t_xm(xmmc,fzr,xmcy,zzsx,zzpx,xmxz"
		            + ",xmfl,xmjb,lxrq,htjf,xmly,sftj,shzt,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, xm.getXMMC(), xm.getFZR(), xm.getXMCY(), xm.getZZSX(), xm.getXMFL(),
					xm.getXMJB(), xm.getLXRQ(), xm.getHTJF(), xm.getXMLY(), xm.getSFTJ(), xm.getSHZT(), 0);
			}
	}
	
	
	/**
	 * 根据人员代码删除对应数据
	 * @param gH
	 */
	public void deleteByRydm(String id) {
		String sql = "update t_xm set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, id);
	}
	
	
	/**
	 * 更新本单位奖酬金发放总报表数据
	 * @param gqry
	 */
	public void updateData(XM xm) {
		
		//System.out.println(bdwjcjffzbb.getRYDM());
		String selectSQL = "select * from t_xm where id = ? and isdel = ?";		
		XM selectXM = DataBaseUtils.queryForBean(selectSQL, XM.class, xm.getID(), 0);
		//System.out.print(selectBDWJCJFFZBB);
		if(selectXM != null) {
			
			String sql = "update t_xm set xmmc = ?, fzr = ?, xmcy = ?, zzsx = ?, zzpx = ?, xmxz = ?"
		            + ", xmfl = ?, xmjb = ?, lxrq = ?, htjf = ?, xmly = ?, sftj = ?, shzt = ? where id = ? and isdel = ?";
			DataBaseUtils.update(sql,  xm.getXMMC(), xm.getFZR(), xm.getXMCY(), xm.getZZSX(), xm.getXMFL(),
					xm.getXMJB(), xm.getLXRQ(), xm.getHTJF(), xm.getXMLY(), xm.getSFTJ(), xm.getSHZT(), xm.getID(), 0);
		}else {
			String sql = "insert into t_xm(xmmc,fzr,xmcy,zzsx,zzpx,xmxz"
		            + ",xmfl,xmjb,lxrq,htjf,xmly,sftj,shzt,isdel)"
		            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, xm.getXMMC(), xm.getFZR(), xm.getXMCY(), xm.getZZSX(), xm.getXMFL(),
					xm.getXMJB(), xm.getLXRQ(), xm.getHTJF(), xm.getXMLY(), xm.getSFTJ(), xm.getSHZT(), 0);
			}
		}	
}
