package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.KYCGJCSJK;

public class KYCGJCSJKService {
	
	private final static String insertSQL = "insert into t_kycgjcsjk(id,gh,xm,lwfs,xmfs,zzfs,zlfs"
			+"isdel) VALUES (?,?,?,?,?,?,?,?)";
	
	private final static String updateSQL = "update t_kycgjcsjk set gh = ?, xm = ?, lwfs = ?, xmfs = ?, zzfs = ?,"
			+ "zlfs = ? where id = ?";			
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		KYCGJCSJK kycgjcsjk = null;
		List<KYCGJCSJK > dataList = excelUtils.analysisExcel(path, KYCGJCSJK.class);
		int listSize = 0;
		if(dataList != null)
			listSize = dataList.size();
		for(int i = 0; i < listSize; i++) {
			kycgjcsjk = dataList.get(i);				
			DataBaseUtils.update(insertSQL, kycgjcsjk.getID(), kycgjcsjk.getRYDM(), kycgjcsjk.getXM(),
					kycgjcsjk.getLWFS(), kycgjcsjk.getXMFS(), kycgjcsjk.getZZFS(), kycgjcsjk.getZLFS(), 0);
		}
	}
	
	
	/**
	 * 更新科研成果基础数据库
	 * @param elylxydhkq
	 */
	public void updateData(KYCGJCSJK kycgjcsjk) {
		if(kycgjcsjk.getISDEL() == 0) {
			DataBaseUtils.update(updateSQL, kycgjcsjk.getRYDM(), kycgjcsjk.getXM(), kycgjcsjk.getLWFS(), 
					kycgjcsjk.getXMFS(), kycgjcsjk.getZZFS(), kycgjcsjk.getZLFS(), kycgjcsjk.getID());
		}else if(kycgjcsjk.getISDEL() == 2){
			DataBaseUtils.update(insertSQL, kycgjcsjk.getID(), kycgjcsjk.getRYDM(), kycgjcsjk.getXM(),
					kycgjcsjk.getLWFS(), kycgjcsjk.getXMFS(), kycgjcsjk.getZZFS(), kycgjcsjk.getZLFS(), 0);
		}	
	}
}
