package bean;

import annotation.Table;
import java.util.UUID;
import annotation.Column;

/**
 * 专任教师
 * @author simple
 *
 */

@Table(tableName="t_zrjs", tableComment="专任教师")
public class ZRJS {
	
	@Column(field = "id", type = "char(32)", primaryKey = true, defaultNull = false, comment="id主键")
	private String ID;
	
	@Column(field = "rydm", type = "varchar(50)", comment="人员代码")
	private String RYDM;
	
	@Column(field = "xm", type = "varchar(50)", comment="姓名")
	private String XM;
	
	@Column(field = "zgsjxs", type = "varchar(5)", comment="在岗时间系数")
	private String ZGSJXS;
	
	@Column(field = "khgzl", type = "varchar(15)", comment="考核工作量" )
	private String KHGZL;
	
	@Column(field = "zgzlhj", type = "varchar(15)", comment="总工作量合计")
	private String ZGZLHJ;
	
	@Column(field = "cgzl", type = "varchar(15)", comment="超工作量")
	private String CGZL;
		
	@Column(field = "cgzljcj", type = "varchar(20)", comment="超工作量奖酬金")
	private String CGZLJCJ;
	
	@Column(field = "kyjcj", type = "varchar(20)", comment="科研奖酬金")
	private String KYJCJ;
	
	@Column(field = "jsxfjj", type = "varchar(20)", comment="竞赛训服奖金")
	private String JSXFJJ;
		
	@Column(field = "rjj", type = "varchar(20)", comment="人均奖")
	private String RJJ;
	
	@Column(field = "bzxcgjl", type = "varchar(20)", comment="标志性成果奖励")
	private String BZXCGJL;
	
	@Column(field = "jkgz", type = "varchar(20)", comment="监考工作")
	private String JKGZ;
	
	@Column(field = "zbgz", type = "varchar(20)", comment="值班工作")
	private String ZBGZ;
	
	@Column(field = "xxpy", type = "varchar(20)", comment="学校评优")
	private String XXPY;
	
	@Column(field = "xypy", type = "varchar(20)", comment="学院评优")
	private String XYPY;
	
	@Column(field = "jxdd", type = "varchar(20)", comment="教学督导")
	private String JXDD;
	
	@Column(field = "dbbt", type = "varchar(20)", comment="读博补贴")
	private String DBBT;
	
	@Column(field = "xyhbt", type = "varchar(20)", comment="校运会补贴")
	private String XYHBT;
	
	@Column(field = "zjbt", type = "varchar(20)", comment="照金补贴")
	private String ZJBT;
	
	@Column(field = "hfbt", type = "varchar(20)", comment="话费补贴")
	private String HFBT;
	
	@Column(field = "xwbt", type = "varchar(20)", comment="新闻补贴")
	private String XWBT;
	
	@Column(field = "gzbc", type = "varchar(20)", comment="馆长补差")
	private String GZBC;
	
	@Column(field = "zbbt", type = "varchar(20)", comment="指标补贴")
	private String ZBBT;
	
	@Column(field = "jyshdjf", type = "varchar(20)", comment="教研室活动经费")
	private String JYSHDJF;
	
	@Column(field = "dypcjcj", type = "varchar(20)", comment="第一批次奖酬金")
	private String DYPCJCJ;
	
	@Column(field = "depcrjj", type = "varchar(20)", comment="第二批次人均奖")
	private String DEPCRJJ;
	
	@Column(field = "msgzcj", type = "varchar(20)", comment="免师工作酬金")
	private String MSGZCJ;
	
	@Column(field = "kqkf", type = "varchar(20)", comment="考勤扣罚")
	private String KQKF;
	
	@Column(field = "msgzbf", type = "varchar(20)", comment="免师工作补发")
	private String MSGZBF;
	
	@Column(field = "csbjksjfh", type = "varchar(20)", comment="创收补缴款税金返还")
	private String CSBJKSJFH;
	
	@Column(field = "ylbfhkcje", type = "varchar(20)", comment="预留补发或扣除金额")
	private String YLBFHKCJE;
	
	@Column(field = "dspcfphj", type = "varchar(20)", comment="第三批次分配合计")
	private String DSPCFPHJ;
	
	@Column(field = "sjzjcj", type = "varchar(20)", comment="实际总奖酬金")
	private String SJZJCJ;
	
	@Column(field = "tzje", type = "varchar(20)", comment="调整金额")
	private String TZJE;
	
	@Column(field = "sjxy", type = "varchar(20)", comment="上交学院")
	private String SJXY;
	
