package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

@Table(tableName="t_hfbtsjk")
public class HFBTSJK {

	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="hfbt", type="varchar(20)")
	private String HFBT;//话费补贴
	
	@Column(field="hj", type="varchar(20)")
	private String HJ;//合计
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public HFBTSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		HFBT = "-";
		ND = "-";
		HJ = "-";
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
		builder.append("\", \"hfbt\":\"");
		builder.append(HFBT);
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

	public String getHFBT() {
		return HFBT;
	}

	public void setHFBT(String hFBT) {
		HFBT = hFBT;
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
