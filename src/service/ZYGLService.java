package service;

import bean.ZY;
import utils.DataBaseUtils;
import config.DefalutValue;

public class ZYGLService {
	
	private final static String updateSQL = "update t_zy set zyname = ?, zynote = ?, zygroup = ? where zyid = ?";			

	private final static String insertSQL = "insert into t_zy(zyid,zyname,zynote,zygroup,isdel)"
            +" VALUES (?,?,?,?,?)";	
	
	/**
	 * 更新资源管理表中数据
	 * @param zygl
	 */
	public void updateData(ZY zygl) {
		if(zygl.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(updateSQL, zygl.getZYNAME(), zygl.getZYNOTE(), zygl.getZYGROUP(),
					zygl.getZYID());	
		}else if(zygl.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(insertSQL,zygl.getZYID(), zygl.getZYNAME(), zygl.getZYNOTE(), zygl.getZYGROUP(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
			
		}
	}
}
