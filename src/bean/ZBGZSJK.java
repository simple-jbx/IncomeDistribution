package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

@Table(tableName="t_zbgzsjk")
public class ZBGZSJK {

	@Column(field="id", type="char(32)", primaryKey = true, defaultNull = false, comment="ID")
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)", comment="人员代码")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)", comment="姓名")
	private String XM;//姓名
	
	@Column(field="zbcs", type="varchar(10)", comment="值班次数")
	private String ZBCS;//值班次数
	
	@Column(field="ffje", type="varchar(20)", comment="发放金额")
	private String FFJE;//发放金额
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public ZBGZSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		ZBCS = "-";
		FFJE = "-";
		ND = "-";
		ISDEL = 2;
	}

	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\":\"");
		builder.append(ID);
		builder.append("\", \"rydm\":\"");
		builder.append(RYDM);
		builder.append("\", \"xm\":\"");
		builder.append(XM);
		builder.append("\", \"zbcs\":\"");
		builder.append(ZBCS);
		builder.append("\", \"ffje\":\"");
		builder.append(FFJE);
		builder.append("\", \"nd\":\"");
		builder.append(ND);
		builder.append("\", \"isdel\":");
		builder.append(ISDEL);
		builder.append("}]");
		return builder.toString();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getRYDM() {
		return RYDM;
	}

	public void setRYDM(String rYDM) {
		RYDM = rYDM;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String xM) {
		XM = xM;
	}

	public String getZBCS() {
		return ZBCS;
	}

	public void setZBCS(String zBCS) {
		ZBCS = zBCS;
	}

	public String getFFJE() {
		return FFJE;
	}

	public void setFFJE(String fFJE) {
		FFJE = fFJE;
	}

	public String getND() {
		return ND;
	}

	public void setND(String nD) {
		ND = nD;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
