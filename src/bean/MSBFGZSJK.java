package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
import java.math.BigDecimal;

@Table(tableName="t_msbfgzsjk")
public class MSBFGZSJK {

	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="msdsgzl", type="double(10,2)")
	private double MSDSGZL;//免师导师工作量
	
	@Column(field="gzlbzj", type="decimal(10,2)")
	private BigDecimal GZLBZJ;//工作量标准金
	
	@Column(field="ffje", type="decimal(10,2)")
	private BigDecimal FFJE;//发放金额
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public MSBFGZSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "";
		XM = "";
		MSDSGZL = 0.00;
		GZLBZJ = new BigDecimal("0.00");
		FFJE = new BigDecimal("0.00");
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

	public double getMSDSGZL() {
		return MSDSGZL;
	}

	public void setMSDSGZL(double mSDSGZL) {
		MSDSGZL = mSDSGZL;
	}

	public BigDecimal getGZLBZJ() {
		return GZLBZJ;
	}

	public void setGZLBZJ(BigDecimal gZLBZJ) {
		GZLBZJ = gZLBZJ;
	}

	public BigDecimal getFFJE() {
		return FFJE;
	}

	public void setFFJE(BigDecimal fFJE) {
		FFJE = fFJE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
