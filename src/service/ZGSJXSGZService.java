package service;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.ZGSJXSGZ;

public class ZGSJXSGZService {
	
	/**
	 * 查询在岗时间系数规则表中所有数据
	 * @return
	 */
	public List<Map<String, Object> > getData() {
		String sql = "select * from t_zgsjxsgz where isdel = ? order by zgys asc";
		return DataBaseUtils.queryForList(sql, 0);
	}
	
	
	/**
	 * 根据上传文件将数据存入数据库
	 * @param path
	 * @throws IOException
	 * @throws SQLException
	 */
	public void save2DB(String path) throws IOException, SQLException {
		ZGSJXSGZ zgsjxsgz = null;
		List<ZGSJXSGZ > list = excelUtils.analysisExcel(path, ZGSJXSGZ.class);
		String sql = "insert into t_zgsjxsgz(id,zgys,zgxs,isdel) VALUES (?,?,?,?)";	
		for(int i = 0; i < list.size(); i++) {
			zgsjxsgz = list.get(i);
			DataBaseUtils.update(sql, zgsjxsgz.getID(), zgsjxsgz.getZGYS(), zgsjxsgz.getZGXS(), zgsjxsgz.getISDEL());
		}
	}
	
	
	/**
	 * 根据ID删除对应数据
	 * @param gH
	 */
	public void deleteByID(String ID) {
		String sql = "update t_zgsjxsgz set isdel = ? where id = ?";
		DataBaseUtils.update(sql, 1, ID);
	}
	
	
	/**
	 * 更新获奖数据
	 * @param zgsjxsgz
	 */
	public void updateData(ZGSJXSGZ zgsjxsgz) {
		if(zgsjxsgz.getISDEL() == 0) {
			String sql = "update t_zgsjxsgz set zgys = ?, zgxs = ? where id = ? and isdel = ?";			
			DataBaseUtils.update(sql, zgsjxsgz.getZGYS(), zgsjxsgz.getZGXS(), zgsjxsgz.getID(),
					zgsjxsgz.getISDEL());

		}else if(zgsjxsgz.getISDEL() == 2){
			String sql = "insert into t_elylxydhkq(jlmc,cgmc,hjzz,zzpx,fzjg,hjrq"
		            + ",xxsm,hjjb,hjdj,dwpm,sftj,shzt,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";	
			DataBaseUtils.update(sql, zgsjxsgz.getID(), zgsjxsgz.getZGYS(), zgsjxsgz.getZGXS(), 0);

		}
		
	}
}
