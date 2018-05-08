package bean;

import java.util.UUID;

import annotation.Column;
import annotation.Table;

/**
 * 行政管理人员
 * @author simple
 *
 */

@Table(tableName ="t_xzglry",tableComment="行政管理人员")
public class XZGLRY {
	
	@Column(field="id", type="char(32)", primaryKey =true, defaultNull =false, comment="id,主键")
	private String ID;
	
	@Column(field="rydm", type="varchar(50)", comment="人员代码")
	private String RYDM;
	
	@Column(field="xm", type="varchar(50)", comment="姓名")
	private String XM;
	
	@Column(field="zw", type="varchar(50)", comment="职务")
	private String ZW;
	
	@Column(field="zj", type="varchar(50)", comment="职级")
	private String ZJ;
	
	@Column(field="zgxs", type="varchar(10)", comment="在岗系数")
	private String ZGXS;
	
	@Column(field="zyxs", type="varchar(10)", comment="职员系数")
	private String ZYXS;
	
	@Column(field="kqxs", type="varchar(10)", comment="考勤系数")
	private String KQXS;
	
	@Column(field="fpxs", type="varchar(10)", comment="分配系数")
	private String FPXS;
	
	@Column(field="xzpjj", type="varchar(20)", comment="行政平均奖")
	private String XZPJJ;
	
	@Column(field="xyrjj", type="varchar(20)", comment="学院人均奖")
	private String XYRJJ;
	
	@Column(field="bzxcgjl", type="varchar(20)", comment="标志性成果奖励")
	private String BZXCGJL;
	
	@Column(field="jkgz", type="varchar(20)", comment="监考工作")
	private String JKGZ;
	
	@Column(field="zbgz", type="varchar(20)", comment="值班工作")
	private String ZBGZ;
	
	@Column(field="xxpy", type="varchar(20)", comment="学校评优")
	private String XXPY;
	
	@Column(field="xypy", type="varchar(20)", comment="学院评优")
	private String XYPY;
	
	@Column(field="jxdd", type="varchar(20)", comment="教学督导")
	private String JXDD;
	
	@Column(field="dbbt", type="varchar(20)", comment="读博补贴")
	private String DBBT;
	
	@Column(field="xyhbt", type="varchar(20)", comment="校运会补贴")
	private String XYHBT;
	
	@Column(field="zjbt", type="varchar(20)", comment="照金补贴")
	private String ZJBT;
	
	@Column(field="hfbt", type="varchar(20)", comment="话费补贴")
	private String HFBT;
	
	@Column(field="xwbt", type="varchar(20)", comment="新闻补贴")
	private String XWBT;
	
	@Column(field="jyshdjf", type="varchar(20)", comment="教研室活动经费")
	private String JYSHDJF;
	
	@Column(field="dypcjcj", type="varchar(20)", comment="第一批次奖酬金")
	private String DYPCJCJ;
	
	@Column(field="depcjcj", type="varchar(20)", comment="第二批次奖酬金")
	private String DEPCJCJ;
	
	@Column(field="rjce", type="varchar(20)", comment="人均差额")
	private String RJCE;
	
	@Column(field="msgzcj", type="varchar(20)", comment="免师工作酬金")
	private String MSGZCJ;
	
	@Column(field="kqkf", type="varchar(20)", comment="考勤扣罚")
	private String KQKF;
	
	@Column(field = "msgzbf", type = "varchar(20)", comment="免师工作补发")
	private String MSGZBF;
	
	@Column(field = "csbjsjfh", type = "varchar(20)", comment="创收补缴税金返还")
	private String CSBJSJFH;
	
	@Column(field = "ylbfhkcje", type = "varchar(20)", comment="预留补发或扣除金额")
	private String YLBFHKCJE;
	
	@Column(field = "dspcfphj", type = "varchar(20)", comment="第三批次分配合计")
	private String DSPCFPHJ;
	
	@Column(field = "sjzjcj", type = "varchar(20)", comment="实际总奖酬金")
	private String SJZJCJ;
	
	@Column(field = "tzje", type = "varchar(20)", comment="调整金额")
	private String TZJE;
	
	@Column(field = "sjxyje", type = "varchar(20)", comment="上交学院金额")
	private String SJXYJE;
	
