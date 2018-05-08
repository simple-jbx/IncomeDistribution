package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 监考工作数据表
 * @author simple
 *
 */

@Table(tableName="t_jkgzsjk")
public class JKGZSJK {

	@Column(field = "id", type = "char(32)", primaryKey = true, defaultNull = false)
	private String ID;//id
	
	@Column(field = "rydm", type = "varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "jkcs", type = "varchar(10)")
	private String JKCS;//监考次数
	
	@Column(field = "je", type = "varchar(20)")
	private String JE;//金额
	
	@Column(field = "nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public JKGZSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		JKCS = "-";
		ND = "-";
		JE = "-";
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
		builder.append("\", \"jkcs\":\"");
		builder.append(JKCS);
		builder.append("\", \"je\":\"");
		builder.append(JE);
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


	public String getJKCS() {
		return JKCS;
	}


	public void setJKCS(String jKCS) {
		JKCS = jKCS;
	}


	public String getJE() {
		return JE;
	}


	public void setJE(String jE) {
		JE = jE;
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
