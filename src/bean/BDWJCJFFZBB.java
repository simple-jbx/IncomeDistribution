package bean;

import annotation.Column;
import annotation.Table;
import java.math.BigDecimal;
/**
 * 酬金发放总报表
 * @author simple
 *
 */
@Table(tableName="t_bdwcjffzbb")
public class BDWJCJFFZBB {
	
	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//主键，自增
	
	@Column(field = "xh", type = "int(32)")
	private int XH;//序号
	
	@Column(field = "rydm", type = "varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "bmmc", type = "varchar(100)")
	private String BMMC;//部门名称
	
	@Column(field = "yfnzj", type = "decimal(10,2)")
	private BigDecimal YFNZJ;//应发年终奖
	
	@Column(field = "grtzje", type = "decimal(10, 2)")
	private BigDecimal GRTZJE;//个人调整金额
	
	@Column(field = "nzjhj", type = "decimal(10, 2)")
	private BigDecimal NZJHJ;//年终奖合计
	
	@Column(field = "nzjks", type = "decimal(10, 2)")
	private BigDecimal NZJKS;//年终奖扣税
	
	@Column(field = "nzjsf", type = "decimal(10, 2)")
	private BigDecimal NZJSF;//年终奖实发
	
	@Column(field = "sfzhm", type = "varchar(20)")
	private String SFZHM;//身份证号码
	
	@Column(field = "yhkh", type = "varchar(25)")
	private String YHKH;//银行卡号
	
	@Column(field = "dhhm", type = "varchar(15)")
	private String DHHM;//电话号码
	
	@Column(field = "bz", type = "varchar(100)")
	private String BZ;//备注
	
	@Column(field = "qzqr", type = "varchar(50)")
	private String QZQR;//签字确认
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//合计金额
	
	public BDWJCJFFZBB() {
		/**
		 * 无参默认构造器
		 * 给出相关数据的默认值
		 */
		ID = 0;
		XH = 0;
		RYDM = "";
		XM = "";
		BMMC = "";
		YFNZJ = new BigDecimal("0.00");
		GRTZJE = new BigDecimal("0.00");
		NZJHJ = new BigDecimal("0.00");
		NZJKS = new BigDecimal("0.00");
		NZJSF = new BigDecimal("0.00");
		SFZHM = "";
		YHKH = "";
		DHHM = "";
		BZ = "";
		QZQR = "";
		ISDEL = 0;
		
	}
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getXH() {
		return XH;
	}

	public void setXH(int xH) {
		XH = xH;
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

	public String getBMMC() {
		return BMMC;
	}

	public void setBMMC(String bMMC) {
		BMMC = bMMC;
	}

	public BigDecimal getYFNZJ() {
		return YFNZJ;
	}

	public void setYFNZJ(BigDecimal yFNZJ) {
		YFNZJ = yFNZJ;
	}

	public BigDecimal getGRTZJE() {
		return GRTZJE;
	}

	public void setGRTZJE(BigDecimal gRTZJE) {
		GRTZJE = gRTZJE;
	}

	public BigDecimal getNZJHJ() {
		return NZJHJ;
	}

	public void setNZJHJ(BigDecimal nZJHJ) {
		NZJHJ = nZJHJ;
	}

	public BigDecimal getNZJKS() {
		return NZJKS;
	}

	public void setNZJKS(BigDecimal nZJKS) {
		NZJKS = nZJKS;
	}

	public BigDecimal getNZJSF() {
		return NZJSF;
	}

	public void setNZJSF(BigDecimal nZJSF) {
		NZJSF = nZJSF;
	}

	public String getSFZHM() {
		return SFZHM;
	}

	public void setSFZHM(String sFZHM) {
		SFZHM = sFZHM;
	}

	public String getYHKH() {
		return YHKH;
	}

	public void setYHKH(String yHKH) {
		YHKH = yHKH;
	}

	public String getDHHM() {
		return DHHM;
	}

	public void setDHHM(String dHHM) {
		DHHM = dHHM;
	}

	public String getBZ() {
		return BZ;
	}

	public void setBZ(String bZ) {
		BZ = bZ;
	}

	public String getQZQR() {
		return QZQR;
	}

	public void setQZQR(String qZQR) {
		QZQR = qZQR;
	}
	
	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
