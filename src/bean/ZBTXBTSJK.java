package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 指标体系补贴数据库
 * @author simple
 *
 */

@Table(tableName="t_zbtxbtsjk")
public class ZBTXBTSJK {

	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="dfxm", type="text")
	private String DFXM;//得分项目
	
	@Column(field="nx", type="varchar(20)")
	private String NX;//年限
	
	@Column(field="jlje", type="varchar(20)")
	private String JLJE;//奖励金额
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	
	public ZBTXBTSJK() {
		ID = UUID.randomUUID().toString().replace("-", "");
		RYDM = "-";
		XM = "-";
		DFXM = "-";
		NX = "-";
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
		builder.append("\", \"dfxm\":\"");
		builder.append(DFXM);
		builder.append("\", \"nx\":\"");
		builder.append(NX);
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

	public String getDFXM() {
		return DFXM;
	}

	public void setDFXM(String dFXM) {
		DFXM = dFXM;
	}

	public String getNX() {
		return NX;
	}

	public void setNX(String nX) {
		NX = nX;
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
