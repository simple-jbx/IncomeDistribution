package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
/**
 * 权限表
 * @author simple
 *
 */

@Table(tableName = "t_qx")
public class QX {
	
	@Column(field = "qxid", type = "char(32)", primaryKey = true, defaultNull = false)
	private String QXID;//权限ID
	
	@Column(field = "qxname", type = "varchar(50)")
	private String QXNAME;//权限名称
	
	@Column(field = "qxnote", type = "text")
	private String QXNOTE;//权限注释
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public QX() {
		QXID = UUID.randomUUID().toString().replaceAll("-", "");
		QXNAME = "";
		QXNOTE = "";
		ISDEL = 2;
	}
	
	public String getQXID() {
		return QXID;
	}

	public void setQXID(String qXID) {
		QXID = qXID;
	}

	public String getQXNAME() {
		return QXNAME;
	}

	public void setQXNAME(String qXNAME) {
		QXNAME = qXNAME;
	}

	public String getQXNOTE() {
		return QXNOTE;
	}

	public void setQXNOTE(String qXNOTE) {
		QXNOTE = qXNOTE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
