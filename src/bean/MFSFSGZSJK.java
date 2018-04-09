package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
import java.math.BigDecimal;

@Table(tableName="t_mfsfsgzsjk")
public class MFSFSGZSJK {
	
	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="zdgzlhj", type="int")
	private int ZDGZLHJ;//指导工作量合计
	
	@Column(field="gzlcj", type="decimal(10,2)")
	private BigDecimal GZLCJ;//工作量酬金
	
	@Column(field="sqskksf", type="decimal(10,2)")
	private BigDecimal SQSKKSF;//暑期授课课时费
	
	@Column(field="pgzylc", type="decimal(10,2)")
	private BigDecimal PGZYLC;//批改作业劳酬
	
	@Column(field="sqzbf", type="decimal(10,2)")
	private BigDecimal SQZBF;//暑期值班费
	
	@Column(field="hj", type="decimal(10,2)")
	private BigDecimal HJ;//合计
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public MFSFSGZSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "";
		XM = "";
		ZDGZLHJ = 0;
		GZLCJ = new BigDecimal("0.00");
		SQSKKSF = new BigDecimal("0.00");
		PGZYLC = new BigDecimal("0.00");
		SQZBF = new BigDecimal("0.00");
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

	public int getZDGZLHJ() {
		return ZDGZLHJ;
	}

	public void setZDGZLHJ(int zDGZLHJ) {
		ZDGZLHJ = zDGZLHJ;
	}

	public BigDecimal getGZLCJ() {
		return GZLCJ;
	}

	public void setGZLCJ(BigDecimal gZLCJ) {
		GZLCJ = gZLCJ;
	}

	public BigDecimal getSQSKKSF() {
		return SQSKKSF;
	}

	public void setSQSKKSF(BigDecimal sQSKKSF) {
		SQSKKSF = sQSKKSF;
	}

	public BigDecimal getPGZYLC() {
		return PGZYLC;
	}

	public void setPGZYLC(BigDecimal pGZYLC) {
		PGZYLC = pGZYLC;
	}

	public BigDecimal getSQZBF() {
		return SQZBF;
	}

	public void setSQZBF(BigDecimal sQZBF) {
		SQZBF = sQZBF;
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
