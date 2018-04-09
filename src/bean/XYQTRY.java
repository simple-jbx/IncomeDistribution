package bean;

import annotation.Column;
import annotation.Table;
import java.math.BigDecimal;

/**
 * 学院其他人员
 * @author simple
 *
 */

@Table(tableName="t_xyqtry")
public class XYQTRY {
	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//主键，自增
	
	@Column(field = "gh", type = "varchar(15)")
	private String GH;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "zb", type = "varchar(50)")
	private String ZB;//职别
	
	@Column(field = "cgzl", type = "double(3, 2)")
	private double CGZL;//超工作量
	
	@Column(field = "cgzljl", type = "decimal(10, 2)")
	private BigDecimal CGZLJL;//超工作量奖励
	
	@Column(field = "jxdd", type = "decimal(10, 2)")
	private BigDecimal JXDD;//教学督导
	
	@Column(field = "jthd", type = "decimal(10, 2)")
	private BigDecimal JTHD;//集体活动
	
	@Column(field = "jcjhj", type = "decimal(10, 2)")
	private BigDecimal JCJHJ;//奖酬金合计
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

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

	public double getCGZL() {
		return CGZL;
	}

	public void setCGZL(double cGZL) {
		CGZL = cGZL;
	}

	public BigDecimal getCGZLJL() {
		return CGZLJL;
	}

	public void setCGZLJL(BigDecimal cGZLJL) {
		CGZLJL = cGZLJL;
	}

	public BigDecimal getJXDD() {
		return JXDD;
	}

	public void setJXDD(BigDecimal jXDD) {
		JXDD = jXDD;
	}

	public BigDecimal getJTHD() {
		return JTHD;
	}

	public void setJTHD(BigDecimal jTHD) {
		JTHD = jTHD;
	}

	public BigDecimal getJCJHJ() {
		return JCJHJ;
	}

	public void setJCJHJ(BigDecimal jCJHJ) {
		JCJHJ = jCJHJ;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
