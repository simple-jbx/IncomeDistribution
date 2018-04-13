package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

@Table(tableName="t_jxgzlsjk")
public class JXGZLSJK {

	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="jrzqk", type="text")
	private String JRZQK;//兼任职情况
	
	@Column(field="zwgzl", type="double")
	private double ZWGZL;//职务工作量
	
	@Column(field="bky", type="double")
	private double BKY;//本科1
	
	@Column(field="bkqty", type="double")
	private double BKQTY;//本科其他1

	@Column(field="bke", type="double")
	private double BKE;//本科2
	
	@Column(field="bkqte", type="double")
	private double BKQTE;//本科其他2
	
	@Column(field="bktk", type="double")
	private double BKTK;//本科听课
	
	@Column(field="yjsjxgzly", type="double")
	private double YJSJXGZLY;//研究生教学工作量1

	@Column(field="yjszdgzly", type="double")
	private double YJSZDGZLY;//研究生指导工作量1
	
	@Column(field="yjsjxgzle", type="double")
	private double YJSJXGZLE;//研究生教学工作量2

	@Column(field="yjszdgzle", type="double")
	private double YJSZDGZLE;//研究生指导工作量2
	
	@Column(field="gzlhj", type="double")
	private double GZLHJ;//工作量合计
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public JXGZLSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "";
		XM = "";
		JRZQK = "";
		ZWGZL = 0;
		BKY = 0;
		BKQTY = 0;
		BKE = 0;
		BKQTE = 0;
		BKTK = 0;
		YJSJXGZLY = 0;
		YJSZDGZLY = 0;
		YJSJXGZLE = 0;
		YJSZDGZLE = 0;
		GZLHJ = 0;
		ISDEL = 2;
	}
	
	public String toJson() {
		return "[{\"id\":\"" + ID + "\", \"rydm\":\"" + RYDM + "\", \"xm\":\"" + XM
				+"\", \"jrzqk\":\"" + JRZQK + "\", \"zwgzl\":" + ZWGZL + ", \"bky\":"
				+ BKY + ", \"bkqty\":" + ", \"bke\":" + BKE + ", \"bkqte\":" +BKQTE 
				+ ", \"bktk\":" + BKTK + ", \"yjsjxgzly\":" + YJSJXGZLY + ", \"yjszdgzly\":"
				+ YJSZDGZLY + ", \"yjsjxgzle\":" + YJSJXGZLE + ", \"yjszdgzle\":" + YJSZDGZLE
				+", \"gzlhh\":" + GZLHJ + ", \"isdel\":" + ISDEL +"}]";
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

	public String getJRZQK() {
		return JRZQK;
	}

	public void setJRZQK(String jRZQK) {
		JRZQK = jRZQK;
	}

	public double getZWGZL() {
		return ZWGZL;
	}

	public void setZWGZL(double zWGZL) {
		ZWGZL = zWGZL;
	}

	public double getBKY() {
		return BKY;
	}

	public void setBKY(double bKY) {
		BKY = bKY;
	}

	public double getBKQTY() {
		return BKQTY;
	}

	public void setBKQTY(double bKQTY) {
		BKQTY = bKQTY;
	}

	public double getBKE() {
		return BKE;
	}

	public void setBKE(double bKE) {
		BKE = bKE;
	}

	public double getBKQTE() {
		return BKQTE;
	}

	public void setBKQTE(double bKQTE) {
		BKQTE = bKQTE;
	}

	public double getBKTK() {
		return BKTK;
	}

	public void setBKTK(double bKTK) {
		BKTK = bKTK;
	}

	public double getYJSJXGZLY() {
		return YJSJXGZLY;
	}

	public void setYJSJXGZLY(double yJSJXGZLY) {
		YJSJXGZLY = yJSJXGZLY;
	}

	public double getYJSZDGZLY() {
		return YJSZDGZLY;
	}

	public void setYJSZDGZLY(double yJSZDGZLY) {
		YJSZDGZLY = yJSZDGZLY;
	}

	public double getYJSJXGZLE() {
		return YJSJXGZLE;
	}

	public void setYJSJXGZLE(double yJSJXGZLE) {
		YJSJXGZLE = yJSJXGZLE;
	}

	public double getYJSZDGZLE() {
		return YJSZDGZLE;
	}

	public void setYJSZDGZLE(double yJSZDGZLE) {
		YJSZDGZLE = yJSZDGZLE;
	}

	public double getGZLHJ() {
		return GZLHJ;
	}

	public void setGZLHJ(double gZLHJ) {
		GZLHJ = gZLHJ;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
