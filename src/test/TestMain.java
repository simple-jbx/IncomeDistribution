package test;

import java.util.UUID;
import bean.*;
import utils.TableUtils;
import service.*;


public class TestMain {
	public static void main(String[] args) {
		String table = TableUtils.getCreateTableSql(JTHDKQSJK.class);
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		//YHJSService test = new YHJSService();
		//System.out.println(test.getJS("81773dd602704857b9a131506feed735"));
	}
}
