package bean;

import annotation.Column;
import annotation.Table;

/**
 * 职务与职务系数表
 * @author simple
 *
 */

@Table(tableName = "t_zj")
public class ZJ {
	@Column(field = "id", type = "varchar(200)", primaryKey = true, defaultNull = false)
	private String ID;//ID
	
	@Column(field = "zj", type = "varchar(50)")
	private String ZJ;//职务
	
	@Column(field = "zjxs", type = "double(5,2)")
	private double ZJXS;//职级系数

	@Column(field = "dj", type = "varchar(50)")
	private String DJ;//等级
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getZJ() {
		return ZJ;
	}

	public void setZJ(String zJ) {
		ZJ = zJ;
	}

	public double getZJXS() {
		return ZJXS;
	}

	public void setZJXS(double zJXS) {
		ZJXS = zJXS;
	}

	public String getDJ() {
		return DJ;
	}

	public void setDJ(String dJ) {
		DJ = dJ;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
