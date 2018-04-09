package service;

import java.util.List;
import java.util.Map;
import bean.JSZY;
import utils.DataBaseUtils;

public class JSZYService {

	/**
	 * 查询该角色所拥有所有的资源
	 * @return
	 */
	public List<Map<String, Object> > getAllZY(String jsid) {
		String sql = "select A.zyid, A.zyname, A.zynote, A.zygroup from t_zy A inner join t_jszy  B"
				+ " where B.jsid = ? and A.zyid = B.zyid";
		//List<Map<String, Object> > listZY = DataBaseUtils.queryForList(sql,jsid);
		//System.out.println(listZY);
	    return DataBaseUtils.queryForList(sql,jsid);
	}
	
	/**
	 * 查询所有的角色资源
	 * @return
	 */
	public List<Map<String, Object> > getAllJSZY() {
		String sql = "select t_jszy.jszyid, t_jszy.jsid, t_jszy.zyid, t_jszy.isdel, t_zy.zynote, t_js.jsname from t_jszy "
				+ "left join t_zy on t_jszy.zyid = t_zy.zyid left join t_js on t_jszy.jsid = t_js.jsid where t_jszy.isdel = 0";
		//System.out.println(DataBaseUtils.queryForList(sql));
		return DataBaseUtils.queryForList(sql);
		
	}
	
	
	/**
	 * 修改数据
	 * @param jszy
	 */
	public void updateData(JSZY jszy) {
		if(jszy.getISDEL() == 0) {
			String sql = "update t_jszy set jsid = ?, zyid = ? where jszyid = ?";			
			DataBaseUtils.update(sql, jszy.getJSID(), jszy.getZYID(), jszy.getJSZYID());
		}else if(jszy.getISDEL() == 2){
			String sql = "insert into t_jszy(jszyid,jsid,zyid,isdel)"
		            + " VALUES (?,?,?,?)";	
			DataBaseUtils.update(sql, jszy.getJSZYID(), jszy.getJSID(), jszy.getZYID(), 0);
		}
	}
	
	
	public void deleteByJszyid(String Jszyid) {
		String sql = "update t_jszy set isdel = ? where jszyid = ?";
		DataBaseUtils.update(sql, 1, Jszyid);
	}
}
