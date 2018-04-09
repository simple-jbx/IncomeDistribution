package bean;

import annotation.Column;
import annotation.Table;
import java.math.BigDecimal;

/**
 * 综合体系个人得分奖励信息
 * @author simple
 *
 */

@Table(tableName = "t_zhtxgrdfjlxx")
public class ZHTXGRDFJLXX {

	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id 主键
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "dfxm", type = "varchar(200)")
	private String DFXM;//得分项目
	
	@Column(field = "nx", type = "varchar(50)")
	private String NX;//年限
	
	@Column(field = "jlje", type = "decimal(10, 2)")
	private BigDecimal JLJE;//奖励金额
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String xM) {
		XM = xM;
	}

	public String getDFXM() {
		return DFXM;
	}

	public void setDFXM(String dFXM) {
		DFXM = dFXM;
	}

	public String getNX() {
		return NX;
	}

	public void setNX(String nX) {
		NX = nX;
	}

	public BigDecimal getJLJE() {
		return JLJE;
	}

	public void setJLJE(BigDecimal jLJE) {
		JLJE = jLJE;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
