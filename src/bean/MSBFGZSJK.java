package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 免师补发工作数据 
 * @author simple
 *
 */

@Table(tableName="t_msbfgzsjk")
public class MSBFGZSJK {

	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="msdsgzl", type="varchar(10)")
	private String MSDSGZL;//免师导师工作量
	
	@Column(field="gzlbzj", type="varchar(20)")
	private String GZLBZJ;//工作量标准金
	
	@Column(field="ffje", type="varchar(20)")
	private String FFJE;//发放金额
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public MSBFGZSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		MSDSGZL = "-";
		GZLBZJ = "-";
		FFJE = "-";
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
		builder.append("\", \"msdsgzl\":\"");
		builder.append(MSDSGZL);
		builder.append("\", \"gzlbzj\":\"");
		builder.append(GZLBZJ);
		builder.append("\", \"ffje\":\"");
		builder.append(FFJE);
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

	public String getMSDSGZL() {
		return MSDSGZL;
	}

	public void setMSDSGZL(String mSDSGZL) {
		MSDSGZL = mSDSGZL;
	}

	public String getGZLBZJ() {
		return GZLBZJ;
	}

	public void setGZLBZJ(String gZLBZJ) {
		GZLBZJ = gZLBZJ;
	}

	public String getFFJE() {
		return FFJE;
	}

	public void setFFJE(String fFJE) {
		FFJE = fFJE;
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
