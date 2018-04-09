package bean;

import annotation.Table;

import java.math.BigDecimal;

import annotation.Column;
/**
 * 专任教师人员
 * @author simple
 *
 */

@Table(tableName="t_zrjsry")
public class ZRJSRY {
	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//主键，自增
	
	@Column(field = "jys", type = "varchar(50)")
	private String JYS;//教研室
	
	@Column(field = "gh", type = "varchar(15)")
	private String GH;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "zc", type = "varchar(25)")
	private String ZC;//职称
	
	@Column(field = "gwxz", type = "varchar(25)" )
	private String GWXZ;//岗位性质
	
	@Column(field = "zgqksm", type = "varchar(200)")
	private String ZGQKSM;//在岗情况说明
	
	@Column(field = "jjmgzlqk", type = "varchar(50)")
	private String JJMGZLQK;//加减免工作量情况
	
	@Column(field = "zgsjxs", type = "double(3,2)")
	private Double ZGSJXS;//在岗时间系数
	
	@Column(field = "khgzl", type = "double(10,2)")
	private Double KHGZL;//考核工作量
	
	@Column(field = "btgzl", type = "double(10,2)")
	private Double BTGZL;//补贴工作量
	
	@Column(field = "bksgzl", type = "double(10,2)")
	private Double BKSGZL;//本科生工作量
	
	@Column(field = "yjsgzl", type = "double(10, 2)")
	private Double YJSGZL;//研究生工作量
	
	@Column(field = "zgzlhj", type = "double(10, 2)")
	private Double ZGZLHJ;//总工作量合计
	
	@Column(field = "cgzl", type = "double(10, 2)")
	private Double CGZL;//超工作量
	
	@Column(field = "xyhycjcs", type = "int(16)")
	private int XYHYCJCS;//学院会议参加次数
	
	@Column(field = "bkjktj", type = "int(16)")
	private int BKJKTJ;//本科监考统计
	
	@Column(field = "xyzbcs", type = "int(16)")
	private int XYZBCS;//学院值班次数
	
	@Column(field = "cgzljcj", type = "decimal(10,2)")
	private BigDecimal CGZLJCJ;//超工作量奖酬金
	
	@Column(field = "kyjj", type = "decimal(10, 2)")
	private BigDecimal KYJJ;//科研奖金
	
	@Column(field = "rjj", type = "decimal(10, 2)")
	private BigDecimal RJJ;//人均奖
	
	@Column(field = "khyxjj", type = "decimal(10, 2)")
	private BigDecimal KHYXJJ;//考核优秀奖
	
	@Column(field = "zhtxgrdfjl", type = "decimal(10, 2)")
	private BigDecimal ZHTXGRDFJL;//综合体系个人得分奖励
	
	@Column(field = "bzxcgjl", type = "decimal(10, 2)")
	private BigDecimal BZXCGJL;//标志性成果奖励
	
	@Column(field = "jxddbt", type = "decimal(10, 2)")
	private BigDecimal JXDDBT;//教学督导补贴
	
	@Column(field = "dbbt", type = "decimal(10, 2)")
	private BigDecimal DBBT;//读博补贴
	
	@Column(field = "yxpy", type = "decimal(10, 2)")
	private BigDecimal YXPY;//院系评优
	
	@Column(field = "jsxlshfwjj", type = "decimal(10, 2)")
	private BigDecimal JSXLSHFWJJ;//竞赛训练社会服务奖金
	
	@Column(field = "jthdbthj", type = "decimal(10, 2)")
	private BigDecimal JTHDBTHJ;//集体活动补贴合计
	
	@Column(field = "xyhbt", type = "decimal(10, 2)")
	private BigDecimal XYHBT;//校运会补贴
	
	@Column(field = "hfbt", type = "decimal(10, 2)")
	private BigDecimal HFBT;//话费补贴
	
	@Column(field = "xwgjbt", type = "decimal(10, 2)")
	private BigDecimal XWGJBT;//新闻稿件补贴
	
	@Column(field = "sjtdebt", type = "decimal(10, 2)")
	private BigDecimal SJTDEBT;//双肩挑定额补贴
	
	@Column(field = "cgfzrjlhjtbce", type = "decimal(10, 2)")
	private BigDecimal CGFZRJLhJTBCE;//场馆负责人和津贴补差额
	
	@Column(field = "csryjl", type = "decimal(10, 2)")
	private BigDecimal CSRYJL;//创收人员奖励
	
	@Column(field = "hdzjf", type = "decimal(10, 2)")
	private BigDecimal HDZJF;//活动组经费
	
	@Column(field = "dypcjcj", type = "decimal(10, 2)")
	private BigDecimal DYPCJCJ;//第一批次奖酬金
	
	@Column(field = "depcrjj", type = "decimal(10, 2)")
	private BigDecimal DEPCRJJ;//第二批次人均奖
	
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

	public String getJYS() {
		return JYS;
	}

	public void setJYS(String jYS) {
		JYS = jYS;
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

	public String getZC() {
		return ZC;
	}

	public void setZC(String zC) {
		ZC = zC;
	}

	public String getGWXZ() {
		return GWXZ;
	}

	public void setGWXZ(String gWXZ) {
		GWXZ = gWXZ;
	}

	public String getZGQKSM() {
		return ZGQKSM;
	}

	public void setZGQKSM(String zGQKSM) {
		ZGQKSM = zGQKSM;
	}

	public String getJJMGZLQK() {
		return JJMGZLQK;
	}

	public void setJJMGZLQK(String jJMGZLQK) {
		JJMGZLQK = jJMGZLQK;
	}

	public Double getZGSJXS() {
		return ZGSJXS;
	}

	public void setZGSJXS(Double zGSJXS) {
		ZGSJXS = zGSJXS;
	}

	public Double getKHGZL() {
		return KHGZL;
	}

	public void setKHGZL(Double kHGZL) {
		KHGZL = kHGZL;
	}

	public Double getBTGZL() {
		return BTGZL;
	}

	public void setBTGZL(Double bTGZL) {
		BTGZL = bTGZL;
	}

	public Double getBKSGZL() {
		return BKSGZL;
	}

	public void setBKSGZL(Double bKSGZL) {
		BKSGZL = bKSGZL;
	}

	public Double getYJSGZL() {
		return YJSGZL;
	}

	public void setYJSGZL(Double yJSGZL) {
		YJSGZL = yJSGZL;
	}

	public Double getZGZLHJ() {
		return ZGZLHJ;
	}

	public void setZGZLHJ(Double zGZLHJ) {
		ZGZLHJ = zGZLHJ;
	}

	public Double getCGZL() {
		return CGZL;
	}

	public void setCGZL(Double cGZL) {
		CGZL = cGZL;
	}

	public int getXYHYCJCS() {
		return XYHYCJCS;
	}

	public void setXYHYCJCS(int xYHYCJCS) {
		XYHYCJCS = xYHYCJCS;
	}

	public int getBKJKTJ() {
		return BKJKTJ;
	}

	public void setBKJKTJ(int bKJKTJ) {
		BKJKTJ = bKJKTJ;
	}

	public int getXYZBCS() {
		return XYZBCS;
	}

	public void setXYZBCS(int xYZBCS) {
		XYZBCS = xYZBCS;
	}

	public BigDecimal getCGZLJCJ() {
		return CGZLJCJ;
	}

	public void setCGZLJCJ(BigDecimal cGZLJCJ) {
		CGZLJCJ = cGZLJCJ;
	}

	public BigDecimal getKYJJ() {
		return KYJJ;
	}

	public void setKYJJ(BigDecimal kYJJ) {
		KYJJ = kYJJ;
	}

	public BigDecimal getRJJ() {
		return RJJ;
	}

	public void setRJJ(BigDecimal rJJ) {
		RJJ = rJJ;
	}

	public BigDecimal getKHYXJJ() {
		return KHYXJJ;
	}

	public void setKHYXJJ(BigDecimal kHYXJJ) {
		KHYXJJ = kHYXJJ;
	}

	public BigDecimal getZHTXGRDFJL() {
		return ZHTXGRDFJL;
	}

	public void setZHTXGRDFJL(BigDecimal zHTXGRDFJL) {
		ZHTXGRDFJL = zHTXGRDFJL;
	}

	public BigDecimal getBZXCGJL() {
		return BZXCGJL;
	}

	public void setBZXCGJL(BigDecimal bZXCGJL) {
		BZXCGJL = bZXCGJL;
	}

	public BigDecimal getJXDDBT() {
		return JXDDBT;
	}

	public void setJXDDBT(BigDecimal jXDDBT) {
		JXDDBT = jXDDBT;
	}

	public BigDecimal getDBBT() {
		return DBBT;
	}

	public void setDBBT(BigDecimal dBBT) {
		DBBT = dBBT;
	}

	public BigDecimal getYXPY() {
		return YXPY;
	}

	public void setYXPY(BigDecimal yXPY) {
		YXPY = yXPY;
	}

	public BigDecimal getJSXLSHFWJJ() {
		return JSXLSHFWJJ;
	}

	public void setJSXLSHFWJJ(BigDecimal jSXLSHFWJJ) {
		JSXLSHFWJJ = jSXLSHFWJJ;
	}

	public BigDecimal getJTHDBTHJ() {
		return JTHDBTHJ;
	}

	public void setJTHDBTHJ(BigDecimal jTHDBTHJ) {
		JTHDBTHJ = jTHDBTHJ;
	}

	public BigDecimal getXYHBT() {
		return XYHBT;
	}

	public void setXYHBT(BigDecimal xYHBT) {
		XYHBT = xYHBT;
	}

	public BigDecimal getHFBT() {
		return HFBT;
	}

	public void setHFBT(BigDecimal hFBT) {
		HFBT = hFBT;
	}

	public BigDecimal getXWGJBT() {
		return XWGJBT;
	}

	public void setXWGJBT(BigDecimal xWGJBT) {
		XWGJBT = xWGJBT;
	}

	public BigDecimal getSJTDEBT() {
		return SJTDEBT;
	}

	public void setSJTDEBT(BigDecimal sJTDEBT) {
		SJTDEBT = sJTDEBT;
	}

	public BigDecimal getCGFZRJLhJTBCE() {
		return CGFZRJLhJTBCE;
	}

	public void setCGFZRJLhJTBCE(BigDecimal cGFZRJLhJTBCE) {
		CGFZRJLhJTBCE = cGFZRJLhJTBCE;
	}

	public BigDecimal getCSRYJL() {
		return CSRYJL;
	}

	public void setCSRYJL(BigDecimal cSRYJL) {
		CSRYJL = cSRYJL;
	}

	public BigDecimal getHDZJF() {
		return HDZJF;
	}

	public void setHDZJF(BigDecimal hDZJF) {
		HDZJF = hDZJF;
	}

	public BigDecimal getDYPCJCJ() {
		return DYPCJCJ;
	}

	public void setDYPCJCJ(BigDecimal dYPCJCJ) {
		DYPCJCJ = dYPCJCJ;
	}

	public BigDecimal getDEPCRJJ() {
		return DEPCRJJ;
	}

	public void setDEPCRJJ(BigDecimal dEPCRJJ) {
		DEPCRJJ = dEPCRJJ;
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
