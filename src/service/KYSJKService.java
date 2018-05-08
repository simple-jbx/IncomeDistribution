package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import config.DefalutValue;
import bean.KYSJK;
import utils.DataBaseUtils;
import utils.excelUtils;

/**
 * 科研数据库
 * @author simple
 *
 */
public class KYSJKService {
	
	private final static String insertSQL = "insert into t_kysjk(id,rydm,xm,zc,lwdf,xmdf,zzdf,zldf,dfhj,bzf,cefz,kyjcfs,"
			+ "cejdf,kyjcjj,kycejj,kyjlhj,nd,isdel)"
            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private final static String updateSQL = "update t_kysjk set rydm=?,xm=?,lwdf=?,xmdf=?,zzdf=?,zldf=?,dfhj=?,bzf=?,"
			+ "cefz=?,kyjcfz=?,cejdfz=?,kyjcjj=?,kycejj=?,kyjlhj=?,nd=? where id = ?";
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		KYSJK updateObject = null;
		int listSize = 0;
		List<KYSJK > dataList = excelUtils.analysisExcel(path, KYSJK.class);
		if(dataList != null)
			listSize = dataList.size();
		for(int i = 0; i < listSize; i++) {
			updateObject = dataList.get(i);					
			DataBaseUtils.update(insertSQL,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getZC(),updateObject.getLWDF(),updateObject.getXMDF(),updateObject.getZZDF(),
					updateObject.getZLDF(),updateObject.getDFHJ(),updateObject.getBZF(),updateObject.getCEFZ(),
					updateObject.getKYJCFS(),updateObject.getCEJDF(),updateObject.getKYJCJJ(),
					updateObject.getKYCEJJ(),updateObject.getKYJLHJ(),updateObject.getND(),
					DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}
	}
	
	
	/**
	 * 更新科研数据
	 * @param updateObject
	 */	
	public void updateData(KYSJK updateObject) {
		if(updateObject.getISDEL() == config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE) {
				DataBaseUtils.update(updateSQL,updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getZC(),updateObject.getLWDF(),updateObject.getXMDF(),updateObject.getZZDF(),
					updateObject.getZLDF(),updateObject.getDFHJ(),updateObject.getBZF(),updateObject.getCEFZ(),
					updateObject.getKYJCFS(),updateObject.getCEJDF(),updateObject.getKYJCJJ(),
					updateObject.getKYCEJJ(),updateObject.getKYJLHJ(),updateObject.getND(),
					updateObject.getID());
		}else if(updateObject.getISDEL() == config.DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE){
			DataBaseUtils.update(insertSQL,updateObject.getID(),updateObject.getRYDM(),updateObject.getXM(),
					updateObject.getZC(),updateObject.getLWDF(),updateObject.getXMDF(),updateObject.getZZDF(),
					updateObject.getZLDF(),updateObject.getDFHJ(),updateObject.getBZF(),updateObject.getCEFZ(),
					updateObject.getKYJCFS(),updateObject.getCEJDF(),updateObject.getKYJCJJ(),
					updateObject.getKYCEJJ(),updateObject.getKYJLHJ(),updateObject.getND(),
					config.DefalutValue.DEFAULT_NOT_DELETE_INT_VALUE);
		}	
	}
}
