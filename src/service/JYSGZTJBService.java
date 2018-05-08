package service;

import java.util.List;
import java.io.IOException;
import utils.DataBaseUtils;
import java.sql.SQLException;
import utils.excelUtils;
import bean.JYSGZTJB;

public class JYSGZTJBService {

		/**
		 * 根据上传文件将数据存入数据库
		 * @param path
		 * @throws IOException
		 * @throws SQLException
		 */
		public void save2DB(String path) throws IOException, SQLException {
			JYSGZTJB jysgztjb = null;
			List<JYSGZTJB > list = excelUtils.analysisExcel(path, JYSGZTJB.class);
			String sql = "insert into t_jysgztjb(id,jysmc,jcxm,qykcxm,sqxxxm,cxktxm,zhggxm,jxmscxxm,sxddjs,"
					+ "wksj,hj,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			for(int i = 0; i < list.size(); i++) {
				jysgztjb = list.get(i);					
				DataBaseUtils.update(sql,jysgztjb.getID(),jysgztjb.getJYSMC(),jysgztjb.getJCXM(),jysgztjb.getQYKCXM(),
						jysgztjb.getSQXXXM(),jysgztjb.getCXKTXM(),jysgztjb.getZHGGXM(),jysgztjb.getJXMSCXXM(),
						jysgztjb.getSXDDJS(),jysgztjb.getWKSJ(),jysgztjb.getHJ(),0);
			}
		}

		
		/**
		 * 更新教研室工作统计表
		 * @param jysgztjb
		 */	
		public void updateData(JYSGZTJB jysgztjb) {
			//System.out.println(jsxljshfwsj.getID());
			//判断前端传过来的数据是否存在于数据库，存在则是更新，否则为新数据则插入
			if(jysgztjb.getISDEL() == 0) {
				String sql = "update t_jysgztjb set jysmc=?, jcxm=?, qykcxm=?, sqxxxm=?,cxktxm=?,zhggxm=?,jxmscxxm=?,"
						+ "sxddjs=?,wksj=?,hj=? where id = ?";
				DataBaseUtils.update(sql,jysgztjb.getJYSMC(),jysgztjb.getJCXM(),jysgztjb.getQYKCXM(),
						jysgztjb.getSQXXXM(),jysgztjb.getCXKTXM(),jysgztjb.getZHGGXM(),jysgztjb.getJXMSCXXM(),
						jysgztjb.getSXDDJS(),jysgztjb.getWKSJ(),jysgztjb.getHJ(),jysgztjb.getID());
		}else if(jysgztjb.getISDEL() == 2){
				String sql = "insert into t_jysgztjb(id,jysmc,jcxm,qykcxm,sqxxxm,cxktxm,zhggxm,jxmscxxm,sxddjs,"
						+ "wksj,hj,isdel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
				DataBaseUtils.update(sql,jysgztjb.getID(),jysgztjb.getJYSMC(),jysgztjb.getJCXM(),jysgztjb.getQYKCXM(),
						jysgztjb.getSQXXXM(),jysgztjb.getCXKTXM(),jysgztjb.getZHGGXM(),jysgztjb.getJXMSCXXM(),
						jysgztjb.getSXDDJS(),jysgztjb.getWKSJ(),jysgztjb.getHJ(),0);
			}	
		}
}
