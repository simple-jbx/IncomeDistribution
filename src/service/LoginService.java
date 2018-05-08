package service;

import bean.YH;
import utils.DataBaseUtils;

/**
 * 用户登录服务类
 * @author simple
 */

public class LoginService {
	
	public YH getYH(String rydm) {
		String sql = "select * from t_yh where rydm = ? and isdel = ?";
		YH currentYH = DataBaseUtils.queryForBean(sql, YH.class, rydm, 0);
		return currentYH;
	}
}
