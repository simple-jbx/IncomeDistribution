package bean;

import annotation.Column;
import annotation.Table;

/**
 * 酬金发放总报表
 * @author simple
 *
 */

@Table(tableName="t_bdwjcjffzbb",tableComment="本单位奖酬金发放总报表")
public class BDWJCJFFZBB {
	
	@Column(field="id", type="varchar(100)", primaryKey = true, defaultNull = false, comment="id主键")
	private String ID;
	
	@Column(field="bmdm", type="varchar(50)", comment="部门代码")
	private String BMDM;
	
	@Column(field="rydm", type="varchar(50)", comment="人员代码")
	private String RYDM;
	
	@Column(field="xm", type="varchar(50)", comment="姓名")
	private String XM;
	
	@Column(field="bmmc", type="varchar(100)", comment="部门名称")
	private String BMMC;
	
	@Column(field="jx", type="varchar(20)", comment="教学")
	private String JX;
	
	@Column(field="xz", type="varchar(20)", comment="行政")
	private String XZ;
	
	@Column(field="gq", type="varchar(20)", comment="工勤")
	private String GQ;
	
	@Column(field="qt", type="varchar(20)", comment="其他")
	private String QT;
	
	@Column(field="nzjje", type="varchar(20)", comment="年终奖金额")
	private String NZJJE;
	
	@Column(field="cssl", type="varchar(10)", comment="测算税率")
	private String CSSL;
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;
	
	public BDWJCJFFZBB() {
		ID = config.DefalutValue.DEFAULT_VALUE_OF_ID();
		RYDM = config.DefalutValue.DEFAULT_STRING_VALUE;
		XM = config.DefalutValue.DEFAULT_STRING_VALUE;
		BMMC = config.DefalutValue.DEFAULT_STRING_VALUE;
		JX = config.DefalutValue.DEFAULT_STRING_VALUE;
		XZ = config.DefalutValue.DEFAULT_STRING_VALUE;
		GQ = config.DefalutValue.DEFAULT_STRING_VALUE;
		QT = config.DefalutValue.DEFAULT_STRING_VALUE;
		NZJJE = config.DefalutValue.DEFAULT_STRING_VALUE;
		CSSL = config.DefalutValue.DEFAULT_STRING_VALUE;
		ND = config.DefalutValue.DEFAULT_STRING_VALUE;
		ISDEL = config.DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE;
	}
	
	public String toJson() {
		return "[{\"bmdm\" : \"" + BMDM + "\", \"id\" : \"" + ID + "\", \"rydm\" : \"" + RYDM + "\", \"xm\" : \""
				+ XM + "\", \"bmmc\" : \"" + BMMC + "\", \"jx\" : \"" + JX + "\", \"xz\" : \"" + XZ + "\", \"gq\" : \""
				+ GQ + "\", \"qt\" : \"" + QT + "\", \"nzjje\" : \"" + NZJJE + "\", \"cssl\" : \"" + CSSL + "\", " 
				+ "\"nd\" : \"" + ND + "\", \"isdel\" : " + ISDEL + "}]";
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getBMDM() {
		return BMDM;
	}

	public void setBMDM(String bMDM) {
		BMDM = bMDM;
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

	public String getBMMC() {
		return BMMC;
	}

	public void setBMMC(String bMMC) {
		BMMC = bMMC;
	}

	public String getJX() {
		return JX;
	}

	public void setJX(String jX) {
		JX = jX;
	}

	public String getXZ() {
		return XZ;
	}

	public void setXZ(String xZ) {
		XZ = xZ;
	}

	public String getGQ() {
		return GQ;
	}

	public void setGQ(String gQ) {
		GQ = gQ;
	}

	public String getQT() {
		return QT;
	}

	public void setQT(String qT) {
		QT = qT;
	}

	public String getNZJJE() {
		return NZJJE;
	}

	public void setNZJJE(String nZJJE) {
		NZJJE = nZJJE;
	}

	public String getCSSL() {
		return CSSL;
	}

	public void setCSSL(String cSSL) {
		CSSL = cSSL;
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
