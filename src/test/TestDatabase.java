package test;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletResponse;

import config.DefalutValue;
import net.sf.json.JSONObject;
import utils.DataBaseUtils;

public class TestDatabase {

	
	public static void main(String[] args) {
		String deleteSQL = "update t_yh set isdel = ? where id  = ?";
		DataBaseUtils.update(deleteSQL, DefalutValue.DEFAULT_DELETE_INT_VALUE, "a038d4b40dbd4f6cb83763e520cbb30f");
	}

}
