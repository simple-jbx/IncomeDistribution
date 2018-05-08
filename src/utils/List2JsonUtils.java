package utils;

import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;

public class List2JsonUtils {
	
	public static String list2Json2String(List<Map<String, Object> > listOfObject) {	 
		 return JSON.toJSON(listOfObject).toString();	 
	}
	
	/**
	 * 根据测试结果API方法较直接在类中实现的方法慢
	 * @param obj
	 * @return
	 */
	public static String object2JsonString(Object obj) {
		return JSON.toJSONString(obj);
	}
	
	public static void main(String[] args) {
	}
}
