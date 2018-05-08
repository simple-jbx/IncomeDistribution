package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 教研室活动经费数据
 * @author simple
 *
 */
@Table(tableName="t_jyshdjfsjk")
public class JYSHDJFSJK {
	
	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="jyshdjf", type="varchar(20)")
	private String JYSHDJF;//教研室活动经费
	
	@Column(field="jc", type="varchar(20)")
	private String JC;//奖惩
	
	@Column(field="hj", type="varchar(20)")
	private String HJ;//合计
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public JYSHDJFSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "";
		XM = "";
		JYSHDJF = "-";
		JC = "-";
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
		builder.append("\", \"jyshdjf\":\"");
		builder.append(JYSHDJF);
		builder.append("\", \"jc\":\"");
		builder.append(JC);
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

	public String getJYSHDJF() {
		return JYSHDJF;
	}

	public void setJYSHDJF(String jYSHDJF) {
		JYSHDJF = jYSHDJF;
	}

	public String getJC() {
		return JC;
	}

	public void setJC(String jC) {
		JC = jC;
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
