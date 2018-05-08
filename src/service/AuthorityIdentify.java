package service;

import java.util.List;
import java.util.Map;

import bean.YH;
import service.YHJSService;

public class AuthorityIdentify {

	public static int authIdentify(YH currentYH, String tableName) {
		List<Map<String, Object> > aythList = YHJSService.getAuthority(currentYH, tableName);
		//System.out.println(aythList);
		for(Map<String, Object> obj : aythList) {
			if(obj.containsValue("94bc1cff7d524368ac4f8598d5a1e441")) {
				return 1;//所有权限
			}else if(obj.containsValue("5904bf0ab6bf4868b73fb337c08ff21a")) {
				return 2;//查看权限
			}
		}
		return -1;//没有权限
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YH currentYH = new YH();
		currentYH.setRYDM("root");
		authIdentify(currentYH, "ZGSJXS");
	}

}
