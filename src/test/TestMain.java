package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import bean.*;
import utils.*;
import service.*;
import config.DefalutValue;



public class TestMain {
	public static void main(String[] args) {
		String table = TableUtils.getCreateTableSql(KFZYSJK.class);
		//System.out.println(table);
		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
		/**
		long startTime=System.currentTimeMillis(); 
		for(int i = 0; i < 1000000; i++)
		{			
			test.toString();
		}
		long endTime=System.currentTimeMillis(); 
		System.out.println("toJson : " + (endTime-startTime) + "ms");
		
		startTime=System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {	
			test.toJson();
		}
			
		endTime=System.currentTimeMillis();
		//System.out.println(List2JsonUtils.object2JsonString(test));
		System.out.println("API : " + (endTime-startTime) + "ms");
		//**/
		
	}
}