	@Column(field="sfje", type="varchar(20)", comment="实发金额")
	private String SFJE;
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field = "isdel", type = "int(1)", comment="删除标记")
	private int ISDEL;

	public XZGLRY() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		ZW = "-";
		ZJ = "-";
		ZGXS = "-";
		ZYXS = "-";
		KQXS = "-";
		FPXS = "-";
		XZPJJ = "-";
		XYRJJ = "-";
		BZXCGJL = "-";
		JKGZ = "-";
		ZBGZ = "-";
		XXPY = "-";
		XYPY = "-";
		JXDD = "-";
		DBBT = "-";
		XYHBT = "-";
		ZJBT = "-";
		HFBT = "-";
		XWBT = "-";
		JYSHDJF = "-";
		DYPCJCJ = "-";
		DEPCJCJ = "-";
		RJCE = "-";
		MSGZCJ = "-";
		KQKF = "-";
		MSGZBF = "-";
		CSBJSJFH = "-";
		YLBFHKCJE = "-";
		DSPCFPHJ = "-";
		SJZJCJ = "-";
		TZJE = "-";
		SJXYJE = "-";
		SFJE = "-";
		ND = "-";
		ISDEL = 2;
	}

	public String toJson() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\" : \"");
		builder.append(ID);
		builder.append("\", \"rydm\" : \"");
		builder.append(RYDM);
		builder.append("\", \"xm\" : \"");
		builder.append(XM);
		builder.append("\", \"zw\" : \"");
		builder.append(ZW);
		builder.append("\", \"zj\" : \"");
		builder.append(ZJ);
		builder.append("\", \"zgxs\" : \"");
		builder.append(ZGXS);
		builder.append("\", \"zyxs\" : \"");
		builder.append(ZYXS);
		builder.append("\", \"kqxs\" : \"");
		builder.append(KQXS);
		builder.append("\", \"fpxs\" : \"");
		builder.append(FPXS);
		builder.append("\", \"xzpjj\" : \"");
		builder.append(XZPJJ);
		builder.append("\", \"xyrjj\" : \"");
		builder.append(XYRJJ);
		builder.append("\", \"bzxcgjl\" : \"");
		builder.append(BZXCGJL);
		builder.append("\", \"jkgz\" : \"");
		builder.append(JKGZ);
		builder.append("\", \"zbgz\" : \"");
		builder.append(ZBGZ);
		builder.append("\", \"xxpy\" : \"");
		builder.append(XXPY);
		builder.append("\", \"xypy\" : \"");
		builder.append(XYPY);
		builder.append("\", \"jxdd\" : \"");
		builder.append(JXDD);
		builder.append("\", \"dbbt\" : \"");
		builder.append(DBBT);
		builder.append("\", \"xyhbt\" : \"");
		builder.append(XYHBT);
		builder.append("\", \"zjbt\" : \"");
		builder.append(ZJBT);
		builder.append("\", \"hfbt\" : \"");
		builder.append(HFBT);
		builder.append("\", \"xwbt\" : \"");
		builder.append(XWBT);
		builder.append("\", \"jyshdjf\" : \"");
		builder.append(JYSHDJF);
		builder.append("\", \"dypcjcj\" : \"");
		builder.append(DYPCJCJ);
		builder.append("\", \"depcjcj\" : \"");
		builder.append(DEPCJCJ);
		builder.append("\", \"rjce\" : \"");
		builder.append(RJCE);
		builder.append("\", \"msgzcj\" : \"");
		builder.append(MSGZCJ);
		builder.append("\", \"kqkf\" : \"");
		builder.append(KQKF);
		builder.append("\", \"msgzbf\" : \"");
		builder.append(MSGZBF);
		builder.append("\", \"csbjsjfh\" : \"");
		builder.append(CSBJSJFH);
		builder.append("\", \"ylbfhkcje\" : \"");
		builder.append(YLBFHKCJE);
		builder.append("\", \"dspcfphj\" : \"");
		builder.append(DSPCFPHJ);
		builder.append("\", \"sjzjcj\" : \"");
		builder.append(SJZJCJ);
		builder.append("\", \"tzje\" : \"");
		builder.append(TZJE);
		builder.append("\", \"sjxyje\" : \"");
		builder.append(SJXYJE);
		builder.append("\", \"sfje\" : \"");
		builder.append(SFJE);
		builder.append("\", \"nd\" : \"");
		builder.append(ND);
		builder.append("\", \"isdel\" : ");
		builder.append(ISDEL);
		builder.append("}]");
		return builder.toString();
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the rYDM
	 */
	public String getRYDM() {
		return RYDM;
	}

	/**
	 * @param rYDM the rYDM to set
	 */
	public void setRYDM(String rYDM) {
		RYDM = rYDM;
	}

	/**
	 * @return the xM
	 */
	public String getXM() {
		return XM;
	}

	/**
	 * @param xM the xM to set
	 */
	public void setXM(String xM) {
		XM = xM;
	}

	/**
	 * @return the zW
	 */
	public String getZW() {
		return ZW;
	}

	/**
	 * @param zW the zW to set
	 */
	public void setZW(String zW) {
		ZW = zW;
	}

	/**
	 * @return the zJ
	 */
	public String getZJ() {
		return ZJ;
	}

	/**
	 * @param zJ the zJ to set
	 */
	public void setZJ(String zJ) {
		ZJ = zJ;
	}

	/**
	 * @return the zGXS
	 */
	public String getZGXS() {
		return ZGXS;
	}

	/**
	 * @param zGXS the zGXS to set
	 */
	public void setZGXS(String zGXS) {
		ZGXS = zGXS;
	}

	/**
	 * @return the zYXS
	 */
	public String getZYXS() {
		return ZYXS;
	}

	/**
	 * @param zYXS the zYXS to set
	 */
	public void setZYXS(String zYXS) {
		ZYXS = zYXS;
	}

	/**
	 * @return the kQXS
	 */
	public String getKQXS() {
		return KQXS;
	}

	/**
	 * @param kQXS the kQXS to set
	 */
	public void setKQXS(String kQXS) {
		KQXS = kQXS;
	}

	/**
	 * @return the fPXS
	 */
	public String getFPXS() {
		return FPXS;
	}

	/**
	 * @param fPXS the fPXS to set
	 */
	public void setFPXS(String fPXS) {
		FPXS = fPXS;
	}

	/**
	 * @return the xZPJJ
	 */
	public String getXZPJJ() {
		return XZPJJ;
	}

	/**
	 * @param xZPJJ the xZPJJ to set
	 */
	public void setXZPJJ(String xZPJJ) {
		XZPJJ = xZPJJ;
	}

	/**
	 * @return the xYRJJ
	 */
	public String getXYRJJ() {
		return XYRJJ;
	}

	/**
	 * @param xYRJJ the xYRJJ to set
	 */
	public void setXYRJJ(String xYRJJ) {
		XYRJJ = xYRJJ;
	}

	/**
	 * @return the bZXCGJL
	 */
	public String getBZXCGJL() {
		return BZXCGJL;
	}

	/**
	 * @param bZXCGJL the bZXCGJL to set
	 */
	public void setBZXCGJL(String bZXCGJL) {
		BZXCGJL = bZXCGJL;
	}

	/**
	 * @return the jKGZ
	 */
	public String getJKGZ() {
		return JKGZ;
	}

	/**
	 * @param jKGZ the jKGZ to set
	 */
	public void setJKGZ(String jKGZ) {
		JKGZ = jKGZ;
	}

	/**
	 * @return the zBGZ
	 */
	public String getZBGZ() {
		return ZBGZ;
	}

	/**
	 * @param zBGZ the zBGZ to set
	 */
	public void setZBGZ(String zBGZ) {
		ZBGZ = zBGZ;
	}

	/**
	 * @return the xXPY
	 */
	public String getXXPY() {
		return XXPY;
	}

	/**
	 * @param xXPY the xXPY to set
	 */
	public void setXXPY(String xXPY) {
		XXPY = xXPY;
	}

	/**
	 * @return the xYPY
	 */
	public String getXYPY() {
		return XYPY;
	}

	/**
	 * @param xYPY the xYPY to set
	 */
	public void setXYPY(String xYPY) {
		XYPY = xYPY;
	}

	/**
	 * @return the jXDD
	 */
	public String getJXDD() {
		return JXDD;
	}

	/**
	 * @param jXDD the jXDD to set
	 */
	public void setJXDD(String jXDD) {
		JXDD = jXDD;
	}

	/**
	 * @return the dBBT
	 */
	public String getDBBT() {
		return DBBT;
	}

	/**
	 * @param dBBT the dBBT to set
	 */
	public void setDBBT(String dBBT) {
		DBBT = dBBT;
	}

	/**
	 * @return the xYHBT
	 */
	public String getXYHBT() {
		return XYHBT;
	}

	/**
	 * @param xYHBT the xYHBT to set
	 */
	public void setXYHBT(String xYHBT) {
		XYHBT = xYHBT;
	}

	/**
	 * @return the zJBT
	 */
	public String getZJBT() {
		return ZJBT;
	}

	/**
	 * @param zJBT the zJBT to set
	 */
	public void setZJBT(String zJBT) {
		ZJBT = zJBT;
	}

	/**
	 * @return the hFBT
	 */
	public String getHFBT() {
		return HFBT;
	}

	/**
	 * @param hFBT the hFBT to set
	 */
	public void setHFBT(String hFBT) {
		HFBT = hFBT;
	}

	/**
	 * @return the xWBT
	 */
	public String getXWBT() {
		return XWBT;
	}

	/**
	 * @param xWBT the xWBT to set
	 */
	public void setXWBT(String xWBT) {
		XWBT = xWBT;
	}

	/**
	 * @return the jYSHDJF
	 */
	public String getJYSHDJF() {
		return JYSHDJF;
	}

	/**
	 * @param jYSHDJF the jYSHDJF to set
	 */
	public void setJYSHDJF(String jYSHDJF) {
		JYSHDJF = jYSHDJF;
	}

	/**
	 * @return the dYPCJCJ
	 */
	public String getDYPCJCJ() {
		return DYPCJCJ;
	}

	/**
	 * @param dYPCJCJ the dYPCJCJ to set
	 */
	public void setDYPCJCJ(String dYPCJCJ) {
		DYPCJCJ = dYPCJCJ;
	}

	/**
	 * @return the dEPCJCJ
	 */
	public String getDEPCJCJ() {
		return DEPCJCJ;
	}

	/**
	 * @param dEPCJCJ the dEPCJCJ to set
	 */
	public void setDEPCJCJ(String dEPCJCJ) {
		DEPCJCJ = dEPCJCJ;
	}

	/**
	 * @return the rJCE
	 */
	public String getRJCE() {
		return RJCE;
	}

	/**
	 * @param rJCE the rJCE to set
	 */
	public void setRJCE(String rJCE) {
		RJCE = rJCE;
	}

	/**
	 * @return the mSGZCJ
	 */
	public String getMSGZCJ() {
		return MSGZCJ;
	}

	/**
	 * @param mSGZCJ the mSGZCJ to set
	 */
	public void setMSGZCJ(String mSGZCJ) {
		MSGZCJ = mSGZCJ;
	}

	/**
	 * @return the kQKF
	 */
	public String getKQKF() {
		return KQKF;
	}

	/**
	 * @param kQKF the kQKF to set
	 */
	public void setKQKF(String kQKF) {
		KQKF = kQKF;
	}

	/**
	 * @return the mSGZBF
	 */
	public String getMSGZBF() {
		return MSGZBF;
	}

	/**
	 * @param mSGZBF the mSGZBF to set
	 */
	public void setMSGZBF(String mSGZBF) {
		MSGZBF = mSGZBF;
	}

	/**
	 * @return the cSBJSJFH
	 */
	public String getCSBJSJFH() {
		return CSBJSJFH;
	}

	/**
	 * @param cSBJSJFH the cSBJSJFH to set
	 */
	public void setCSBJSJFH(String cSBJSJFH) {
		CSBJSJFH = cSBJSJFH;
	}

	/**
	 * @return the yLBFHKCJE
	 */
	public String getYLBFHKCJE() {
		return YLBFHKCJE;
	}

	/**
	 * @param yLBFHKCJE the yLBFHKCJE to set
	 */
	public void setYLBFHKCJE(String yLBFHKCJE) {
		YLBFHKCJE = yLBFHKCJE;
	}

	/**
	 * @return the dSPCFPHJ
	 */
	public String getDSPCFPHJ() {
		return DSPCFPHJ;
	}

	/**
	 * @param dSPCFPHJ the dSPCFPHJ to set
	 */
	public void setDSPCFPHJ(String dSPCFPHJ) {
		DSPCFPHJ = dSPCFPHJ;
	}

	/**
	 * @return the sJZJCJ
	 */
	public String getSJZJCJ() {
		return SJZJCJ;
	}

	/**
	 * @param sJZJCJ the sJZJCJ to set
	 */
	public void setSJZJCJ(String sJZJCJ) {
		SJZJCJ = sJZJCJ;
	}

	/**
	 * @return the tZJE
	 */
	public String getTZJE() {
		return TZJE;
	}

	/**
	 * @param tZJE the tZJE to set
	 */
	public void setTZJE(String tZJE) {
		TZJE = tZJE;
	}

	/**
	 * @return the sJXYJE
	 */
	public String getSJXYJE() {
		return SJXYJE;
	}

	/**
	 * @param sJXYJE the sJXYJE to set
	 */
	public void setSJXYJE(String sJXYJE) {
		SJXYJE = sJXYJE;
	}

	/**
	 * @return the sFJE
	 */
	public String getSFJE() {
		return SFJE;
	}

	/**
	 * @param sFJE the sFJE to set
	 */
	public void setSFJE(String sFJE) {
		SFJE = sFJE;
	}

	/**
	 * @return the nD
	 */
	public String getND() {
		return ND;
	}

	/**
	 * @param nD the nD to set
	 */
	public void setND(String nD) {
		ND = nD;
	}

	/**
	 * @return the iSDEL
	 */
	public int getISDEL() {
		return ISDEL;
	}

	/**
	 * @param iSDEL the iSDEL to set
	 */
	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
