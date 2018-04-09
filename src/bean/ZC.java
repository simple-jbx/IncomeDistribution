package bean;

import annotation.Table;
import annotation.Column;

/**
 * 分配规则--职称
 * @author simple
 *
 */

@Table(tableName = "t_zc")
public class ZC {
	
	@Column(field = "id", type = "varchar(200)", primaryKey = true, defaultNull = false)
	private String ID;//id 主键
	
	@Column(field = "zc", type = "varchar(100)")
	private String ZC;//职称
	
	@Column(field = "kybzf", type = "double(5,2)")
	private String KYBZF;//科研标准分
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getZC() {
		return ZC;
	}

	public void setZC(String zC) {
		ZC = zC;
	}

	public String getKYBZF() {
		return KYBZF;
	}

	public void setKYBZF(String kYBZF) {
		KYBZF = kYBZF;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
