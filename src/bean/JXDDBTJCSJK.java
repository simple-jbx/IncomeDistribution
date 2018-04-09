package bean;

import java.math.BigDecimal;
import java.util.UUID;

import annotation.Column;
import annotation.Table;

/**
 * 教学督导补贴基础数据库
 * @author simple
 *
 */

@Table(tableName = "t_jxddbtjcsjk")
public class JXDDBTJCSJK {
	@Column(field = "id", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String ID;//ID
	
	@Column(field = "rydm", type = "varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "jxdd", type = "decimal(10,2)")
	private BigDecimal JXDD;//教学督导
	
	@Column(field = "hj", type = "decimal(10,2)")
	private BigDecimal HJ;//合计
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public JXDDBTJCSJK() {
		ID = UUID.randomUUID().toString();
		RYDM = "";
		XM = "";
		JXDD = new BigDecimal("0.00");
		HJ = new BigDecimal("0.00");
		ISDEL = 2;
	}

	public String toJson() {
	    return "[{\"id\":\"" + ID + "\", \"rydm\":\"" + RYDM + "\", \"xm\":\""
	    + XM + "\",\"jxdd\":" +JXDD + ",\"hj\":" + HJ + "\",\"isdel\":" + ISDEL +"}]";
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

	public BigDecimal getJXDD() {
		return JXDD;
	}

	public void setJXDD(BigDecimal jXDD) {
		JXDD = jXDD;
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
