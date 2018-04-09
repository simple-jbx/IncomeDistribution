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
	
	@Column(field = "id", type = "varchar(100)",primaryKey = true, defaultNull = false)
	private String ID;//id
	
	@Column(field = "gh", type = "varchar(50)")
	private String GH;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "zc", type = "varchar(50)")
	private String ZC;//职称
	
	@Column(field = "yhgroup", type="int(2)")
	private int YHGROUP;//用户组别

	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public YH() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		GH = "";
		XM = "";
		ZC = "";
		ISDEL = 2;
		YHGROUP = -1;
	}
	
	/*@Override
	public String toString() {
		return "[ gh=" + GH + ", xm =" + XM +" ]";
	}*/

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

	public int getYHGROUP() {
		return YHGROUP;
	}

	public void setYHGROUP(int yHGROUP) {
		YHGROUP = yHGROUP;
	}
}
