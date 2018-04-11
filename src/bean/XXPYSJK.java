package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
import java.math.BigDecimal;

@Table(tableName="t_xxpysjk")
public class XXPYSJK {

	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="xxkhyx", type="decimal(10,2)")
	private BigDecimal XXKHYX;//学校考核优秀
	
	@Column(field="jlhj", type="decimal(10,2)")
	private BigDecimal JLHJ;//奖励合计
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public XXPYSJK() {
		ID = UUID.randomUUID().toString();
		RYDM = "";
		XM = "";
		XXKHYX = new BigDecimal("0.00");
		JLHJ = new BigDecimal("0.00");
		ISDEL = 2;
	}

	public String toJson() {
		return "[{\"id\":\"" + ID + "\", \"rydm\":\"" + RYDM + "\", \"xm\":\"" + XM 
				+ "\", \"xxkhyx\":" + XXKHYX + ", \"jlhj\":" + JLHJ + ", \"isdel\":"
				+ ISDEL + "}]";
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

	public BigDecimal getXXKHYX() {
		return XXKHYX;
	}

	public void setXXKHYX(BigDecimal xXKHYX) {
		XXKHYX = xXKHYX;
	}

	public BigDecimal getJLHJ() {
		return JLHJ;
	}

	public void setJLHJ(BigDecimal jLHJ) {
		JLHJ = jLHJ;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
