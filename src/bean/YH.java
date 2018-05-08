package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 用户表
 * @author simple
 *
 */

@Table(tableName = "t_yh")
public class YH {
	
	@Column(field = "id", type = "char(32)",primaryKey = true, defaultNull = false)
	private String ID;//id
	
	@Column(field = "rydm", type = "varchar(50)")
	private String RYDM;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "mm", type = "varchar(50)")
	private String MM;//密码 密文存储
	
	@Column(field = "zc", type = "varchar(50)")
	private String ZC;//职称
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public YH() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		ZC = "-";
		MM = "70352f41061eda4ff3c322094af068ba70c3b38b";//默认密码
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
		builder.append("\", \"mm\":\"");
		builder.append(MM);
		builder.append("\", \"zc\":\"");
		builder.append(ZC);
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


	public String getMM() {
		return MM;
	}


	public void setMM(String mM) {
		MM = mM;
	}


	public String getZC() {
		return ZC;
	}


	public void setZC(String zC) {
		ZC = zC;
	}


	public int getISDEL() {
		return ISDEL;
	}


	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
