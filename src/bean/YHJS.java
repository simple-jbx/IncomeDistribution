package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
/**
 * 资源表
 * @author simple
 *
 */

@Table(tableName = "t_yhjs")
public class YHJS {
	
	@Column(field = "yhjsid", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String YHJSID;//用户角色ID
	
	@Column(field = "yhid", type = "varchar(100)")
	private String YHID;//用户ID
	
	@Column(field = "jsid", type = "varchar(100)")
	private String JSID;//角色ID
	
	@Column(field = "yhjsnote", type = "text")
	private String YHJSNOTE;//用户角色注释

	@Column(field = "isdel", type="int(2)")
	private int ISDEL;//是否删除

	public YHJS() {
		YHJSID = UUID.randomUUID().toString().replaceAll("-", "");
		YHID = "";
		JSID = "";
		YHJSNOTE = "";
		ISDEL = 2;
	}
	
	public String getYHJSID() {
		return YHJSID;
	}

	public void setYHJSID(String yHJSID) {
		YHJSID = yHJSID;
	}

	public String getYHID() {
		return YHID;
	}

	public void setYHID(String yHID) {
		YHID = yHID;
	}

	public String getJSID() {
		return JSID;
	}

	public void setJSID(String jSID) {
		JSID = jSID;
	}

	public String getYHJSNOTE() {
		return YHJSNOTE;
	}

	public void setYHJSNOTE(String yHJSNOTE) {
		YHJSNOTE = yHJSNOTE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
