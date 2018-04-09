package bean;

import annotation.Column;
import annotation.Table;

/**
 * 工作量及监考信息表
 * @author simple
 *
 */

@Table(tableName = "t_gzljjkxxb")
public class GZLJJKXXB {

	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id,主键
	
	@Column(field = "xh", type = "varchar(20)")
	private String XH;//序号
	
	@Column(field = "jsxm", type = "varchar(50)")
	private String JSXM;//教师姓名
	
	@Column(field = "ggkgzly", type = "double(10, 2)")
	private double GGKGZLY;//公共课工作量1
	
	@Column(field = "zykgzly", type = "double(10, 2)")
	private double ZYKGZLY;//专业课工作量1
	
	@Column(field = "qtgzly", type = "double(10, 2)")
	private double QTGZLY;//其它工作量1

	@Column(field = "ggkgzle", type = "double(10, 2)")
	private double GGKGZLE;//公共课工作量2
	
	@Column(field = "zykgzle", type = "double(10, 2)")
	private double ZYKGZLE;//专业课工作量2
	
	@Column(field = "qtgzle", type = "double(10, 2)")
	private double QTGZLE;//其它工作量2
	
	@Column(field = "bkxj", type = "double(10, 2)")
	private double BKXJ;//本科小计
	
	@Column(field = "yjsgzl", type = "double(10, 2)")
	private double YJSGZL;//研究生工作量
	
	@Column(field = "hj", type = "double(10, 2)")
	private double HJ;//合计
	
	@Column(field = "bz", type = "double(10, 2)")
	private double BZ;//备注

	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public GZLJJKXXB() {
		ID = 0;
		XH = "";
		JSXM = "";
		GGKGZLY = 0.00;
		ZYKGZLY = 0.00;
		QTGZLY = 0.00;
		GGKGZLE = 0.00;
		ZYKGZLE = 0.00;
		QTGZLE = 0.00;
		BKXJ = 0.00;
		YJSGZL = 0.00;
		HJ = 0.00;
		BZ = 0.00;
		ISDEL = 0;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getJSXM() {
		return JSXM;
	}

	public void setJSXM(String jSXM) {
		JSXM = jSXM;
	}

	public double getGGKGZLY() {
		return GGKGZLY;
	}

	public void setGGKGZLY(double gGKGZLY) {
		GGKGZLY = gGKGZLY;
	}

	public double getQTGZLY() {
		return QTGZLY;
	}

	public void setQTGZLY(double qTGZLY) {
		QTGZLY = qTGZLY;
	}

	public double getGGKGZLE() {
		return GGKGZLE;
	}

	public void setGGKGZLE(double gGKGZLE) {
		GGKGZLE = gGKGZLE;
	}

	public double getZYKGZLE() {
		return ZYKGZLE;
	}

	public void setZYKGZLE(double zYJGZLE) {
		ZYKGZLE = zYJGZLE;
	}

	public double getQTGZLE() {
		return QTGZLE;
	}

	public void setQTGZLE(double qTGZLE) {
		QTGZLE = qTGZLE;
	}

	public double getBKXJ() {
		return BKXJ;
	}

	public void setBKXJ(double bKXJ) {
		BKXJ = bKXJ;
	}

	public double getYJSGZL() {
		return YJSGZL;
	}

	public void setYJSGZL(double yJSGZL) {
		YJSGZL = yJSGZL;
	}

	public double getHJ() {
		return HJ;
	}

	public void setHJ(double hJ) {
		HJ = hJ;
	}

	public double getBZ() {
		return BZ;
	}

	public void setBZ(double bZ) {
		BZ = bZ;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}

	public String getXH() {
		return XH;
	}

	public void setXH(String xH) {
		XH = xH;
	}

	public double getZYKGZLY() {
		return ZYKGZLY;
	}

	public void setZYKGZLY(double zYKGZLY) {
		ZYKGZLY = zYKGZLY;
	}
}
