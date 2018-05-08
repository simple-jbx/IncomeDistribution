package bean;

import java.util.UUID;

import annotation.Column;
import annotation.Table;

@Table(tableName="t_bzxcgsjk")
public class BZXCGSJK {

	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="dyzz", type="varchar(50)")
	private String DYZZ;//第一作者
	
	@Column(field="zzpx", type="varchar(10)")
	private String ZZPX;//作者排序
	
	@Column(field="cgly", type="text")
	private String CGLY;//成果来源
	
	@Column(field="jb", type="varchar(50)")
	private String JB;//级别
	
	@Column(field="fppx", type="varchar(10)")
	private String FPPX;//分配排序
	
	@Column(field="fppxbl", type="varchar(10)")
	private String FPPXBL;//分配排序比例
	
	@Column(field="jljebz", type="varchar(20)")
	private String JLJEBZ;//奖励金额标准
	
	@Column(field="grjlje", type="varchar(20)")
	private String GRJLJE;//个人奖励金额
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	
	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\":\"");
		builder.append(ID);
		builder.append("\", \"rydm\":\"");
		builder.append(RYDM);
		builder.append("\", \"dyzz\":\"");
		builder.append(DYZZ);
		builder.append("\", \"zzpx\":\"");
		builder.append(ZZPX);
		builder.append("\", \"cgly\":\"");
		builder.append(CGLY);
		builder.append("\", \"jb\":\"");
		builder.append(JB);
		builder.append("\", \"fppx\":\"");
		builder.append(FPPX);
		builder.append("\", \"fppxbl\":\"");
		builder.append(FPPXBL);
		builder.append("\", \"jljebz\":\"");
		builder.append(JLJEBZ);
		builder.append("\", \"grjlje\":\"");
		builder.append(GRJLJE);
		builder.append("\", \"nd\":\"");
		builder.append(ND);
		builder.append("\", \"isdel\":");
		builder.append(ISDEL);
		builder.append("}]");
		return builder.toString();
	}

	public BZXCGSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		DYZZ = "-";
		RYDM = "-";
		ZZPX = "-";
		CGLY = "-";
		JB = "-";
		FPPX = "-";
		FPPXBL = "-";
		JLJEBZ = "-";
		GRJLJE = "-";
		ISDEL = 2;
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

	public String getDYZZ() {
		return DYZZ;
	}

	public void setDYZZ(String dYZZ) {
		DYZZ = dYZZ;
	}

	public String getZZPX() {
		return ZZPX;
	}

	public void setZZPX(String zZPX) {
		ZZPX = zZPX;
	}

	public String getCGLY() {
		return CGLY;
	}

	public void setCGLY(String cGLY) {
		CGLY = cGLY;
	}

	public String getJB() {
		return JB;
	}

	public void setJB(String jB) {
		JB = jB;
	}

	public String getFPPX() {
		return FPPX;
	}

	public void setFPPX(String fPPX) {
		FPPX = fPPX;
	}

	public String getFPPXBL() {
		return FPPXBL;
	}

	public void setFPPXBL(String fPPXBL) {
		FPPXBL = fPPXBL;
	}

	public String getJLJEBZ() {
		return JLJEBZ;
	}

	public void setJLJEBZ(String jLJEBZ) {
		JLJEBZ = jLJEBZ;
	}

	public String getGRJLJE() {
		return GRJLJE;
	}

	public void setGRJLJE(String gRJLJE) {
		GRJLJE = gRJLJE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
