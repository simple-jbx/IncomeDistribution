package bean;

import annotation.Table;
import annotation.Column;
import java.math.BigDecimal;

/**
 * 2016标志性成果
 * @author simple
 *
 */

@Table(tableName = "t_elylbzxcg")
public class ELYLBZXCG {

	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id 主键
	
	@Column(field = "cgmc", type = "varchar(100)")
	private String CGMC;//成果名称
	
	@Column(field = "cgjb", type = "varchar(50)")
	private String CGJB;//成果级别
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "cgpm", type = "varchar(20)")
	private String CGPM;//成果排名
	
	@Column(field = "bl", type = "varchar(10)")
	private String BL;//比例
	
	@Column(field = "zje", type = "decimal(10, 2)")
	private BigDecimal ZJE;//总金额
	
	@Column(field = "je", type = "decimal(10, 2)")
	private BigDecimal JE;//金额

	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public ELYLBZXCG() {
		ID = 0;
		CGMC = "";
		CGJB = "";
		XM = "";
		CGPM = "";
		BL = "";
		ZJE = new BigDecimal("0.00");
		JE = new BigDecimal("0.00");
		ISDEL = 0;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCGMC() {
		return CGMC;
	}

	public void setCGMC(String cGMC) {
		CGMC = cGMC;
	}

	public String getCGJB() {
		return CGJB;
	}

	public void setCGJB(String cGJB) {
		CGJB = cGJB;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String xM) {
		XM = xM;
	}

	public String getCGPM() {
		return CGPM;
	}

	public void setCGPM(String cGPM) {
		CGPM = cGPM;
	}

	public String getBL() {
		return BL;
	}

	public void setBL(String bL) {
		BL = bL;
	}

	public BigDecimal getZJE() {
		return ZJE;
	}

	public void setZJE(BigDecimal zJE) {
		ZJE = zJE;
	}

	public BigDecimal getJE() {
		return JE;
	}

	public void setJE(BigDecimal jE) {
		JE = jE;
	}
	
	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
