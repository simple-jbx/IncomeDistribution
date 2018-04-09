package utils;

import java.util.List;
import java.util.Map;
import service.GQRYService;
import com.alibaba.fastjson.JSON;

public class List2JsonUtils {
	public static String list2Json2String(List<Map<String, Object> > list) {
		 String json = JSON.toJSON(list).toString();
		 return json;		 
	}
	
	public static void main(String[] args) {
		GQRYService gqryService = new GQRYService();
		List<Map<String, Object> > list = gqryService.getData();
		//System.out.println(list);
		String json = List2JsonUtils.list2Json2String(list);
		System.out.println(json);
	}
}