	@Column(field="sfje", type="varchar(20)", comment="实发金额")
	private String SFJE;
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field = "isdel", type = "int(1)", comment="删除标记")
	private int ISDEL;

	public ZRJS() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		ZGSJXS = "-";
		KHGZL = "-";
		ZGZLHJ = "-";
		CGZL = "-";
		CGZLJCJ = "-";
		KYJCJ = "-";
		JSXFJJ = "-";
		RJJ = "-";
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
		GZBC = "-";
		ZBBT = "-";
		JYSHDJF = "-";
		DYPCJCJ = "-";
		DEPCRJJ = "-";
		MSGZCJ = "-";
		KQKF = "-";
		MSGZBF = "-";
		CSBJKSJFH = "-";
		YLBFHKCJE = "-";
		DSPCFPHJ = "-";
		SJZJCJ = "-";
		TZJE = "-";
		SJXY = "-";
		SFJE = "-";
		ND = "-";
		ISDEL = 2;
	}

	/**
	 * 将对象转为JSON字符串
	 * @return
	 */
	public String toJson() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\" : \"");
		builder.append(ID);
		builder.append("\", \"rydm\" : \"");
		builder.append(RYDM);
		builder.append("\", \"xm\" : \"");
		builder.append(XM);
		builder.append("\", \"zgsjxs\" : \"");
		builder.append(ZGSJXS);
		builder.append("\", \"khgzl\" : \"");
		builder.append(KHGZL);
		builder.append("\", \"zgzlhj\" : \"");
		builder.append(ZGZLHJ);
		builder.append("\", \"cgzl\" : \"");
		builder.append(CGZL);
		builder.append("\", \"cgzljcj\" : \"");
		builder.append(CGZLJCJ);
		builder.append("\", \"kyjcj\" : \"");
		builder.append(KYJCJ);
		builder.append("\", \"jsxfjj\" : \"");
		builder.append(JSXFJJ);
		builder.append("\", \"rjj\" : \"");
		builder.append(RJJ);
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
		builder.append("\", \"gzbc\" : \"");
		builder.append(GZBC);
		builder.append("\", \"zbbt\" : \"");
		builder.append(ZBBT);
		builder.append("\", \"jyshdjf\" : \"");
		builder.append(JYSHDJF);
		builder.append("\", \"dypcjcj\" : \"");
		builder.append(DYPCJCJ);
		builder.append("\", \"depcrjj\" : \"");
		builder.append(DEPCRJJ);
		builder.append("\", \"msgzcj\" : \"");
		builder.append(MSGZCJ);
		builder.append("\", \"kqkf\" : \"");
		builder.append(KQKF);
		builder.append("\", \"msgzbf\" : \"");
		builder.append(MSGZBF);
		builder.append("\", \"csbjksjfh\" : \"");
		builder.append(CSBJKSJFH);
		builder.append("\", \"ylbfhkcje\" : \"");
		builder.append(YLBFHKCJE);
		builder.append("\", \"dspcfphj\" : \"");
		builder.append(DSPCFPHJ);
		builder.append("\", \"sjzjcj\" : \"");
		builder.append(SJZJCJ);
		builder.append("\", \"tzje\" : \"");
		builder.append(TZJE);
		builder.append("\", \"sjxy\" : \"");
		builder.append(SJXY);
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
	 * @return the zGSJXS
	 */
	public String getZGSJXS() {
		return ZGSJXS;
	}

	/**
	 * @param zGSJXS the zGSJXS to set
	 */
	public void setZGSJXS(String zGSJXS) {
		ZGSJXS = zGSJXS;
	}

	/**
	 * @return the kHGZL
	 */
	public String getKHGZL() {
		return KHGZL;
	}

	/**
	 * @param kHGZL the kHGZL to set
	 */
	public void setKHGZL(String kHGZL) {
		KHGZL = kHGZL;
	}

	/**
	 * @return the zGZLHJ
	 */
	public String getZGZLHJ() {
		return ZGZLHJ;
	}

	/**
	 * @param zGZLHJ the zGZLHJ to set
	 */
	public void setZGZLHJ(String zGZLHJ) {
		ZGZLHJ = zGZLHJ;
	}

	/**
	 * @return the cGZL
	 */
	public String getCGZL() {
		return CGZL;
	}

	/**
	 * @param cGZL the cGZL to set
	 */
	public void setCGZL(String cGZL) {
		CGZL = cGZL;
	}

	/**
	 * @return the cGZLJCJ
	 */
	public String getCGZLJCJ() {
		return CGZLJCJ;
	}

	/**
	 * @param cGZLJCJ the cGZLJCJ to set
	 */
	public void setCGZLJCJ(String cGZLJCJ) {
		CGZLJCJ = cGZLJCJ;
	}

	/**
	 * @return the kYJCJ
	 */
	public String getKYJCJ() {
		return KYJCJ;
	}

	/**
	 * @param kYJCJ the kYJCJ to set
	 */
	public void setKYJCJ(String kYJCJ) {
		KYJCJ = kYJCJ;
	}

	/**
	 * @return the jSXFJJ
	 */
	public String getJSXFJJ() {
		return JSXFJJ;
	}

	/**
	 * @param jSXFJJ the jSXFJJ to set
	 */
	public void setJSXFJJ(String jSXFJJ) {
		JSXFJJ = jSXFJJ;
	}

	/**
	 * @return the rJJ
	 */
	public String getRJJ() {
		return RJJ;
	}

	/**
	 * @param rJJ the rJJ to set
	 */
	public void setRJJ(String rJJ) {
		RJJ = rJJ;
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
	 * @return the gZBC
	 */
	public String getGZBC() {
		return GZBC;
	}

	/**
	 * @param gZBC the gZBC to set
	 */
	public void setGZBC(String gZBC) {
		GZBC = gZBC;
	}

	/**
	 * @return the zBBT
	 */
	public String getZBBT() {
		return ZBBT;
	}

	/**
	 * @param zBBT the zBBT to set
	 */
	public void setZBBT(String zBBT) {
		ZBBT = zBBT;
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
	 * @return the dEPCRJJ
	 */
	public String getDEPCRJJ() {
		return DEPCRJJ;
	}

	/**
	 * @param dEPCRJJ the dEPCRJJ to set
	 */
	public void setDEPCRJJ(String dEPCRJJ) {
		DEPCRJJ = dEPCRJJ;
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
	 * @return the hDZJF
	 */
	public String getCSBJKSJFH() {
		return CSBJKSJFH;
	}

	/**
	 * @param hDZJF the hDZJF to set
	 */
	public void setCSBJKSJFH(String hDZJF) {
		CSBJKSJFH = hDZJF;
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
	 * @return the sJXY
	 */
	public String getSJXY() {
		return SJXY;
	}

	/**
	 * @param sJXY the sJXY to set
	 */
	public void setSJXY(String sJXY) {
		SJXY = sJXY;
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
