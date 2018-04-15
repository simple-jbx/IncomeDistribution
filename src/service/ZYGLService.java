package service;

import bean.ZY;
import utils.DataBaseUtils;

public class ZYGLService {
	/**
	 * 更新资源管理表中数据
	 * @param zygl
	 */
	public void updateData(ZY zygl) {
		if(zygl.getISDEL() == 0) {
			String sql = "update t_zy set zyname = ?, zynote = ?, zygroup = ? where id = ?";			
			DataBaseUtils.update(sql, zygl.getZYNAME(), zygl.getZYNOTE(), zygl.getZYGROUP(),
					zygl.getZYID());	
		}else if(zygl.getISDEL() == 2){
			String sql = "insert into t_zy(zyid,zyname,zynote,zygroup,isdel)"
		            +" VALUES (?,?,?,?,?)";	
			DataBaseUtils.update(sql,zygl.getZYID(), zygl.getZYNAME(), zygl.getZYNOTE(), zygl.getZYGROUP(),0);
			
		}
	}
}
