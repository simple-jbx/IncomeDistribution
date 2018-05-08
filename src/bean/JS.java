package bean;

import java.util.UUID;

import annotation.Column;
import annotation.Table;

/**
 * 角色表
 * @author simple
 *
 */

@Table(tableName = "t_js")
public class JS {
	@Column(field = "jsid", type = "char(32)", primaryKey = true, defaultNull = false)
	private String JSID;//角色ID
	
	@Column(field = "jsname", type = "varchar(50)")
	private String JSNAME;//角色名称
	
	@Column(field = "jsnote", type = "text")
	private String JSNOTE;//角色注释
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public JS() {
		JSID = UUID.randomUUID().toString().replaceAll("-", "");
		JSNAME = "-";
		JSNOTE = "-";
		ISDEL = 2;
	}
	
	
	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"jsid\":\"");
		builder.append(JSID);
		builder.append("\", \"jsname\":\"");
		builder.append(JSNAME);
		builder.append("\", \"janote\":\"");
		builder.append(JSNOTE);
		builder.append("\", \"isdel\":");
		builder.append(ISDEL);
		builder.append("}]");
		return builder.toString();
	}


	public String getJSID() {
		return JSID;
	}

	public void setJSID(String jSID) {
		JSID = jSID;
	}

	public String getJSNAME() {
		return JSNAME;
	}

	public void setJSNAME(String jSNAME) {
		JSNAME = jSNAME;
	}

	public String getJSNOTE() {
		return JSNOTE;
	}

	public void setJSNOTE(String jSNOTE) {
		JSNOTE = jSNOTE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
