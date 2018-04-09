package bean;

import annotation.Column;
import annotation.Table;
import java.math.BigDecimal;

/**
 * 研究生工作数据
 * @author simple
 *
 */

@Table(tableName="t_yjsgzsj")
public class YJSGZSJ {
	
	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id,主键,自增
	
	@Column(field = "gh", type = "varchar(15)")
	private String GH;//工号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "yjsgzl", type = "double(10, 2)")
	private double YJSGZL;//研究生工作量
	
	@Column(field = "msksf", type = "decimal(10, 2)")
	private BigDecimal MSKSF;//免师课时费
	
	@Column(field = "zbf", type = "decimal(10, 2)")
	private BigDecimal ZBF;//值班费
	
	@Column(field = "pgzy", type = "double(10, 2)")
	private double PGZY;//批改作业
	
	@Column(field = "msgzl", type = "double(10, 2)")
	private double MSGZL;//免师工作量
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
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

	public double getYJSGZL() {
		return YJSGZL;
	}

	public void setYJSGZL(double yJSGZL) {
		YJSGZL = yJSGZL;
	}

	public BigDecimal getMSKSF() {
		return MSKSF;
	}

	public void setMSKSF(BigDecimal mSKSF) {
		MSKSF = mSKSF;
	}

	public BigDecimal getZBF() {
		return ZBF;
	}

	public void setZBF(BigDecimal zBF) {
		ZBF = zBF;
	}

	public double getPGZY() {
		return PGZY;
	}

	public void setPGZY(double pGZY) {
		PGZY = pGZY;
	}

	public double getMSGZL() {
		return MSGZL;
	}

	public void setMSGZL(double mSGZL) {
		MSGZL = mSGZL;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
	
}
