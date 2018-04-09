package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
/**
 * 资源表
 * @author simple
 *
 */

@Table(tableName = "t_jsqx")
public class JSQX {
	@Column(field = "jsqxid", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String JSQXID;//角色权限ID
	
	@Column(field = "jsid", type = "varchar(100)")
	private String JSID;//角色ID
	
	@Column(field = "qxid", type = "varchar(100)")
	private String QXID;//权限ID
	
	@Column(field = "jsqxnote", type = "text")
	private String JSQXNOTE;//角色权限注释
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public JSQX() {
		JSQXID = UUID.randomUUID().toString().replaceAll("-", "");
		JSID = "";
		QXID = "";
		JSQXNOTE = "";
		ISDEL = 2;
	}
	
	public String getJSQXID() {
		return JSQXID;
	}

	public void setJSQXID(String jSQXID) {
		JSQXID = jSQXID;
	}

	public String getJSID() {
		return JSID;
	}

	public void setJSID(String jSID) {
		JSID = jSID;
	}

	public String getQXID() {
		return QXID;
	}

	public void setQXID(String qXID) {
		QXID = qXID;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}

	public String getJSQXNOTE() {
		return JSQXNOTE;
	}

	public void setJSQXNOTE(String jSQXNOTE) {
		JSQXNOTE = jSQXNOTE;
	}
}
