package bean;

import annotation.Column;
import annotation.Table;
import java.math.BigDecimal;

@Table(tableName = "t_xm")
public class XM {

	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id 主键
	
	@Column(field = "xmmc", type = "varchar(100)")
	private String XMMC;//项目名称
	
	@Column(field = "fzr", type = "varchar(50)")
	private String FZR;//负责人
	
	@Column(field = "xmcy", type = "varchar(300)")
	private String XMCY;//项目成员
	
	@Column(field = "zzsx", type = "varchar(200)")
	private String ZZSX;//作者属性
	
	@Column(field = "xmxz", type = "varchar(100)")
	private String XMXZ;//项目性质
	
	@Column(field = "xmfl", type = "varchar(100)")
	private String XMFL;//项目分类
	
	@Column(field = "xmjb", type = "varchar(50)")
	private String XMJB;//项目级别
	
	@Column(field = "lxrq", type = "varchar(20)")
	private String LXRQ;//立项日期
	
	@Column(field = "htjf", type = "decimal(10, 2)")
	private BigDecimal HTJF;//合同经费
	
	@Column(field = "xmly", type = "varchar(100)")
	private String XMLY;//项目来源
	
	@Column(field = "sftj", type = "varchar(20)")
	private String SFTJ;//是否统计
	
	@Column(field = "shzt", type = "varchar(20)")
	private String SHZT;//审核状态
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getXMMC() {
		return XMMC;
	}

	public void setXMMC(String xMMC) {
		XMMC = xMMC;
	}

	public String getFZR() {
		return FZR;
	}

	public void setFZR(String fZR) {
		FZR = fZR;
	}

	public String getXMCY() {
		return XMCY;
	}

	public void setXMCY(String xMCY) {
		XMCY = xMCY;
	}

	public String getZZSX() {
		return ZZSX;
	}

	public void setZZSX(String zZSX) {
		ZZSX = zZSX;
	}

	public String getXMXZ() {
		return XMXZ;
	}

	public void setXMXZ(String xMXZ) {
		XMXZ = xMXZ;
	}

	public String getXMFL() {
		return XMFL;
	}

	public void setXMFL(String xMFL) {
		XMFL = xMFL;
	}

	public String getXMJB() {
		return XMJB;
	}

	public void setXMJB(String xMJB) {
		XMJB = xMJB;
	}

	public String getLXRQ() {
		return LXRQ;
	}

	public void setLXRQ(String lXRQ) {
		LXRQ = lXRQ;
	}

	public BigDecimal getHTJF() {
		return HTJF;
	}

	public void setHTJF(BigDecimal hTJF) {
		HTJF = hTJF;
	}

	public String getXMLY() {
		return XMLY;
	}

	public void setXMLY(String xMLY) {
		XMLY = xMLY;
	}

	public String getSFTJ() {
		return SFTJ;
	}

	public void setSFTJ(String sFTJ) {
		SFTJ = sFTJ;
	}

	public String getSHZT() {
		return SHZT;
	}

	public void setSHZT(String sHZT) {
		SHZT = sHZT;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
