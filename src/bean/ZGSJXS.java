package bean;

import annotation.Table;
import annotation.Column;
import java.util.UUID;

/**
 * 在岗时间系数基础数据
 * @author simple
 */

@Table(tableName = "t_zgsjxs")
public class ZGSJXS{
	@Column(field = "id", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String ID;
	
	@Column(field = "rydm", type = "varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "zgqksm", type = "text")
	private String ZGQKSM;//在岗情况说明
	
	@Column(field = "zgys", type = "int")
	private int ZGYS;//在岗月数
	
	@Column(field = "zgxs", type = "double(10,2)")
	private double ZGXS;//在岗系数
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public ZGSJXS() {
		ID = UUID.randomUUID().toString();
		ZGQKSM = "";
		RYDM = "";
		XM = "";
		ZGYS = 0;
		ZGXS = 0.00;
		ISDEL = 2;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getZGQKSM() {
		return ZGQKSM;
	}

	public void setZGQKSM(String zGQKSM) {
		ZGQKSM = zGQKSM;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
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

	public int getZGYS() {
		return ZGYS;
	}

	public void setZGYS(int zGYS) {
		ZGYS = zGYS;
	}

	public double getZGXS() {
		return ZGXS;
	}

	public void setZGXS(double zGXS) {
		ZGXS = zGXS;
	}
	
	public String toJson() {
	    return "[{\"id\":\"" + ID + "\", \"rydm\":\"" + RYDM + "\", \"xm\":\""
	    + XM + "\",\"zgys\":" +ZGYS + ",\"zgxs\":" + ZGXS + ",\"zgqksm\":\"" + ZGQKSM
	    +"\",\"isdel\":" + ISDEL +"}]";
	}
}
