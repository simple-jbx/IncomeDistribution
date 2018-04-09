package bean;

import annotation.Column;
import annotation.Table;
import java.math.BigDecimal;

/**
 * 行政管理人员
 * @author simple
 *
 */

@Table(tableName = "t_xzglry")
public class XZGLRY {
	
	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//主键，自增
	
	@Column(field = "dw", type = "varchar(50)")
	private String DW;//单位
	
	@Column(field = "gh", type = "varchar(15)")
	private String GH;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "zgsjxs", type = "double(3,2)")
	private Double ZGSJXS;//在岗时间系数
	
	@Column(field = "zwxs", type = "double(3,2)")
	private Double ZWXS;//职务系数
	
	@Column(field = "kqxs", type = "double(3, 2)")
	private Double KQXS;//考勤系数
	
	@Column(field = "bzxs", type = "double(3, 2)")
	private Double BZXS;//标准系数
	
	@Column(field = "qydhcs", type = "int(16)")
	private int QYDHCS;//全院大会次数
	
	@Column(field = "xyzbcs", type = "int(16)")
	private int XYZBCS;//学院值班次数
	
	@Column(field = "bkjktj", type = "int(16)")
	private int BKJKTJ;//本科监考统计
	
	@Column(field = "xzpjj", type = "decimal(10, 2)")
	private BigDecimal XZPJJ;//行政平均奖
	
	@Column(field = "xypjj", type = "decimal(10, 2)")
	private BigDecimal XYPJJ;//学院平均奖
	
	@Column(field = "jthdbt", type = "decimal(10, 2)")
	private BigDecimal JTHDBT;//集体活动补贴
	
	@Column(field = "xyhbt", type = "decimal(10, 2)")
	private BigDecimal XYHBT;//校运会补贴
	
	@Column(field = "xwgjbt", type = "decimal(10, 2)")
	private BigDecimal XWGJBT;//新闻稿件补贴
	
	@Column(field = "hfbt", type = "decimal(10, 2)")
	private BigDecimal HFBT;//话费补贴
	
	@Column(field = "bzxcgjl", type = "decimal(10, 2)")
	private BigDecimal BZXCGJL;//标志性成果奖励
	
	@Column(field = "xxkhyxjl", type = "decimal(10, 2)")
	private BigDecimal XXKHYXJL;//学校考核优秀奖励
	
	@Column(field = "xypyjl", type = "decimal(10, 2)")
	private BigDecimal XYPYJL;//学院评优奖励
	
	@Column(field = "hdzjf", type = "decimal(10, 2)")
	private BigDecimal HDZJF;//活动组经费
	
	@Column(field = "jxdd", type = "decimal(10, 2)")
	private BigDecimal JXDD;//教学督导
	
	@Column(field = "khjc", type = "decimal(10, 2)")
	private BigDecimal KHJC;//考核奖惩
	
	@Column(field = "dypcjcj", type = "decimal(10, 2)")
	private BigDecimal DYPCJCJ;//第一批次奖酬金
	
	@Column(field = "depcjcj", type = "decimal(10, 2)")
	private BigDecimal DEPCJCJ;//第二批次奖酬金
	
	@Column(field = "jcjhj", type = "decimal(10, 2)")
	private BigDecimal JCJHJ;//奖酬金合计
	
	@Column(field = "ylbfhkcje", type = "decimal(10, 2)")
	private BigDecimal YLBFHKCJE;//预留补发或扣除金额
	
	@Column(field = "sjzjcj", type = "decimal(10, 2)")
	private BigDecimal SJZJCJ;//实际总奖酬金
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getDW() {
		return DW;
	}

	public void setDW(String dW) {
		DW = dW;
	}

	public String getGH() {
		return GH;
	}

	public void setGH(String gH) {
		GH = gH;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String xM) {
		XM = xM;
	}

	public Double getZGSJXS() {
		return ZGSJXS;
	}

	public void setZGSJXS(Double zGSJXS) {
		ZGSJXS = zGSJXS;
	}

	public Double getZWXS() {
		return ZWXS;
	}

	public void setZWXS(Double zWXS) {
		ZWXS = zWXS;
	}

	public Double getKQXS() {
		return KQXS;
	}

	public void setKQXS(Double kQXS) {
		KQXS = kQXS;
	}

	public Double getBZXS() {
		return BZXS;
	}

	public void setBZXS(Double bZXS) {
		BZXS = bZXS;
	}

	public int getQYDHCS() {
		return QYDHCS;
	}

	public void setQYDHCS(int qYDHCS) {
		QYDHCS = qYDHCS;
	}

	public int getXYZBCS() {
		return XYZBCS;
	}

	public void setXYZBCS(int xYZBCS) {
		XYZBCS = xYZBCS;
	}

	public int getBKJKTJ() {
		return BKJKTJ;
	}

	public void setBKJKTJ(int bKJKTJ) {
		BKJKTJ = bKJKTJ;
	}

	public BigDecimal getXZPJJ() {
		return XZPJJ;
	}

	public void setXZPJJ(BigDecimal xZPJJ) {
		XZPJJ = xZPJJ;
	}

	public BigDecimal getXYPJJ() {
		return XYPJJ;
	}

	public void setXYPJJ(BigDecimal xYPJJ) {
		XYPJJ = xYPJJ;
	}

	public BigDecimal getJTHDBT() {
		return JTHDBT;
	}

	public void setJTHDBT(BigDecimal jTHDBT) {
		JTHDBT = jTHDBT;
	}

	public BigDecimal getXYHBT() {
		return XYHBT;
	}

	public void setXYHBT(BigDecimal xYHBT) {
		XYHBT = xYHBT;
	}

	public BigDecimal getXWGJBT() {
		return XWGJBT;
	}

	public void setXWGJBT(BigDecimal xWGJBT) {
		XWGJBT = xWGJBT;
	}

	public BigDecimal getHFBT() {
		return HFBT;
	}

	public void setHFBT(BigDecimal hFBT) {
		HFBT = hFBT;
	}

	public BigDecimal getBZXCGJL() {
		return BZXCGJL;
	}

	public void setBZXCGJL(BigDecimal bZXCGJL) {
		BZXCGJL = bZXCGJL;
	}

	public BigDecimal getXXKHYXJL() {
		return XXKHYXJL;
	}

	public void setXXKHYXJL(BigDecimal xXKHYXJL) {
		XXKHYXJL = xXKHYXJL;
	}

	public BigDecimal getXYPYJL() {
		return XYPYJL;
	}

	public void setXYPYJL(BigDecimal xYPYJL) {
		XYPYJL = xYPYJL;
	}

	public BigDecimal getHDZJF() {
		return HDZJF;
	}

	public void setHDZJF(BigDecimal hDZJF) {
		HDZJF = hDZJF;
	}

	public BigDecimal getJXDD() {
		return JXDD;
	}

	public void setJXDD(BigDecimal jXDD) {
		JXDD = jXDD;
	}

	public BigDecimal getKHJC() {
		return KHJC;
	}

	public void setKHJC(BigDecimal kHJC) {
		KHJC = kHJC;
	}

	public BigDecimal getDYPCJCJ() {
		return DYPCJCJ;
	}

	public void setDYPCJCJ(BigDecimal dYPCJCJ) {
		DYPCJCJ = dYPCJCJ;
	}

	public BigDecimal getDEPCJCJ() {
		return DEPCJCJ;
	}

	public void setDEPCJCJ(BigDecimal dEPCJCJ) {
		DEPCJCJ = dEPCJCJ;
	}

	public BigDecimal getJCJHJ() {
		return JCJHJ;
	}

	public void setJCJHJ(BigDecimal jCJHJ) {
		JCJHJ = jCJHJ;
	}

	public BigDecimal getYLBFHKCJE() {
		return YLBFHKCJE;
	}

	public void setYLBFHKCJE(BigDecimal yLBFHKCJE) {
		YLBFHKCJE = yLBFHKCJE;
	}

	public BigDecimal getSJZJCJ() {
		return SJZJCJ;
	}

	public void setSJZJCJ(BigDecimal sJZJCJ) {
		SJZJCJ = sJZJCJ;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
