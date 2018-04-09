package bean;

import annotation.Column;
import annotation.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Table(tableName="t_zhglzbsx")
public class ZHGLZBSX {
	@Column(field = "id", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String ID;//主键，自增
	
	@Column(field = "zhglzbsx", type = "varchar(100)")
	private String ZHGLZBSX;//综合管理指标时效
	
	@Column(field = "jlje", type = "decimal(10,2)")
	private BigDecimal JLJE;//奖励金额
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public ZHGLZBSX() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		ZHGLZBSX = "-";
		JLJE = new BigDecimal("0.00");
		ISDEL = 2;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getZHGLZBSX() {
		return ZHGLZBSX;
	}

	public void setZHGLZBSX(String zHGLZBSX) {
		ZHGLZBSX = zHGLZBSX;
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
