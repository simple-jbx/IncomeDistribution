package bean;

import java.util.UUID;

import annotation.Column;
import annotation.Table;

/**
 * 创收补缴税金返还
 * @author simple
 *
 */

@Table(tableName="t_csbjsjfhsjk",tableComment="创收补缴税金返还数据")
public class CSBJSJFHSJK {

	@Column(field="id", type="char(32)", comment="主键", primaryKey=true, defaultNull=false)
	private String ID;
	
	@Column(field="rydm", type="varchar(50)", comment="人员代码")
	private String RYDM;
	
	@Column(field="xm", type="varchar(50)", comment="姓名")
	private String XM;
	
	@Column(field="ffje", type="varchar(20)", comment="发放金额")
	private String FFJE;
	
	@Column(field="sfjj", type="varchar(20)", comment="实发奖金")
	private String SFJJ;
	
	@Column(field="ksbl", type="varchar(10)", comment="扣税比例")
	private String KSBL;
	
	@Column(field="ksje", type="varchar(20)", comment="扣税金额")
	private String KSJE;//扣税金额
	
	@Column(field="sfje", type="varchar(20)", comment="实发金额")
	private String SFJE;//实发金额
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)", comment="删除标记")
	private int ISDEL;
	
	public CSBJSJFHSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		FFJE = "-";
		SFJJ = "-";
		KSBL = "-";
		KSJE = "-";
		SFJE = "-";
		ND = "-";
		ISDEL = 2;
	}
	
	
	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\":\"");
		builder.append(ID);
		builder.append("\", \"rydm\":\"");
		builder.append(RYDM);
		builder.append("\", \"xm\":\"");
		builder.append(XM);
		builder.append("\", \"ffje\":\"");
		builder.append(FFJE);
		builder.append("\", \"sfjj\":\"");
		builder.append(SFJJ);
		builder.append("\", \"ksbl\":\"");
		builder.append(KSBL);
		builder.append("\", \"ksje\":\"");
		builder.append(KSJE);
		builder.append("\", \"sfje\":\"");
		builder.append(SFJE);
		builder.append("\", \"nd\":\"");
		builder.append(ND);
		builder.append("\", \"isdel\":");
		builder.append(ISDEL);
		builder.append("}]");
		return builder.toString();
	}



	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	public String getFFJE() {
		return FFJE;
	}

	public void setFFJE(String fFJE) {
		FFJE = fFJE;
	}

	public String getSFJJ() {
		return SFJJ;
	}

	public void setSFJJ(String sFJJ) {
		SFJJ = sFJJ;
	}

	public String getKSBL() {
		return KSBL;
	}

	public void setKSBL(String kSBL) {
		KSBL = kSBL;
	}

	public String getKSJE() {
		return KSJE;
	}

	public void setKSJE(String kSJE) {
		KSJE = kSJE;
	}

	public String getSFJE() {
		return SFJE;
	}

	public void setSFJE(String sFJE) {
		SFJE = sFJE;
	}
	
	public String getND() {
		return ND;
	}


	public void setND(String nD) {
		ND = nD;
	}


	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
