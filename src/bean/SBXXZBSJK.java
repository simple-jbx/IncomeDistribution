package bean;

import java.util.UUID;

import annotation.Column;
import annotation.Table;

@Table(tableName="t_sbxxzbsjk",tableComment="上报学校总表")
public class SBXXZBSJK {
	
	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false, comment="id主键")
	private String ID;
	
	@Column(field="bmdm", type="varchar(20)", comment="部门代码")
	private String BMDM;
	
	@Column(field="rydm", type="varchar(50)", comment="人员代码")
	private String RYDM;
	
	@Column(field="xm", type="varchar(50)", comment="姓名")
	private String XM;
	
	@Column(field="bmmc", type="varchar(100)", comment="部门名称")
	private String BMMC;
	
	@Column(field="nzjje", type="varchar(20)", comment="年终奖金额")
	private String NZJJE;
	
	@Column(field="tzje", type="varchar(20)", comment="调整金额")
	private String TZJE;
	
	@Column(field="sqsf", type="varchar(20)", comment="税前实发")
	private String SQSF;
	
	@Column(field="cssl", type="varchar(10)", comment="测算税率")
	private String CSSL;
	
	@Column(field="skcs", type="varchar(10)", comment="速扣除数")
	private String SKCS;
	
	@Column(field="sfje", type="varchar(20)", comment="实发金额")
	private String SFJE;
	
	@Column(field="lxdh", type="varchar(20)", comment="联系电话")
	private String LXDH;//联系电话
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;
	
	public SBXXZBSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		BMDM = "-";
		RYDM = "-";
		XM = "-";
		BMMC = "-";
		NZJJE = "-";
		TZJE = "-";
		SQSF = "-";
		CSSL = "-";
		SKCS = "-";
		SFJE = "-";
		LXDH = "-";
		ISDEL = 2;
	}
	
	public String toJson() {
		return "[{\"id\" : \"" + ID + "\", \"bmdm\" : \"" + BMDM + "\", \"rydm\" : \"" + RYDM + "\", \"xm\" : \""
				+ XM + "\", \"bmmc\" : \"" + BMMC + "\", \"nzjje\" : \"" + NZJJE + "\", \"tzje\" : \"" + TZJE
				+ "\", \"sqsf\" : \"" + SQSF + "\", \"cssl\" : \"" + CSSL + "\", \"skcs\" : \"" + SKCS
				+ "\", \"sfje\" : \"" + SFJE + "\", \"lxdh\" : \"" + LXDH + "\", \"isdel\" : " + ISDEL + "}]";
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

	public String getNZJJE() {
		return NZJJE;
	}

	public void setNZJJE(String nZJJE) {
		NZJJE = nZJJE;
	}

	public String getTZJE() {
		return TZJE;
	}

	public void setTZJE(String tZJE) {
		TZJE = tZJE;
	}

	public String getSQSF() {
		return SQSF;
	}

	public void setSQSF(String sQSF) {
		SQSF = sQSF;
	}

	public String getCSSL() {
		return CSSL;
	}

	public void setCSSL(String cSSL) {
		CSSL = cSSL;
	}

	public String getSKCS() {
		return SKCS;
	}

	public void setSKCS(String sKCS) {
		SKCS = sKCS;
	}

	public String getSFJE() {
		return SFJE;
	}

	public void setSFJE(String sFJE) {
		SFJE = sFJE;
	}

	public String getLXDH() {
		return LXDH;
	}

	public void setLXDH(String lXDH) {
		LXDH = lXDH;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
