package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 工勤人员
 * @author simple
 *
 */

@Table(tableName="t_gqry", tableComment="工勤人员")
public class GQRY {
	@Column(field = "id", type = "varchar(100)", primaryKey = true, defaultNull = false, comment="id主键")
	private String ID;
	
	@Column(field = "rydm", type = "varchar(50)", comment="人员代码")
	private String RYDM;
	
	@Column(field = "xm", type = "varchar(50)", comment="姓名")
	private String XM;
	
	@Column(field = "gw", type = "varchar(50)", comment="岗位")
	private String GW;
	
	@Column(field = "zgsjxs", type = "varchar(5)", comment="在岗时间系数")
	private String ZGSJXS;
	
	@Column(field = "zcxs", type = "varchar(5)", comment="职称系数")
	private String ZCXS;
	
	@Column(field = "kqxs", type = "varchar(5)", comment="考勤系数")
	private String KQXS;
	
	@Column(field = "fpxs", type = "varchar(10)", comment="分配系数")
	private String FPXS;
	
	@Column(field = "nzbzjj", type = "varchar(20)", comment="年终标准奖金")
	private String NZBZJJ;
	
	@Column(field = "sfpjjl", type = "varchar(20)", comment="实发平均奖励")
	private String SFPJJL;
	
	@Column(field = "xxpyjl", type = "varchar(20)", comment="学院评优奖励")
	private String XXPYJL;
	
	@Column(field = "xypyjl", type = "varchar(20)", comment="学校评优奖励")
	private String XYPYJL;
	
	@Column(field = "xyhbt", type = "varchar(20)", comment="校运会补贴")
	private String XYHBT;
	
	@Column(field = "zjhdbt", type = "varchar(20)", comment="照金活动补贴")
	private String ZJHDBT;
	
	@Column(field = "dypcfphj", type = "varchar(20)", comment="第一批次分配合计")
	private String DYPCFPHJ;
	
	@Column(field = "depcrjj", type = "varchar(20)", comment="第二批次人均奖")
	private String DEPCRJJ;
	
	@Column(field = "kqkf", type = "varchar(20)", comment="考勤扣罚")
	private String KQKF;
	
	@Column(field="bfhkc", type="varchar(20)", comment="补发或扣除")
	private String BFHKC;
	
	@Column(field="dspfphj", type="varchar(20)", comment="第三批分配合计")
	private String DSPFPHJ;
	
	@Column(field="hjje", type="varchar(20)", comment="合计金额")
	private String HJJE;
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;

	public GQRY() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		GW = "";
		ZGSJXS = "-";
		ZCXS = "-";
		KQXS = "-";
		FPXS = "-";
		NZBZJJ = "-";
		SFPJJL = "-";
		XXPYJL = "-";
		XYPYJL = "-";
		XYHBT = "-";
		ZJHDBT = "-";
		DYPCFPHJ = "-";
		DEPCRJJ = "-";
		KQKF = "-";
		BFHKC = "-";
		DSPFPHJ = "-";
		HJJE = "-";
		ISDEL = 2;
	}
	
	public String toJson() {
		return "[{\"id\" : \"" + ID + "\", \"rydm\" : \"" + RYDM + "\", \"xm\" : \"" + XM + "\", \"gw\" : \""
				+ GW + "\", \"zgsjxs\" : \"" + ZGSJXS + "\", \"zcxs\" : \"" + ZCXS + "\", \"kqxs\" : \"" + KQXS
				+ "\", \"fpxs\" : \"" + FPXS + "\", \"nzbzjj\" : \"" + NZBZJJ + "\", \"sfpjjl\" : \"" + SFPJJL
				+"\", \"xxpyjl\" : \"" + XXPYJL + "\", \"xypyjl\" : \"" + XYPYJL + "\", \"xyhbt\" : \""
				+XYHBT + "\", \"zjhdbt\" : \"" + ZJHDBT + "\", \"dypcfphj\" : \"" + DYPCFPHJ
				+ "\", \"depcrjj\" : \"" + DEPCRJJ + "\", \"kqkf\" : \"" + KQKF  + "\", \"bfhkc\" : \"" + BFHKC
				+ "\", \"dspfphj\" : \"" + DSPFPHJ + "\", \"hjje\" : \"" + HJJE + "\", \"isdel\" : " + ISDEL +"}]";
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

	public String getGW() {
		return GW;
	}

	public void setGW(String gW) {
		GW = gW;
	}

	public String getZGSJXS() {
		return ZGSJXS;
	}

	public void setZGSJXS(String zGSJXS) {
		ZGSJXS = zGSJXS;
	}

	public String getZCXS() {
		return ZCXS;
	}

	public void setZCXS(String zCXS) {
		ZCXS = zCXS;
	}

	public String getKQXS() {
		return KQXS;
	}

	public void setKQXS(String kQXS) {
		KQXS = kQXS;
	}

	public String getFPXS() {
		return FPXS;
	}

	public void setFPXS(String fPXS) {
		FPXS = fPXS;
	}

	public String getNZBZJJ() {
		return NZBZJJ;
	}

	public void setNZBZJJ(String nZBZJJ) {
		NZBZJJ = nZBZJJ;
	}

	public String getSFPJJL() {
		return SFPJJL;
	}

	public void setSFPJJL(String sFPJJL) {
		SFPJJL = sFPJJL;
	}

	public String getXXPYJL() {
		return XXPYJL;
	}

	public void setXXPYJL(String xXPYJL) {
		XXPYJL = xXPYJL;
	}

	public String getXYPYJL() {
		return XYPYJL;
	}

	public void setXYPYJL(String xYPYJL) {
		XYPYJL = xYPYJL;
	}

	public String getXYHBT() {
		return XYHBT;
	}

	public void setXYHBT(String xYHBT) {
		XYHBT = xYHBT;
	}

	public String getZJHDBT() {
		return ZJHDBT;
	}

	public void setZJHDBT(String zJHDBT) {
		ZJHDBT = zJHDBT;
	}

	public String getDYPCFPHJ() {
		return DYPCFPHJ;
	}

	public void setDYPCFPHJ(String dYPCFPHJ) {
		DYPCFPHJ = dYPCFPHJ;
	}

	public String getDEPCRJJ() {
		return DEPCRJJ;
	}

	public void setDEPCRJJ(String dEPCRJJ) {
		DEPCRJJ = dEPCRJJ;
	}

	public String getKQKF() {
		return KQKF;
	}

	public void setKQKF(String kQKF) {
		KQKF = kQKF;
	}

	public String getBFHKC() {
		return BFHKC;
	}

	public void setBFHKC(String bFHKC) {
		BFHKC = bFHKC;
	}

	public String getDSPFPHJ() {
		return DSPFPHJ;
	}

	public void setDSPFPHJ(String dSPFPHJ) {
		DSPFPHJ = dSPFPHJ;
	}

	public String getHJJE() {
		return HJJE;
	}

	public void setHJJE(String hJJE) {
		HJJE = hJJE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
