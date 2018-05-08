package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 竞赛训练及社会服务数据
 * @author simple
 */

@Table(tableName = "t_jsxljshfwsj")
public class JSXLJSHFWSJ {
	
	@Column(field = "id", type = "char(32)", primaryKey = true, defaultNull = false)
	private String ID;//id,主键,自增
	
	@Column(field = "rydm", type = "varchar(50)")
	private String RYDM;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "jsjf", type = "varchar(10)")
	private String JSJF;//竞赛计分
	
	@Column(field = "shfwjf", type = "varchar(10)")
	private String SHFWJF;//社会服务计分
	
	@Column(field = "zf", type = "varchar(10)")
	private String ZF;//总分
	
	@Column(field = "jlje", type = "varchar(20)")
	private String JLJE;//奖励金额
	
	@Column(field = "nd", type = "varchar(10)", comment="年度")
	private String ND;
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public JSXLJSHFWSJ() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		JSJF = "-";
		SHFWJF = "-";
		ZF = "-";
		JLJE = "-";
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
		builder.append("\", \"jsjf\":\"");
		builder.append(JSJF);
		builder.append("\", \"shfwjf\":\"");
		builder.append(SHFWJF);
		builder.append("\", \"zf\":\"");
		builder.append(ZF);
		builder.append("\", \"jlje\":\"");
		builder.append(JLJE);
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


	public String getJSJF() {
		return JSJF;
	}


	public void setJSJF(String jSJF) {
		JSJF = jSJF;
	}


	public String getSHFWJF() {
		return SHFWJF;
	}


	public void setSHFWJF(String sHFWJF) {
		SHFWJF = sHFWJF;
	}


	public String getZF() {
		return ZF;
	}


	public void setZF(String zF) {
		ZF = zF;
	}


	public String getJLJE() {
		return JLJE;
	}


	public void setJLJE(String jLJE) {
		JLJE = jLJE;
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
