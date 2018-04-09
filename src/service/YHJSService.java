package service;

import java.util.List;
import java.util.Map;

import bean.JS;
import bean.YHJS;
import utils.DataBaseUtils;

public class YHJSService {
	
	
	/**
	 * 查询所有用户的角色
	 * @return
	 */
	public List<Map<String, Object> > getAllYHJS() {
		String sql = "select t_yhjs.yhjsid, t_yhjs.yhid, t_yhjs.isdel, t_yhjs.jsid, t_yh.gh, t_yh.xm,"
				+ " t_js.jsname, t_js.jsgroup from t_yhjs left join t_yh on t_yhjs.yhid = t_yh.id"
				+ " left join t_js on t_yhjs.jsid = t_js.jsid where t_yhjs.isdel = 0";
		//System.out.println(DataBaseUtils.queryForList(sql));
		return DataBaseUtils.queryForList(sql);
		
	}
	
	
	/**
	 * 查询该用户的角色
	 * @return
	 */
	public List<Map<String, Object> > getAllJS() {
		String sql = "select * from t_js where isdel = 0";
		//List<Map<String, Object> > list = DataBaseUtils.queryForList(sql, yhid);
		return DataBaseUtils.queryForList(sql);
		
	}
	
	
	/**
	 * 查询该用户的角色
	 * @return
	 */
	public List<Map<String, Object> > getJSByYhid(String yhid) {
		String sql = "select * from t_js A inner join t_yhjs B"
		+ " where B.yhid = ? and A.jsid = B.jsid";
		return DataBaseUtils.queryForList(sql, yhid);
		
	}
	
	/**
	 * 查询该用户的角色
	 * @return
	 */
	/**public List<Map<String, Object> > getJSByYhid(String yhid) {
		String sql = "select * from t_js A inner join t_yhjs B"
		+ " where B.yhid = ? and A.jsid = B.jsid";
		return DataBaseUtils.queryForList(sql, yhid);
		
	}**/
	
	public List<Map<String, Object> > getJSID(String yhid) {
		String sql = "select * from t_yhjs where yhid = ?";
		return DataBaseUtils.queryForList(sql, yhid);
		
	}
	
	public void updateData(YHJS yhjs, JS js) {
		String sqlYH = "update t_yh set yhgroup = ? where id = ?";			
		if(js.getJSGROUP() == 0 || js.getJSGROUP() == 1) {
			DataBaseUtils.update(sqlYH, js.getJSGROUP(), yhjs.getYHID());
		}else {
			DataBaseUtils.update(sqlYH, -1, yhjs.getYHID());
		}
		if(yhjs.getISDEL() == 0) {
			String sql = "update t_yhjs set yhid = ?, jsid = ? where yhjsid = ?";	
			DataBaseUtils.update(sql, yhjs.getYHID(), yhjs.getJSID(), yhjs.getYHJSID());
		}else if(yhjs.getISDEL() == 2){
			String sql = "insert into t_yhjs(yhjsid,yhid,jsid,isdel)"
		            + " VALUES (?,?,?,?)";	
			DataBaseUtils.update(sql, yhjs.getYHJSID(), yhjs.getYHID(), yhjs.getJSID(), 0);
		}
	}
	
	public void deleteByYhjsid(String Yhjsid, String Yhid) {
		String sql = "update t_yhjs set isdel = ? where yhjsid = ?";
		String sqlYH = "update t_yh set yhgroup = ? where id = ?";
		DataBaseUtils.update(sql, 1, Yhjsid);
		//yhjsgroup -1 非管理员  -2 没有角色
		//DataBaseUtils.update(sqlYH, -2, Yhid);
	}
}
