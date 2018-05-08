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
	@Column(field = "jsqxid", type = "char(32)", primaryKey = true, defaultNull = false)
	private String JSQXID;//角色权限ID
	
	@Column(field = "jsid", type = "char(32)")
	private String JSID;//角色ID
	
	@Column(field = "qxid", type = "char(32)")
	private String QXID;//权限ID
	
	@Column(field = "zyname", type = "varchar(100)")
	private String ZYNAME;//对应资源
	
	@Column(field = "jsqxnote", type = "text")
	private String JSQXNOTE;//角色权限注释
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public JSQX() {
		JSQXID = UUID.randomUUID().toString().replaceAll("-", "");
		JSID = "-";
		QXID = "-";
		JSQXNOTE = "-";
		ZYNAME = "-";
		ISDEL = 2;
	}
	

	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"jsqxid\":\"");
		builder.append(JSQXID);
		builder.append("\", \"jsid\":\"");
		builder.append(JSID);
		builder.append("\", \"qxid\":\"");
		builder.append(QXID);
		builder.append("\", \"zyname\":\"");
		builder.append(ZYNAME);
		builder.append("\", \"jsqxnote\":\"");
		builder.append(JSQXNOTE);
		builder.append("\", \"isdel\":");
		builder.append(ISDEL);
		builder.append("}]");
		return builder.toString();
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

	public String getJSQXNOTE() {
		return JSQXNOTE;
	}

	public void setJSQXNOTE(String jSQXNOTE) {
		JSQXNOTE = jSQXNOTE;
	}
	
	public String getZYNAME() {
		return ZYNAME;
	}

	public void setZYNAME(String zYNAME) {
		ZYNAME = zYNAME;
	}

	public int getISDEL() {
		return ISDEL;
	}
	
	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
