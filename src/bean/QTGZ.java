package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
import java.math.BigDecimal;

@Table(tableName="t_qtgz")
public class QTGZ {

	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="xm", type="varchar(100)")
	private String XM;
	
	@Column(field="je", type="decimal(10,2)")
	private BigDecimal JE;//金额
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	@Column(field="fl", type="varchar(100)")
	private String FL;//分类
	
	@Column(field="mc", type="varchar(100)")
	private String MC;//名称
	
	public QTGZ() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		XM = "";
		JE = new BigDecimal("0.00");
		ISDEL = 2;
		FL = "";
		MC = "";
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String xM) {
		XM = xM;
	}

	public BigDecimal getJE() {
		return JE;
	}

	public void setJE(BigDecimal jE) {
		JE = jE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}

	public String getFL() {
		return FL;
	}

	public void setFL(String fL) {
		FL = fL;
	}

	public String getMC() {
		return MC;
	}

	public void setMC(String mC) {
		MC = mC;
	}
}
