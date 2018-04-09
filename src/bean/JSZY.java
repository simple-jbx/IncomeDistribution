package bean;

import java.util.UUID;

import annotation.Column;
import annotation.Table;

/**
 * 角色资源表
 * @author simple
 *
 */

@Table(tableName = "t_jszy")
public class JSZY {
	@Column(field = "jszyid", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String JSZYID;//角色资源ID
	
	@Column(field = "jsid", type = "varchar(100)")
	private String JSID;//角色ID
	
	@Column(field = "zyid", type = "varchar(100)")
	private String ZYID;//资源ID
	
	@Column(field = "jszynote", type = "text")
	private String JSZYNOTE;//角色资源注释
	
	@Column(field = "isdel", type="int(2)")
	private int ISDEL;//是否删除

	public JSZY() {
		JSZYID = UUID.randomUUID().toString().replaceAll("-", "");
		JSID = "";
		ZYID = "";
		JSZYNOTE = "";
		ISDEL = 2;
	}

	public String getJSZYID() {
		return JSZYID;
	}

	public void setJSZYID(String jSZYID) {
		JSZYID = jSZYID;
	}

	public String getJSID() {
		return JSID;
	}

	public void setJSID(String jSID) {
		JSID = jSID;
	}

	public String getZYID() {
		return ZYID;
	}

	public void setZYID(String zYID) {
		ZYID = zYID;
	}

	public String getJSZYNOTE() {
		return JSZYNOTE;
	}

	public void setJSZYNOTE(String jSZYNOTE) {
		JSZYNOTE = jSZYNOTE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
