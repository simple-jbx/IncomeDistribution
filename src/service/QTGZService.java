package service;

import java.util.List;
import java.util.Map;
import utils.DataBaseUtils;
import bean.QTGZ;

public class QTGZService {
	
	/**
	 * 查询其他规则表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_qtgz where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param ID
	 */
	public void deleteByID(String ID) {
		String sql = "update t_qtgz set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新其它规则数据表中数据
	 * @param qtgz
	 */
	public void updateData(QTGZ qtgz) {
		if(qtgz.getISDEL() == 0) {
			String sql = "update t_qtgz set xm = ? , je = ? where id = ?";			
			DataBaseUtils.update(sql, qtgz.getXM(), qtgz.getJE(), qtgz.getID());

		}else if(qtgz.getISDEL() == 2){
			String sql = "insert into t_qtgz(id,xm,je,fl,isdel) VALUES (?,?,?,?,?)";	
			DataBaseUtils.update(sql, qtgz.getID(), qtgz.getXM(), qtgz.getJE(), qtgz.getFL(), 0);

		}	
	}
	
	
	/**
	 * 查询其它规则中的单条数据
	 * @param op
	 * @return 
	 */
	public QTGZ getDataForBean(String op) {
		String sql = "select * from t_qtgz where mc = ? and isdel = ?";
		return DataBaseUtils.queryForBean(sql, QTGZ.class, op, 0);
	}
}
