package service;

import utils.DataBaseUtils;
import bean.QTGZ;

public class QTGZService {
	
	/**
	 * 更新其它规则数据表中数据
	 * @param qtgz
	 */
	public static void updateData(QTGZ qtgz) {
		if(qtgz.getISDEL() == config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			String sql = "update t_qtgz set xm = ? , je = ? where id = ?";			
			DataBaseUtils.update(sql, qtgz.getXM(), qtgz.getJE(), qtgz.getID());

		}else if(qtgz.getISDEL() == config.DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			String sql = "insert into t_qtgz(id,xm,je,fl,isdel) VALUES (?,?,?,?,?)";	
			DataBaseUtils.update(sql, qtgz.getID(), qtgz.getXM(), qtgz.getJE(), qtgz.getFL(), 
					config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);

		}	
	}
	
	
	/**
	 * 查询其它规则中的单条数据
	 * @param op
	 * @return 
	 */
	public QTGZ getDataForBean(String field) {
		String sql = "select * from t_qtgz where mc = ? and isdel = ?";
		return DataBaseUtils.queryForBean(sql, QTGZ.class, field, 
				config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
	}
}
