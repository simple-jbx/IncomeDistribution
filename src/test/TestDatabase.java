package test;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import utils.DataBaseUtils;

public class TestDatabase {

	 private static void returnResultJson(Object obj) {  
	        JSONObject resultmessage = JSONObject.fromObject(obj);  	           
	        System.out.println(resultmessage.toString());  
	    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		returnResultJson("{1:1}");
	}

}
