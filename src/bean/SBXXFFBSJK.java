package bean;

import java.util.UUID;

import annotation.Column;
import annotation.Table;

@Table(tableName="t_sbxxffbsjk",tableComment="上报学校发放表")
public class SBXXFFBSJK {

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
	
	@Column(field="sfzhm", type="varchar(20)", comment="身份证号码")
	private String SFZHM;
	
	@Column(field="yhkh", type="varchar(50)", comment="银行卡号")
	private String YHKH;
	
	@Column(field="cssl", type="varchar(10)", comment="测算税率")
	private String CSSL;
	
	@Column(field="lxdh", type="varchar(20)", comment="联系电话")
	private String LXDH;
	
	@Column(field="isdel", type="int(1)", comment="状态")
	private int ISDEL;
	
	public SBXXFFBSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		BMDM = "-";
		RYDM = "-";
		XM = "-";
		BMMC = "-";
		JX = "-";
		XZ = "-";
		GQ = "-";
		QT = "-";
		NZJJE = "-";
		SFZHM = "-";
		YHKH = "-";
		CSSL = "-";
		LXDH = "-";
		ISDEL = 2;
	}
	
	public String toJson() {
		return "[{\"id\" : \"" + ID + "\", \"rydm\" : \"" + RYDM + "\", \"xm\" : \"" + XM + "\", \"bmmc\" : \""
				+ BMMC + "\", \"jx\" : \"" + JX + "\", \"xz\" : \"" + XZ + "\", \"gq\" : \"" + GQ + "\", \"nzjje\""
				+ " : \"" + NZJJE + "\", \"sfzhm\" : \"" + SFZHM + "\", \"yhkh\" : \"" + YHKH + "\", \"cssl\" : \""
				+ CSSL + "\", \"lxdh\" : \"" + LXDH +  "\", \"isdel\" : " + ISDEL + "}]";
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

	public String getSFZHM() {
		return SFZHM;
	}

	public void setSFZHM(String sFZHM) {
		SFZHM = sFZHM;
	}

	public String getYHKH() {
		return YHKH;
	}

	public void setYHKH(String yHKH) {
		YHKH = yHKH;
	}

	public String getCSSL() {
		return CSSL;
	}

	public void setCSSL(String cSSL) {
		CSSL = cSSL;
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
