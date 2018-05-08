package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

@Table(tableName="t_xypysjk")
public class XYPYSJK {

	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="xypy", type="varchar(32)")
	private String XYPY;//学院评优
	
	@Column(field="jlhj", type="varchar(32)")
	private String JLHJ;//奖励合计
	
	@Column(field="nd", type="varchar(10)")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public XYPYSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		XYPY = "-";
		JLHJ = "-";
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
		builder.append("\", \"xypy\":\"");
		builder.append(XYPY);
		builder.append("\", \"jlhj\":\"");
		builder.append(JLHJ);
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


	public String getXYPY() {
		return XYPY;
	}


	public void setXYPY(String xYPY) {
		XYPY = xYPY;
	}


	public String getJLHJ() {
		return JLHJ;
	}


	public void setJLHJ(String jLHJ) {
		JLHJ = jLHJ;
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
