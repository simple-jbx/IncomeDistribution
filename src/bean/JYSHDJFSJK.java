package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
import java.math.BigDecimal;

@Table(tableName="t_jyshdjfsjk")
public class JYSHDJFSJK {
	
	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="jyshdjf", type="decimal(10,2)")
	private BigDecimal JYSHDJF;//教研室活动经费
	
	@Column(field="jc", type="decimal(10,2)")
	private BigDecimal JC;//奖惩
	
	@Column(field="hj", type="decimal(10,2)")
	private BigDecimal HJ;//合计
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public JYSHDJFSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "";
		XM = "";
		JYSHDJF = new BigDecimal("0.00");
		JC = new BigDecimal("0.00");
		HJ = new BigDecimal("0.00");
		ISDEL = 2;
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

	public BigDecimal getJYSHDJF() {
		return JYSHDJF;
	}

	public void setJYSHDJF(BigDecimal jYSHDJF) {
		JYSHDJF = jYSHDJF;
	}

	public BigDecimal getJC() {
		return JC;
	}

	public void setJC(BigDecimal jC) {
		JC = jC;
	}

	public BigDecimal getHJ() {
		return HJ;
	}

	public void setHJ(BigDecimal hJ) {
		HJ = hJ;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
