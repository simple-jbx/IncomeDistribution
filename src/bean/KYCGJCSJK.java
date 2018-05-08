package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 科研成果基础数据表
 * @author simple
 *
 */

@Table(tableName = "t_kycgjcsjk")
public class KYCGJCSJK {

	@Column(field = "id", type = "char(32)", primaryKey = true, defaultNull = false)
	private String ID;//id 主键
	
	@Column(field = "rydm", type = "varchar(50)")
	private String RYDM;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "lwfs", type = "varchar(20)")
	private String LWFS;//论文分数
	
	@Column(field = "xmfs", type = "varchar(20)")
	private String XMFS;//项目分数
	
	@Column(field = "zzfs", type = "varchar(20)")
	private String ZZFS;//著作分数
	
	@Column(field = "zlfs", type = "varchar(20)")
	private String ZLFS;//专利分数
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public KYCGJCSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		LWFS = "-";
		XMFS = "-";
		ZZFS = "-";
		ZLFS = "-";
		ND = "-";
		ISDEL = 2;
	}


	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\":\"");
		builder.append(ID);
		builder.append("\", \"gh\":\"");
		builder.append(RYDM);
		builder.append("\", \"xm\":\"");
		builder.append(XM);
		builder.append("\", \"lwfs\":\"");
		builder.append(LWFS);
		builder.append("\", \"xmfs\":\"");
		builder.append(XMFS);
		builder.append("\", \"zzfs\":\"");
		builder.append(ZZFS);
		builder.append("\", \"zlfs\":\"");
		builder.append(ZLFS);
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


	public String getLWFS() {
		return LWFS;
	}


	public void setLWFS(String lWFS) {
		LWFS = lWFS;
	}


	public String getXMFS() {
		return XMFS;
	}


	public void setXMFS(String xMFS) {
		XMFS = xMFS;
	}


	public String getZZFS() {
		return ZZFS;
	}


	public void setZZFS(String zZFS) {
		ZZFS = zZFS;
	}


	public String getZLFS() {
		return ZLFS;
	}


	public void setZLFS(String zLFS) {
		ZLFS = zLFS;
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
