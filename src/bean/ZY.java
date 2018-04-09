package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 资源表
 * @author simple
 *
 */

@Table(tableName = "t_zy")
public class ZY {
	@Column(field = "zyid", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String ZYID;//资源ID
	
	@Column(field = "zyname", type = "varchar(50)")
	private String ZYNAME;//资源名称
	
	@Column(field = "zynote", type = "text")
	private String ZYNOTE;//资源注释
	
	@Column(field="zygroup", type="int(2)")
	private int ZYGROUP;//资源分组
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public ZY() {
		ZYID = UUID.randomUUID().toString().replaceAll("-", "");
		ZYNAME = "";
		ZYNOTE = "";
		ZYGROUP = 0;
		ISDEL = 2;	
	}

	public String getZYID() {
		return ZYID;
	}

	public void setZYID(String zYID) {
		ZYID = zYID;
	}

	public String getZYNAME() {
		return ZYNAME;
	}

	public void setZYNAME(String zYNAME) {
		ZYNAME = zYNAME;
	}

	public String getZYNOTE() {
		return ZYNOTE;
	}

	public void setZYNOTE(String zYNOTE) {
		ZYNOTE = zYNOTE;
	}

	public int getZYGROUP() {
		return ZYGROUP;
	}

	public void setZYGROUP(int zYGROUP) {
		ZYGROUP = zYGROUP;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
