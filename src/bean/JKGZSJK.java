package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
import java.math.BigDecimal;

/**
 * 监考工作数据表
 * @author simple
 *
 */
@Table(tableName="t_jkgzsjk")
public class JKGZSJK {

	@Column(field = "id", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String ID;//id
	
	@Column(field = "rydm", type = "varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "jkcs", type = "int")
	private int JKCS;//监考次数
	
	@Column(field = "je", type = "decimal(10,2)")
	private BigDecimal JE;//金额
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public JKGZSJK() {
		ID = UUID.randomUUID().toString();
		RYDM = "";
		XM = "";
		JKCS = 0;
		JE = new BigDecimal("0.00");
		ISDEL = 2;
	}

	public String toJson() {
		return "[{\"id\":\"" + ID + "\",\"rydm\":\"" + RYDM + "\",\"xm\":\"" + XM + 
				"\",\"jkcs\"" + JKCS + ",\"je\":" + JE + ",\"isdel\"" + ISDEL + "}]";
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

	public int getJKCS() {
		return JKCS;
	}

	public void setJKCS(int jKCS) {
		JKCS = jKCS;
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
}
