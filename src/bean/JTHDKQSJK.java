package bean;

import annotation.Column;
import annotation.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Table(tableName="t_jthdkqsjk")
public class JTHDKQSJK {

	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="wgwd", type="int")
	private int WGWD;//无故未到
	
	@Column(field="grsj", type="int")
	private int GRSJ;//个人事假
	
	@Column(field="jey", type="decimal(10,2)")
	private BigDecimal JEY;//金额1
	
	@Column(field="jee", type="decimal(10,2)")
	private BigDecimal JEE;//金额2
	
	@Column(field="hjje", type="decimal(10,2)")
	private BigDecimal HJJE;//合计金额
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	
	public JTHDKQSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "";
		XM = "";
		WGWD = 0;
		GRSJ = 0;
		JEY = new BigDecimal("0.00");
		JEE = new BigDecimal("0.00");
		HJJE = new BigDecimal("0.00");
		ISDEL = 2;
	}
	
	public String toJson() {
		return "[{\"id\":\"" + ID + "\", \"rydm\":\"" + RYDM + "\", \"xm\":\"" + XM 
				+"\", \"wgwd\":" + WGWD + ", \"grsj\":" + GRSJ + ", \"jey\":" + JEY
				+", \"jee\":" + JEE + ", \"hjje\":" + HJJE + ", \"isdel\":" + ISDEL
				+"}]";
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

	public int getWGWD() {
		return WGWD;
	}

	public void setWGWD(int wGWD) {
		WGWD = wGWD;
	}

	public int getGRSJ() {
		return GRSJ;
	}

	public void setGRSJ(int gRSJ) {
		GRSJ = gRSJ;
	}

	public BigDecimal getJEY() {
		return JEY;
	}

	public void setJEY(BigDecimal jEY) {
		HJJE = JEY.add(JEE);
		JEY = jEY;
	}

	public BigDecimal getJEE() {
		return JEE;
	}

	public void setJEE(BigDecimal jEE) {
		HJJE = JEY.add(JEE);
		JEE = jEE;
	}

	public BigDecimal getHJJE() {
		return HJJE;
	}

	public void setHJJE(BigDecimal hJJE) {
		HJJE = hJJE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
