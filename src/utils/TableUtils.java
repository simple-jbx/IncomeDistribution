package utils;
import java.lang.reflect.Field;
import annotation.Column;
import annotation.Table;

public class TableUtils {
	public static String getCreateTableSql(Class<?> clazz){
		StringBuilder sb = new StringBuilder();
		Table table = (Table) clazz.getAnnotation(Table.class);
		
		//获取表名
		String tableName = table.tableName();
		//获取表注释
		String tableComment = table.tableComment();
		sb.append("drop table if exists ").append(tableName).append(";\n");
		sb.append("create table ");
		sb.append(tableName).append("(\n");
		
		Field[] fields = clazz.getDeclaredFields();
		String primaryKey = "";
		//遍历所有字段
		for(int i = 0; i < fields.length; i++){
			Column column = (Column) fields[i].getAnnotations()[0];
			String field = column.field();
			String type = column.type();
			String comment = column.comment();
			boolean defaultNull = column.defaultNull();
			
			sb.append("\t" + field).append(" ").append(type).append(" comment'").append(comment).append("'");
			if(defaultNull){
				if(type.toUpperCase().equals("timestamp")){
					sb.append(",\n");
				}else{
					sb.append(" default null,\n");
				}
			}else{
				sb.append(" not null,\n");
				if(column.primaryKey()){
					primaryKey = "primary key (" + field + ")";
				}
			}
		}
		
		if(!StringUtils.isEmpty(primaryKey)){
			sb.append("\t").append(primaryKey);
		}
		sb.append("\n) comment='").append(tableComment).append("',default charset=utf8;");
		return sb.toString();
	}
}
