package bean;

import annotation.Column;
import annotation.Table;
import java.math.BigDecimal;

/**
 * 工勤人员
 * @author simple
 *
 */

@Table(tableName="t_gqry")
public class GQRY {
	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//主键，自增
	
	@Column(field = "gh", type = "varchar(15)")
	private String GH;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "zb", type = "varchar(50)")
	private String ZB;//职别
	
	@Column(field = "gw", type = "varchar(50)")
	private String GW;//岗位
	
	@Column(field = "zgsjxs", type = "double(3,2)")
	private Double ZGSJXS;//在岗时间系数
	
	@Column(field = "zcxs", type = "double(3, 2)")
	private Double ZCXS;//职称系数
	
	@Column(field = "kqxs", type = "double(3, 2)")
	private Double KQXS;//考勤系数
	
	@Column(field = "fpxs", type = "double(3, 2)")
	private Double FPXS;//考勤系数
	
	@Column(field = "nzbzjj", type = "decimal(10, 2)")
	private BigDecimal NZBZJJ;//年终标准奖金
	
	@Column(field = "jthdcs", type = "int(16)")
	private int JTHDCS;//集体活动次数
	
	@Column(field = "sfpjjl", type = "decimal(10, 2)")
	private BigDecimal SFPJJL;//实发平均奖励
	
	@Column(field = "xypyjl", type = "decimal(10, 2)")
	private BigDecimal XYPYJL;//学院评优奖励
	
	@Column(field = "jthdbt", type = "decimal(10, 2)")
	private BigDecimal JTHDBT;//集体活动补贴
	
	@Column(field = "xyhbt", type = "decimal(10, 2)")
	private BigDecimal XYHBT;//校运会补贴
	
	@Column(field = "khjc", type = "decimal(10, 2)")
	private BigDecimal KHJC;//考核奖惩
	
	@Column(field = "dycfpjcjhj", type = "decimal(10, 2)")
	private BigDecimal DYCFPJCJHJ;//第一次分配奖酬金合计
	
	@Column(field = "decfpjcjhj", type = "decimal(10, 2)")
	private BigDecimal DECFPJCJHJ;//第二次分配奖酬金合计
	
	@Column(field = "hjje", type = "decimal(10, 2)")
	private BigDecimal HJJE;//合计金额
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public GQRY() {
		ID = 0;
		GH = "";
		XM = "";
		ZB = "";
		GW = "";
		ZGSJXS = 0.00;
		ZCXS = 0.00;
		KQXS = 0.00;
		FPXS = 0.00;
		NZBZJJ = new BigDecimal("0.00");
		JTHDCS = 0;
		SFPJJL = new BigDecimal("0.00");
		XYPYJL = new BigDecimal("0.00");
		JTHDBT = new BigDecimal("0.00");
		XYHBT = new BigDecimal("0.00");
		KHJC = new BigDecimal("0.00");
		DYCFPJCJHJ = new BigDecimal("0.00");
		DECFPJCJHJ = new BigDecimal("0.00");
		HJJE = new BigDecimal("0.00");
		ISDEL = 0;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public String getZB() {
		return ZB;
	}

	public void setZB(String zB) {
		ZB = zB;
	}

	public String getGW() {
		return GW;
	}

	public void setGW(String gW) {
		GW = gW;
	}

	public Double getZGSJXS() {
		return ZGSJXS;
	}

	public void setZGSJXS(Double zGSJXS) {
		ZGSJXS = zGSJXS;
	}

	public Double getZCXS() {
		return ZCXS;
	}

	public void setZCXS(Double zCXS) {
		ZCXS = zCXS;
	}

	public Double getKQXS() {
		return KQXS;
	}

	public void setKQXS(Double kQXS) {
		KQXS = kQXS;
	}

	public Double getFPXS() {
		return FPXS;
	}

	public void setFPXS(Double fPXS) {
		FPXS = fPXS;
	}

	public BigDecimal getNZBZJJ() {
		return NZBZJJ;
	}

	public void setNZBZJJ(BigDecimal nZBZJJ) {
		NZBZJJ = nZBZJJ;
	}

	public int getJTHDCS() {
		return JTHDCS;
	}

	public void setJTHDCS(int jTHDCS) {
		JTHDCS = jTHDCS;
	}

	public BigDecimal getSFPJJL() {
		return SFPJJL;
	}

	public void setSFPJJL(BigDecimal sFPJJL) {
		SFPJJL = sFPJJL;
	}

	public BigDecimal getXYPYJL() {
		return XYPYJL;
	}

	public void setXYPYJL(BigDecimal xYPYJL) {
		XYPYJL = xYPYJL;
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

	public BigDecimal getKHJC() {
		return KHJC;
	}

	public void setKHJC(BigDecimal kHJC) {
		KHJC = kHJC;
	}

	public BigDecimal getDYCFPJCJHJ() {
		return DYCFPJCJHJ;
	}

	public void setDYCFPJCJHJ(BigDecimal dYCFPJCJHJ) {
		DYCFPJCJHJ = dYCFPJCJHJ;
	}

	public BigDecimal getDECFPJCJHJ() {
		return DECFPJCJHJ;
	}

	public void setDECFPJCJHJ(BigDecimal dECFPJCJHJ) {
		DECFPJCJHJ = dECFPJCJHJ;
	}

	public BigDecimal getHJJE() {
		return HJJE;
	}

	public void setHJJE(BigDecimal hJJE) {
		HJJE = hJJE;
	}
	
	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
