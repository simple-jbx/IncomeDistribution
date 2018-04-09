package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 在岗时间系数规则
 * @author simple
 */

@Table(tableName = "t_zgsjxsgz")
public class ZGSJXSGZ extends YH{
 
	@Column(field = "id", type="varchar(100)", primaryKey = true, defaultNull = false)
	private String ID;
	
	@Column(field = "zgys", type = "int(2)")
	private int ZGYS;//在岗月数
	
	@Column(field = "zgxs", type = "double(5,2)")
	private double ZGXS;//在岗系数
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public ZGSJXSGZ() {
		ID = UUID.randomUUID().toString();
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

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
