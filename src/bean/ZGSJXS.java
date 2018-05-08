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
	@Column(field = "id", type = "char(32)", primaryKey = true, defaultNull = false)
	private String ID;
	
	@Column(field = "rydm", type = "varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "zgqksm", type = "text")
	private String ZGQKSM;//在岗情况说明
	
	@Column(field = "zgys", type = "varchar(10)")
	private String ZGYS;//在岗月数
	
	@Column(field = "zgxs", type = "varchar(10)")
	private String ZGXS;//在岗系数
	
	@Column(field = "nd", type = "varchar(10)")
	private String ND;
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public ZGSJXS() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		ZGQKSM = "-";
		RYDM = "-";
		XM = "-";
		ZGYS = "-";
		ZGXS = "-";
		ND = "-";
		ISDEL = 2;
	}


	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\":\"");
		builder.append(ID);
		builder.append("\", \"rydm\":\"");
		builder.append(RYDM);
		builder.append("\", \"xm\":\"");
		builder.append(XM);
		builder.append("\", \"zgqksm\":\"");
		builder.append(ZGQKSM);
		builder.append("\", \"zgys\":\"");
		builder.append(ZGYS);
		builder.append("\", \"zgxs\":\"");
		builder.append(ZGXS);
		builder.append("\", \"nd\":\"");
		builder.append(ND);
		builder.append("\", \"isdel\":");
		builder.append(ISDEL);
		builder.append("}]");
		return builder.toString();
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

	public String getZGQKSM() {
		return ZGQKSM;
	}

	public void setZGQKSM(String zGQKSM) {
		ZGQKSM = zGQKSM;
	}

	public String getZGYS() {
		return ZGYS;
	}

	public void setZGYS(String zGYS) {
		ZGYS = zGYS;
	}

	public String getZGXS() {
		return ZGXS;
	}

	public void setZGXS(String zGXS) {
		ZGXS = zGXS;
	}

	public String getND() {
		return ND;
	}

	public void setND(String nD) {
		ND = nD;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
