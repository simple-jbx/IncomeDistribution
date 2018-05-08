package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

@Table(tableName="t_jthdkqsjk", tableComment="集体活动考勤数据")
public class JTHDKQSJK {

	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false, comment="id,主键")
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)", comment="人员代码")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)", comment="姓名")
	private String XM;//姓名
	
	@Column(field="wgwd", type="varchar(10)", comment="无故未到")
	private String WGWD;//无故未到
	
	@Column(field="grsj", type="varchar(10)", comment="个人事假")
	private String GRSJ;//个人事假
	
	@Column(field="jey", type="varchar(20)", comment="金额1")
	private String JEY;//金额1
	
	@Column(field="jee", type="varchar(20)", comment="金额2")
	private String JEE;//金额2
	
	@Column(field="hjje", type="varchar(20)", comment="合计金额")
	private String HJJE;//合计金额
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)", comment="删除标记")
	private int ISDEL;//是否删除
	
	
	public JTHDKQSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		WGWD = "-";
		GRSJ = "-";
		JEY = "-";
		JEE = "-";
		HJJE = "-";
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
		builder.append("\", \"wgwd\":\"");
		builder.append(WGWD);
		builder.append("\", \"grsj\":\"");
		builder.append(GRSJ);
		builder.append("\", \"jey\":\"");
		builder.append(JEY);
		builder.append("\", \"jee\":\"");
		builder.append(JEE);
		builder.append("\", \"hjje\":\"");
		builder.append(HJJE);
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

	public String getWGWD() {
		return WGWD;
	}

	public void setWGWD(String wGWD) {
		WGWD = wGWD;
	}

	public String getGRSJ() {
		return GRSJ;
	}

	public void setGRSJ(String gRSJ) {
		GRSJ = gRSJ;
	}

	public String getJEY() {
		return JEY;
	}

	public void setJEY(String jEY) {
		JEY = jEY;
	}

	public String getJEE() {
		return JEE;
	}

	public void setJEE(String jEE) {
		JEE = jEE;
	}

	public String getHJJE() {
		return HJJE;
	}

	public void setHJJE(String hJJE) {
		HJJE = hJJE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}

	public String getND() {
		return ND;
	}

	public void setND(String nD) {
		ND = nD;
	}
}
