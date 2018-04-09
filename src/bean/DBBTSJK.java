package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
import java.math.BigDecimal;

@Table(tableName="t_dbbtsjk")
public class DBBTSJK {

	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="db", type="decimal(10,2)")
	private BigDecimal DB;//读博
	
	@Column(field="hj", type="decimal(10,2)")
	private BigDecimal HJ;//合计
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public DBBTSJK() {
		ID = UUID.randomUUID().toString();
		RYDM = "";
		XM = "";
		DB = new BigDecimal("0.00");
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

	public BigDecimal getDB() {
		return DB;
	}

	public void setDB(BigDecimal dB) {
		DB = dB;
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
