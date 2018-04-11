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

	@Column(field = "id", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String ID;//id 主键
	
	@Column(field = "gh", type = "varchar(50)")
	private String GH;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "lwfs", type = "double(10, 2)")
	private double LWFS;//论文分数
	
	@Column(field = "xmfs", type = "double(10, 2)")
	private double XMFS;//项目分数
	
	@Column(field = "zzfs", type = "double(10, 2)")
	private double ZZFS;//著作分数
	
	@Column(field = "zlfs", type = "double(10, 2)")
	private double ZLFS;//专利分数
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public KYCGJCSJK() {
		ID = UUID.randomUUID().toString();
		GH = "";
		XM = "";
		LWFS = 0.00;
		XMFS = 0.00;
		ZZFS = 0.00;
		ZLFS = 0.00;
		ISDEL = 2;
	}
	
	
	/**
	 * 将bean对象转换为json字符串
	 * @param
	 * @return
	 */
	public String toJson() {
		return "[{\"id\":\"" + ID + "\", \"gh\":\"" + GH + "\", \"xm\":\"" + XM + "\", \"lwfs\":"
				+ LWFS + ", \"xmfs\":" + XMFS + ", \"zzfs\":" + ZZFS + ", \"zlfs\":" + ZLFS + ", \"isdel\":" 
				+ ISDEL + "}]";
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
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

	public double getLWFS() {
		return LWFS;
	}

	public void setLWFS(double lWFS) {
		LWFS = lWFS;
	}

	public double getXMFS() {
		return XMFS;
	}

	public void setXMFS(double xMFS) {
		XMFS = xMFS;
	}

	public double getZZFS() {
		return ZZFS;
	}

	public void setZZFS(double zZFS) {
		ZZFS = zZFS;
	}

	public double getZLFS() {
		return ZLFS;
	}

	public void setZLFS(double zLFS) {
		ZLFS = zLFS;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
