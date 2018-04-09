package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
import java.math.BigDecimal;

/**
 * 指标体系补贴数据库
 * @author simple
 *
 */

@Table(tableName="t_zbtxbtsjk")
public class ZBTXBTSJK {

	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="dfxm", type="text")
	private String DFXM;//得分项目
	
	@Column(field="nx", type="varchar(20)")
	private String NX;//年限
	
	@Column(field="jlje", type="decimal(10,2)")
	private BigDecimal JLJE;//奖励金额
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public ZBTXBTSJK() {
		ID = UUID.randomUUID().toString();
		RYDM = "";
		XM = "";
		DFXM = "";
		NX = "";
		JLJE = new BigDecimal("0.00");
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

	public String getDFXM() {
		return DFXM;
	}

	public void setDFXM(String dFXM) {
		DFXM = dFXM;
	}

	public String getNX() {
		return NX;
	}

	public void setNX(String nX) {
		NX = nX;
	}

	public BigDecimal getJLJE() {
		return JLJE;
	}

	public void setJLJE(BigDecimal jLJE) {
		JLJE = jLJE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
