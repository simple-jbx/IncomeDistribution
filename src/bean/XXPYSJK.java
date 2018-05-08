package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 学校评优
 * @author simple
 *
 */

@Table(tableName="t_xxpysjk")
public class XXPYSJK {

	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="xxkhyx", type="varchar(20)")
	private String XXKHYX;//学校考核优秀
	
	@Column(field="jlhj", type="varchar(20)")
	private String JLHJ;//奖励合计
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public XXPYSJK() {
		ID = UUID.randomUUID().toString();
		RYDM = "";
		XM = "";
		XXKHYX = "-";
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
		builder.append("\", \"xxkhyx\":\"");
		builder.append(XXKHYX);
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

	public String getXXKHYX() {
		return XXKHYX;
	}

	public void setXXKHYX(String xXKHYX) {
		XXKHYX = xXKHYX;
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
