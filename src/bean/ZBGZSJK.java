package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
import java.math.BigDecimal;

@Table(tableName="t_zbgzsjk")
public class ZBGZSJK {

	@Column(field="id", type="varchar(100)", primaryKey = true, defaultNull = false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="zbcs", type="int")
	private int ZBCS;//值班次数
	
	@Column(field="ffje", type="decimal(10,2)")
	private BigDecimal FFJE;//发放金额
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public ZBGZSJK() {
		ID = UUID.randomUUID().toString();
		RYDM = "";
		XM = "";
		ZBCS = 0;
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

	public int getZBCS() {
		return ZBCS;
	}

	public void setZBCS(int zBCS) {
		ZBCS = zBCS;
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
