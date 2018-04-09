package service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.XWGJBTSJK;

public class XWGJBTSJKService {
	
	/**
	 * 查询新闻稿件补贴表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_xwgjbtsjk where isdel = ?";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		XWGJBTSJK xwgjbtsjk = null;
		List<XWGJBTSJK > list = excelUtils.analysisExcel(path, XWGJBTSJK.class);
		String sql = "insert into t_xwgjbtsjk(id,rydm,xm,xwgjbt,hj,isdel) VALUES (?,?,?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			xwgjbtsjk = list.get(i);
			DataBaseUtils.update(sql, UUID.randomUUID().toString(), xwgjbtsjk.getRYDM(), xwgjbtsjk.getXM(),
					xwgjbtsjk.getXWGJBT(), xwgjbtsjk.getHJ(), 0);
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param ID
	 */
	public void deleteByID(String ID) {
		String sql = "update t_xwgjbtsjk set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新新闻稿件补贴数据数据
	 * @param xwgjbtsjk
	 */
	public void updateData(XWGJBTSJK xwgjbtsjk) {
		//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
		if(xwgjbtsjk.getISDEL() == 0) {
			String sql = "update t_xwgjbtsjk set rydm = ?, xm = ?, xwgjbt = ?, hj = ? where id = ?";
			DataBaseUtils.update(sql,xwgjbtsjk.getRYDM(),xwgjbtsjk.getXM(),xwgjbtsjk.getXWGJBT(),
					xwgjbtsjk.getHJ(), xwgjbtsjk.getID());
		}else if(xwgjbtsjk.getISDEL() == 2){
			String sql = "insert into t_xwgjbtsjk(id,rydm,xm,xwgjbt,hj,isdel)"
		            + " VALUES (?,?,?,?,?,?)";
			DataBaseUtils.update(sql,xwgjbtsjk.getID(),xwgjbtsjk.getRYDM(),
					xwgjbtsjk.getXM(), xwgjbtsjk.getXWGJBT(), xwgjbtsjk.getHJ(),0);
		}	
	}
}
