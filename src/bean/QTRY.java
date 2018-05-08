package bean;

import annotation.Column;
import annotation.Table;
import config.DefalutValue;

@Table(tableName="t_qtry",tableComment="其他人员")
public class QTRY {

	@Column(field="id", type="char(32)", defaultNull=false, primaryKey=true, comment="id主键")
	private String ID;
	
	@Column(field="rydm", type="varchar(50)", comment="人员代码")
	private String RYDM;
	
	@Column(field="xm", type="varchar(50)", comment="姓名")
	private String XM;
	
	@Column(field="zgsjxs", type="varchar(10)", comment="在岗时间系数")
	private String ZGSJXS;
	
	@Column(field="khgzl", type="varchar(10)", comment="考核工作量")
	private String KHGZL;
	
	@Column(field="zgzlhj", type="varchar(10)", comment="总工作量合计")
	private String ZGZLHJ;
	
	@Column(field="cgzl", type="varchar(10)", comment="超工作量")
	private String CGZL;
	
	@Column(field="cgzljcj", type="varchar(20)", comment="超工作量奖酬金")
	private String CGZLJCJ;
	
	@Column(field="jxdd", type="varchar(20)", comment="教学督导")
	private String JXDD;
	
	@Column(field="dypcjcj", type="varchar(20)", comment="第一批次奖酬金")
	private String DYPCJCJ;
	
	@Column(field="msgzbf", type="varchar(20)", comment="免师工作补发")
	private String MSGZBF;
	
	@Column(field="ylbfhkcje", type="varchar(20)", comment="预留补发或扣除金额")
	private String YLBFHKCJE;
	
	@Column(field="dspcfphj", type="varchar(20)", comment="第三批次分配合计")
	private String DSPCFPHJ;
	
	@Column(field="sjzjcj", type="varchar(20)", comment="实际总奖酬金")
	private String SJZJCJ;
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)", comment="删除标记")
	private int ISDEL;
	
	public QTRY() {
		ID = DefalutValue.DEFAULT_VALUE_OF_ID();
		RYDM = DefalutValue.DEFAULT_STRING_VALUE;
		XM = DefalutValue.DEFAULT_STRING_VALUE;
		ZGSJXS = DefalutValue.DEFAULT_STRING_VALUE;
		KHGZL = DefalutValue.DEFAULT_STRING_VALUE;
		ZGZLHJ = DefalutValue.DEFAULT_STRING_VALUE;
		CGZL = DefalutValue.DEFAULT_STRING_VALUE;
		CGZLJCJ = DefalutValue.DEFAULT_STRING_VALUE;
		JXDD = DefalutValue.DEFAULT_STRING_VALUE;
		DYPCJCJ = DefalutValue.DEFAULT_STRING_VALUE;
		MSGZBF = DefalutValue.DEFAULT_STRING_VALUE;
		YLBFHKCJE = DefalutValue.DEFAULT_STRING_VALUE;
		DSPCFPHJ = DefalutValue.DEFAULT_STRING_VALUE;
		SJZJCJ = DefalutValue.DEFAULT_STRING_VALUE;
		ND = DefalutValue.DEFAULT_STRING_VALUE;
		ISDEL = DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE;
	}
	
	
	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\":\"");
		builder.append(ID);
		builder.append("\", \"rydm\":\"");
		builder.append(RYDM);
		builder.append("\", \"xm\":\"");
		builder.append(XM);
		builder.append("\", \"zgsjxs\":\"");
		builder.append(ZGSJXS);
		builder.append("\", \"khgzl\":\"");
		builder.append(KHGZL);
		builder.append("\", \"zgzlhj\":\"");
		builder.append(ZGZLHJ);
		builder.append("\", \"cgzl\":\"");
		builder.append(CGZL);
		builder.append("\", \"cgzljcj\":\"");
		builder.append(CGZLJCJ);
		builder.append("\", \"jxdd\":\"");
		builder.append(JXDD);
		builder.append("\", \"dypcjcj\":\"");
		builder.append(DYPCJCJ);
		builder.append("\", \"msgzbf\":\"");
		builder.append(MSGZBF);
		builder.append("\", \"ylbfhkcje\":\"");
		builder.append(YLBFHKCJE);
		builder.append("\", \"dspcfphj\":\"");
		builder.append(DSPCFPHJ);
		builder.append("\", \"sjzjcj\":\"");
		builder.append(SJZJCJ);
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

	public String getZGSJXS() {
		return ZGSJXS;
	}

	public void setZGSJXS(String zGSJXS) {
		ZGSJXS = zGSJXS;
	}

	public String getKHGZL() {
		return KHGZL;
	}

	public void setKHGZL(String kHGZL) {
		KHGZL = kHGZL;
	}

	public String getZGZLHJ() {
		return ZGZLHJ;
	}

	public void setZGZLHJ(String zGZLHJ) {
		ZGZLHJ = zGZLHJ;
	}

	public String getCGZL() {
		return CGZL;
	}

	public void setCGZL(String cGZL) {
		CGZL = cGZL;
	}

	public String getCGZLJCJ() {
		return CGZLJCJ;
	}

	public void setCGZLJCJ(String cGZLJCJ) {
		CGZLJCJ = cGZLJCJ;
	}

	public String getJXDD() {
		return JXDD;
	}

	public void setJXDD(String jXDD) {
		JXDD = jXDD;
	}

	public String getDYPCJCJ() {
		return DYPCJCJ;
	}

	public void setDYPCJCJ(String dYPCJCJ) {
		DYPCJCJ = dYPCJCJ;
	}

	public String getMSGZBF() {
		return MSGZBF;
	}

	public void setMSGZBF(String mSGZBF) {
		MSGZBF = mSGZBF;
	}

	public String getYLBFHKCJE() {
		return YLBFHKCJE;
	}

	public void setYLBFHKCJE(String yLBFHKCJE) {
		YLBFHKCJE = yLBFHKCJE;
	}

	public String getDSPCFPHJ() {
		return DSPCFPHJ;
	}

	public void setDSPCFPHJ(String dSPCFPHJ) {
		DSPCFPHJ = dSPCFPHJ;
	}

	public String getSJZJCJ() {
		return SJZJCJ;
	}

	public void setSJZJCJ(String sJZJCJ) {
		SJZJCJ = sJZJCJ;
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
