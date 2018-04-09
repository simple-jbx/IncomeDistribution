package bean;

import annotation.Column;
import annotation.Table;

@Table(tableName = "t_ZL")
public class ZL {
	
	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id,主键
	
	@Column(field = "zlmc", type = "varchar(300)")
	private String ZLMC;//专利名称
	
	@Column(field = "zlh", type = "varchar(100)")
	private String ZLH;//专利号
	
	@Column(field = "zlzsbh", type = "varchar(100)")
	private String ZLZSBH;//专利证书编号
	
	@Column(field = "dyfmhsjr", type = "varchar(50)")
	private String DYFMHSJR;//第一发明（设计）人
	
	@Column(field = "gsyx", type = "varchar(100)")
	private String GSYX;//归属院系
	
	@Column(field = "zlfmhsjr", type = "varchar(100)")
	private String ZLFMHSJR;//专利发明（设计）人
	
	@Column(field = "zzpx", type = "varchar(20)")
	private String ZZPX;//作者排序
	
	@Column(field = "qtfmhsjr", type = "varchar(300)")
	private String QTFMHSJR;//其他发明（设计）人
	
	@Column(field = "zllx", type = "varchar(50)")
	private String ZLLX;//专利类型
	
	@Column(field = "sqrq", type = "varchar(20)")
	private String SQRQ;//申请日期
	
	@Column(field = "shqrq", type = "varchar(20)")
	private String SHQRQ;//授权日期
	
	@Column(field = "shzt", type = "varchar(20)")
	private String SHZT;//审核状态
	
	@Column(field = "zlqr", type = "varchar(300)")
	private String ZLQR;//专利权人
	
	@Column(field = "cysl", type = "varchar(20)")
	private String CYSL;
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getZLMC() {
		return ZLMC;
	}

	public void setZLMC(String zLMC) {
		ZLMC = zLMC;
	}

	public String getZLH() {
		return ZLH;
	}

	public void setZLH(String zLH) {
		ZLH = zLH;
	}

	public String getZLZSBH() {
		return ZLZSBH;
	}

	public void setZLZSBH(String zLZSBH) {
		ZLZSBH = zLZSBH;
	}

	public String getDYFMHSJR() {
		return DYFMHSJR;
	}

	public void setDYFMHSJR(String dYFMHSJR) {
		DYFMHSJR = dYFMHSJR;
	}

	public String getGSYX() {
		return GSYX;
	}

	public void setGSYX(String gSYX) {
		GSYX = gSYX;
	}

	public String getZLFMHSJR() {
		return ZLFMHSJR;
	}

	public void setZLFMHSJR(String zLFMHSJR) {
		ZLFMHSJR = zLFMHSJR;
	}

	public String getZZPX() {
		return ZZPX;
	}

	public void setZZPX(String zZPX) {
		ZZPX = zZPX;
	}

	public String getQTFMHSJR() {
		return QTFMHSJR;
	}

	public void setQTFMHSJR(String qTFMHSJR) {
		QTFMHSJR = qTFMHSJR;
	}

	public String getZLLX() {
		return ZLLX;
	}

	public void setZLLX(String zLLX) {
		ZLLX = zLLX;
	}

	public String getSQRQ() {
		return SQRQ;
	}

	public void setSQRQ(String sQRQ) {
		SQRQ = sQRQ;
	}

	public String getSHQRQ() {
		return SHQRQ;
	}

	public void setSHQRQ(String sHQRQ) {
		SHQRQ = sHQRQ;
	}

	public String getSHZT() {
		return SHZT;
	}

	public void setSHZT(String sHZT) {
		SHZT = sHZT;
	}

	public String getZLQR() {
		return ZLQR;
	}

	public void setZLQR(String zLQR) {
		ZLQR = zLQR;
	}

	public String getCYSL() {
		return CYSL;
	}

	public void setCYSL(String cYSL) {
		CYSL = cYSL;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
	
}
