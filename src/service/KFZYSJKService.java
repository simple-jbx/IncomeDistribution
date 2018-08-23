package service;

import java.util.List;

import bean.KFZYSJK;
import config.DefalutValue;
import utils.DataBaseUtils;

public class KFZYSJKService {
	
	private final static String INSERT_SQL = "insert into t_kfzysjk(id,zyid,zymc,kfsj0,kfsj1,kfnx,isdel"
			+ "nd,isdel) values (?,?,?,?,?,?,?)";
	private final static String UPDATE_SQL = "update t_kfzysjk set zyid = ?, zymc = ?, kfsj0 = ?, kfsj1 = ?,"
			+ " kfnx = ? where id = ?";
	
	/**
	 * 更新
	 * @param updateObject
	 */
	public static void updateData(KFZYSJK updateObject) {
		if(updateObject.getISDEL() == DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
			DataBaseUtils.update(UPDATE_SQL,updateObject.getZYID(), updateObject.getZYMC(), updateObject.getKFSJ0(),
					updateObject.getKFSJ1(), updateObject.getKFNX(), updateObject.getID());
		}else if(updateObject.getISDEL() == DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(INSERT_SQL,updateObject.getID(), updateObject.getZYID(), updateObject.getZYMC(), 
					updateObject.getKFSJ0(), updateObject.getKFSJ1(), updateObject.getKFNX(), 
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE, updateObject.getID());
		}	
	}
	
	
	
	/**
	 * 批量更新
	 * @param listObject
	 */
	public static void updateData(List<KFZYSJK> listObject) {
		int listSize = 0;
		if(listObject != null)
			listSize = listObject.size();
		KFZYSJK updateObject = new KFZYSJK();
		for(int i = 0; i < listSize; i++) {
			updateObject = listObject.get(i);
			updateData(updateObject);
		}
	}

}
