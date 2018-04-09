package bean;

import annotation.Column;
import annotation.Table;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * 竞赛训练及社会服务数据
 * @author simple
 *
 */

@Table(tableName = "t_jsxljshfwsj")
public class JSXLJSHFWSJ {
	
	@Column(field = "id", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String ID;//id,主键,自增
	
	@Column(field = "gh", type = "varchar(50)")
	private String GH;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "jsjf", type = "double(10,2)")
	private double JSJF;//竞赛计分
	
	@Column(field = "shfwjf", type = "double(10,2)")
	private double SHFWJF;//社会服务计分
	
	@Column(field = "zf", type = "double(10, 2)")
	private double ZF;//总分
	
	@Column(field = "jlje", type = "decimal(10,2)")
	private BigDecimal JLJE;//奖励金额
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public JSXLJSHFWSJ() {
		ID = UUID.randomUUID().toString();
		XM = "";
		JSJF = 0.00;
		SHFWJF = 0.00;
		ZF = 0.00;
		JLJE = new BigDecimal("0.00");
		ISDEL = 2;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
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

	public double getJSJF() {
		return JSJF;
	}

	public void setJSJF(double jSJF) {
		JSJF = jSJF;
	}

	public double getSHFWJF() {
		return SHFWJF;
	}

	public void setSHFWJF(double sHFWJF) {
		SHFWJF = sHFWJF;
	}

	public double getZF() {
		return ZF;
	}

	public void setZF(double zF) {
		ZF = zF;
	}

	public BigDecimal getJLJE() {
		return JLJE;
	}

	public void setJLJE(BigDecimal jLJE) {
		JLJE = jLJE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
