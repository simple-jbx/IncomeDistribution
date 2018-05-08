package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 免费师范生工作数据
 * @author simple
 *
 */

@Table(tableName="t_mfsfsgzsjk")
public class MFSFSGZSJK {
	
	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="zdgzlhj", type="varchar(10)")
	private String ZDGZLHJ;//指导工作量合计
	
	@Column(field="gzlcj", type="varchar(20)")
	private String GZLCJ;//工作量酬金
	
	@Column(field="sqskksf", type="varchar(20)")
	private String SQSKKSF;//暑期授课课时费
	
	@Column(field="pgzylc", type="varchar(20)")
	private String PGZYLC;//批改作业劳酬
	
	@Column(field="sqzbf", type="varchar(20)")
	private String SQZBF;//暑期值班费
	
	@Column(field="hj", type="varchar(20)")
	private String HJ;//合计
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public MFSFSGZSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		ZDGZLHJ = "-";
		GZLCJ = "-";
		SQSKKSF = "-";
		PGZYLC = "-";
		SQZBF = "-";
		HJ = "-";
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
		builder.append("\", \"zdgzlhj\":\"");
		builder.append(ZDGZLHJ);
		builder.append("\", \"hzlcj\":\"");
		builder.append(GZLCJ);
		builder.append("\", \"sqskksf\":\"");
		builder.append(SQSKKSF);
		builder.append("\", \"pgzylc\":\"");
		builder.append(PGZYLC);
		builder.append("\", \"sqzbf\":\"");
		builder.append(SQZBF);
		builder.append("\", \"hj\":\"");
		builder.append(HJ);
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

	public String getZDGZLHJ() {
		return ZDGZLHJ;
	}

	public void setZDGZLHJ(String zDGZLHJ) {
		ZDGZLHJ = zDGZLHJ;
	}

	public String getGZLCJ() {
		return GZLCJ;
	}

	public void setGZLCJ(String gZLCJ) {
		GZLCJ = gZLCJ;
	}

	public String getSQSKKSF() {
		return SQSKKSF;
	}

	public void setSQSKKSF(String sQSKKSF) {
		SQSKKSF = sQSKKSF;
	}

	public String getPGZYLC() {
		return PGZYLC;
	}

	public void setPGZYLC(String pGZYLC) {
		PGZYLC = pGZYLC;
	}

	public String getSQZBF() {
		return SQZBF;
	}

	public void setSQZBF(String sQZBF) {
		SQZBF = sQZBF;
	}

	public String getHJ() {
		return HJ;
	}

	public void setHJ(String hJ) {
		HJ = hJ;
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
