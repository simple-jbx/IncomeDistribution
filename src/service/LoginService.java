package service;

import bean.YH;
import utils.DataBaseUtils;

/**
 * 用户登录服务类
 * @author simple
 */
public class LoginService {
	
	public YH getYH(String gh) {
		String sql = "select * from t_yh where gh = ?";
		YH yh = DataBaseUtils.queryForBean(sql, YH.class, gh);
		//System.out.println(gh);
		if(yh == null)
			return null;
		return yh;
	}
}
