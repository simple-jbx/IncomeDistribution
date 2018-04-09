package bean;

import annotation.Column;
import annotation.Table;
import java.math.BigDecimal;

/**
 * 新闻补贴数据
 * @author simple
 *
 */

@Table(tableName = "t_xwbtsj")
public class XWBTSJ {

	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id 主键
	
	@Column(field = "gh", type = "varchar(15)")
	private String GH;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "xwnr", type = "varchar(500)")
	private String XWNR;//新闻内容
	
	@Column(field = "cs", type = "int(4)")
	private int CS;//次数
	
	@Column(field = "bz", type = "decimal(10, 2)")
	private BigDecimal BZ;//标准
	
	@Column(field = "sfje", type = "decimal(10, 2)")
	private BigDecimal SFJE;//实发金额
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getGH() {
		return GH;
	}

	public void setGH(String gH) {
		GH = gH;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String xM) {
		XM = xM;
	}

	public String getXWNR() {
		return XWNR;
	}

	public void setXWNR(String xWNR) {
		XWNR = xWNR;
	}

	public int getCS() {
		return CS;
	}

	public void setCS(int cS) {
		CS = cS;
	}

	public BigDecimal getBZ() {
		return BZ;
	}

	public void setBZ(BigDecimal bZ) {
		BZ = bZ;
	}

	public BigDecimal getSFJE() {
		return SFJE;
	}

	public void setSFJE(BigDecimal sFJE) {
		SFJE = sFJE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
