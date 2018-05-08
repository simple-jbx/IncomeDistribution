package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.YH;
import utils.DataBaseUtils;
import config.DefalutValue;

public class YHJSService {
	
	private final static String GET_ALL_YHJS_BY_YHID_SQL = "select t_yhjs.yhjsid, t_yhjs.yhrydm, t_yhjs.jsid,"
			+ " t_yhjs.yhjsnote, t_js.jsname from t_yhjs left join t_yh on t_yhjs.yhrydm = t_yh.rydm"
			+ " left join t_js on t_yhjs.jsid = t_js.jsid where t_yhjs.yhrydm = ? and t_yhjs.isdel = 0";
	
	private final static String GET_ALL_ZY_BY_JSID_SQL = "select t_zy.zyid, t_zy.zyname, t_zy.zynote"
			+ " from t_zy left join t_jszy on t_zy.zyid = t_jszy.zyid left join t_js on t_js.jsid = t_jszy.jsid"
			+ " where t_js.jsid = ? and t_zy.isdel = 0";
	
	private final static String GET_AUTHORITY_BY_JSID_AND_TABLENAME = "select * from t_jsqx where jsid = ? and zyname = ? and isdel = ?";
	
	
	public static List<Map<String, Object> > getAuthority (YH currentYH, String tableName) {
		List<Map<String, Object>> jsqxList = new ArrayList<Map<String, Object> >();
		List<Map<String, Object>> newJSQXList = new ArrayList<Map<String, Object> >();
		List<Map<String, Object> > jsList = getAllJSByRYDM(currentYH);
		
		for(Map<String, Object> obj : jsList) {
			jsqxList.addAll(DataBaseUtils.queryForList(GET_AUTHORITY_BY_JSID_AND_TABLENAME, obj.get("jsid"), 
					tableName, DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE));
		}
		
		for(Map<String, Object> obj : jsqxList) {
			if(!newJSQXList.contains(obj))
				newJSQXList.add(obj);
		}
		return newJSQXList;
	}
	
	
	/**
	 * 查询该用户所有的角色
	 * @return
	 */
	public static List<Map<String, Object> > getAllJSByRYDM(YH queryYH) {
		List<Map<String, Object> > jsList = DataBaseUtils.queryForList(GET_ALL_YHJS_BY_YHID_SQL, queryYH.getRYDM());
		List<Map<String, Object> > newJSList = new ArrayList<Map<String, Object>>();
		//角色去重
		for(Map<String, Object> obj : jsList) {
			if(!newJSList.contains(obj))
				newJSList.add(obj);
		}
		return newJSList;
	}
	
	
	/**
	 * 查询角色所拥有的资源
	 */
	private static List<Map<String, Object> > getZYByJSID(String jSID) {
		return DataBaseUtils.queryForList(GET_ALL_ZY_BY_JSID_SQL, jSID);
	}
	
	
	/**
	 * 查询该用户所拥有的资源
	 * @param 
	 */
	public static List<Map<String, Object> > getAllZYByRYDM(YH queryYH) {
		List<Map<String, Object> > jsList = getAllJSByRYDM(queryYH);
		List<Map<String, Object> > jsZY = new ArrayList<Map<String, Object>>();
		List<Map<String, Object> > newJSZY = new ArrayList<Map<String, Object>>();
		
		for(Map<String, Object> obj : jsList) {
			jsZY.addAll(getZYByJSID(obj.get("jsid").toString()));
		}
		
		//资源去重
		for(Map<String, Object> obj : jsZY) {
			if(!newJSZY.contains(obj))
				newJSZY.add(obj);
		}
		return newJSZY;
	}
	
	
	public static void main(String[] args) {
		YH yh = new YH();
		yh.setRYDM("41512241");
		List<Map<String, Object> > list = getAllJSByRYDM(yh);
		System.out.println(list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
