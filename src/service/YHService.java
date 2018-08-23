package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.sql.SQLException;

import utils.DataBaseUtils;
import utils.excelUtils;
import config.DefalutValue;
import bean.YH;
import utils.SHA1Utils;

public class YHService {
	
	private final static String GET_ALL_YH_SQL =  "select id, rydm, xm, zc from t_yh where isdel = ?";
	private final static String GET_YH_SQL = "select id, rydm, xm, zc from t_yh where rydm = ? and isdel = ?";
	private final static String GET_YH_ALL_SQL = "select id, rydm, xm, zc, mm, isdel from t_yh where rydm = ? and isdel = ?";
	private final static String UPDATE_YH_SQL = "update t_yh set rydm = ?, xm = ?, zc = ?  where id = ?";
	private final static String INSERT_SQL = "insert into t_yh(id,rydm,xm,mm,zc,isdel) VALUES (?,?,?,?,?,?)";
	private final static String CHANGE_PASSWORD_SQL = "update t_yh set mm = ? where rydm = ? and isdel = ?";


	
	/**
	 * 查询用户表中所有数据
	 * @return
	 */
	public static List<Map<String, Object> > getALLYH() {
		return DataBaseUtils.queryForList(GET_ALL_YH_SQL, DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
	}
	
	
	public static YH getYH(String rYDM) {
		return DataBaseUtils.queryForBean(GET_YH_SQL, YH.class, rYDM, DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
	}
	
	public YH getYHAll(String rYDM) {
		return DataBaseUtils.queryForBean(GET_YH_ALL_SQL, YH.class, rYDM, DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		YH yh = null;
		List<YH > objectList = excelUtils.analysisExcel(path, YH.class);
		int listSize = 0;
		if(objectList != null)
			listSize = objectList.size();
		for(int i = 0; i < listSize; i++) {
			yh = objectList.get(i);
			DataBaseUtils.update(INSERT_SQL, yh.getID(), yh.getRYDM(), yh.getXM(), SHA1Utils.sha1Encode(yh.getRYDM()),
					yh.getZC(), DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新用户数据
	 * @param zgsjxsgz
	 */
	public static void updateData(YH yh) {
		
		if(yh.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(UPDATE_YH_SQL, yh.getRYDM(), yh.getXM(), yh.getZC() , yh.getID());
		}else if(yh.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(INSERT_SQL, yh.getID(), yh.getRYDM(), yh.getXM(), SHA1Utils.sha1Encode(yh.getRYDM()),
					yh.getZC(), 0);
		}
	}


	public static void resetPassword(YH changeYH) {
			DataBaseUtils.update(CHANGE_PASSWORD_SQL, SHA1Utils.sha1Encode(changeYH.getRYDM()), changeYH.getRYDM(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
	}
	
	
	/**
	 * 批量更新
	 * @param listObject
	 */
	public static void updateData(List<YH> listObject) {
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		YH updateObject = new YH();
		for(int i = 0; i < listSize; i++) {
			updateObject = listObject.get(i);
			updateData(updateObject);
		}
	}
}
