package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
import java.math.BigDecimal;

@Table(tableName = "t_xyzhglyfzpjfpjgb")
public class XYZHGLYFZPJFPJGB {
	
	@Column(field = "id", type = "varchar(100)", primaryKey = true, defaultNull = false)
	private String ID;//id 主键
	
	@Column(field = "jzgs", type = "int")
	private int JZGS;//教职工数
	
	@Column(field = "nd", type = "varchar(50)")
	private String ND;//年度
	
	@Column(field = "xkjs", type = "decimal(15,2)")
	private BigDecimal XKJS;//学科建设
	
	@Column(field = "dwjs", type = "decimal(15,2)")
	private BigDecimal DWJS;//队伍建设
	
	@Column(field = "kxyjw", type = "decimal(15,2)")
	private BigDecimal KXYJW;//科学研究（文）
	
	@Column(field = "kxyjl", type = "decimal(15,2)")
	private BigDecimal KXYJL;//科学研究（理）
	
	@Column(field = "rcpyzl", type = "decimal(15,2)")
	private BigDecimal RCPYZL;//人才培养质量
	
	@Column(field = "rcpygm", type = "decimal(15,2)")
	private BigDecimal RCPYGM;//人才培养规模
	
	@Column(field = "shsyyshfw", type = "decimal(15,2)")
	private BigDecimal SHSYYSHFW;//社会声誉与社会服务
	
	@Column(field = "fpjehj", type = "decimal(15,2)")
	private BigDecimal FPJEHJ;//分配金额合计
	
	@Column(field = "cskyje", type = "decimal(15,2)")
	private BigDecimal CSKYJE;//创收可用金额
	
	@Column(field = "mfsfscj", type = "decimal(15,2)")
	private BigDecimal MFSFSCJ;//免费师范生酬金
	
	@Column(field = "qtsr", type = "decimal(15,2)")
	private BigDecimal QTSR;//其他收入
	
	@Column(field = "csjy", type = "decimal(15,2)")
	private BigDecimal CSJY;//创收结余
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;

    public XYZHGLYFZPJFPJGB() {
    	ID = UUID.randomUUID().toString().replaceAll("-", "");
    	ND = "";
    	JZGS = 0;
    	XKJS = new BigDecimal("0.00");
    	DWJS = new BigDecimal("0.00");
    	KXYJW = new BigDecimal("0.00");
    	KXYJL = new BigDecimal("0.00");
    	RCPYZL = new BigDecimal("0.00");
    	RCPYGM = new BigDecimal("0.00");
    	SHSYYSHFW = new BigDecimal("0.00");
    	FPJEHJ = new BigDecimal("0.00");
    	CSKYJE = new BigDecimal("0.00");
    	MFSFSCJ = new BigDecimal("0.00");
    	QTSR = new BigDecimal("0.00"); 
    	CSJY = new BigDecimal("0.00");
    	ISDEL = 2;
    }

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getND() {
		return ND;
	}

	public void setND(String nD) {
		ND = nD;
	}

	public BigDecimal getXKJS() {
		return XKJS;
	}

	public void setXKJS(BigDecimal xKJS) {
		XKJS = xKJS;
	}

	public BigDecimal getDWJS() {
		return DWJS;
	}

	public void setDWJS(BigDecimal dWJS) {
		DWJS = dWJS;
	}

	public BigDecimal getKXYJW() {
		return KXYJW;
	}

	public void setKXYJW(BigDecimal kXYJW) {
		KXYJW = kXYJW;
	}

	public BigDecimal getKXYJL() {
		return KXYJL;
	}

	public void setKXYJL(BigDecimal kXYJL) {
		KXYJL = kXYJL;
	}

	public BigDecimal getRCPYZL() {
		return RCPYZL;
	}

	public void setRCPYZL(BigDecimal rCPYZL) {
		RCPYZL = rCPYZL;
	}

	public BigDecimal getRCPYGM() {
		return RCPYGM;
	}

	public void setRCPYGM(BigDecimal rCPYGM) {
		RCPYGM = rCPYGM;
	}

	public BigDecimal getSHSYYSHFW() {
		return SHSYYSHFW;
	}

	public void setSHSYYSHFW(BigDecimal sHSYYSHFW) {
		SHSYYSHFW = sHSYYSHFW;
	}

	public BigDecimal getFPJEHJ() {
		return FPJEHJ;
	}

	public void setFPJEHJ(BigDecimal fPJEHJ) {
		FPJEHJ = fPJEHJ;
	}

	public BigDecimal getCSKYJE() {
		return CSKYJE;
	}

	public void setCSKYJE(BigDecimal cSKYJE) {
		CSKYJE = cSKYJE;
	}

	public BigDecimal getMFSFSCJ() {
		return MFSFSCJ;
	}

	public void setMFSFSCJ(BigDecimal mFSFSCJ) {
		MFSFSCJ = mFSFSCJ;
	}

	public BigDecimal getQTSR() {
		return QTSR;
	}

	public void setQTSR(BigDecimal qTSR) {
		QTSR = qTSR;
	}

	public BigDecimal getCSJY() {
		return CSJY;
	}

	public void setCSJY(BigDecimal cSJY) {
		CSJY = cSJY;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}

	public int getJZGS() {
		return JZGS;
	}

	public void setJZGS(int jZGS) {
		JZGS = jZGS;
	}
}
