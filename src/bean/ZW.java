package bean;

import annotation.Column;
import annotation.Table;

/**
 * 职务与职务系数表
 * @author simple
 *
 */

@Table(tableName = "t_zw")
public class ZW {
	@Column(field = "id", type = "varchar(200)", primaryKey = true, defaultNull = false)
	private String ID;//ID
	
	@Column(field = "zw", type = "varchar(50)")
	private String ZW;//职务
	
	@Column(field = "zwxs", type = "double(5,2)")
	private double ZWXS;//职务系数

	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//职务系数
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getZW() {
		return ZW;
	}

	public void setZW(String zW) {
		ZW = zW;
	}

	public double getZWXS() {
		return ZWXS;
	}

	public void setZWXS(double zWXS) {
		ZWXS = zWXS;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
