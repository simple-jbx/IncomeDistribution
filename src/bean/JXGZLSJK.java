package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

/**
 * 教学工作量
 * @author simple
 *
 */

@Table(tableName="t_jxgzlsjk")
public class JXGZLSJK {

	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="rydm", type="varchar(50)")
	private String RYDM;//人员代码
	
	@Column(field="xm", type="varchar(50)")
	private String XM;//姓名
	
	@Column(field="jrzqk", type="text")
	private String JRZQK;//兼任职情况
	
	@Column(field="zwgzl", type="varchar(10)")
	private String ZWGZL;//职务工作量
	
	@Column(field="bky", type="varchar(10)")
	private String BKY;//本科1
	
	@Column(field="bkqty", type="varchar(10)")
	private String BKQTY;//本科其他1

	@Column(field="bke", type="varchar(10)")
	private String BKE;//本科2
	
	@Column(field="bkqte", type="varchar(10)")
	private String BKQTE;//本科其他2
	
	@Column(field="bktk", type="varchar(10)")
	private String BKTK;//本科听课
	
	@Column(field="yjsjxgzly", type="varchar(10)")
	private String YJSJXGZLY;//研究生教学工作量1

	@Column(field="yjszdgzly", type="varchar(10)")
	private String YJSZDGZLY;//研究生指导工作量1
	
	@Column(field="yjsjxgzle", type="varchar(10)")
	private String YJSJXGZLE;//研究生教学工作量2

	@Column(field="yjszdgzle", type="varchar(10)")
	private String YJSZDGZLE;//研究生指导工作量2
	
	@Column(field="gzlhj", type="varchar(10)")
	private String GZLHJ;//工作量合计
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public JXGZLSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		JRZQK = "-";
		ZWGZL = "-";
		BKY = "-";
		BKQTY = "-";
		BKE = "-";
		BKQTE = "-";
		BKTK = "-";
		YJSJXGZLY = "-";
		YJSZDGZLY = "-";
		YJSJXGZLE = "-";
		YJSZDGZLE = "-";
		GZLHJ = "-";
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
		builder.append("\", \"jrzqk\":\"");
		builder.append(JRZQK);
		builder.append("\", \"zwgzl\":\"");
		builder.append(ZWGZL);
		builder.append("\", \"bky\":\"");
		builder.append(BKY);
		builder.append("\", \"bkqty\":\"");
		builder.append(BKQTY);
		builder.append("\", \"bke\":\"");
		builder.append(BKE);
		builder.append("\", \"bkqte\":\"");
		builder.append(BKQTE);
		builder.append("\", \"bktk\":\"");
		builder.append(BKTK);
		builder.append("\", \"yjsjxgzly\":\"");
		builder.append(YJSJXGZLY);
		builder.append("\", \"yjszdgzly\":\"");
		builder.append(YJSZDGZLY);
		builder.append("\", \"yjsjxgzle\":\"");
		builder.append(YJSJXGZLE);
		builder.append("\", \"yjszdgzle\":\"");
		builder.append(YJSZDGZLE);
		builder.append("\", \"gzlhj\":\"");
		builder.append(GZLHJ);
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

	public String getJRZQK() {
		return JRZQK;
	}

	public void setJRZQK(String jRZQK) {
		JRZQK = jRZQK;
	}

	public String getZWGZL() {
		return ZWGZL;
	}

	public void setZWGZL(String zWGZL) {
		ZWGZL = zWGZL;
	}

	public String getBKY() {
		return BKY;
	}

	public void setBKY(String bKY) {
		BKY = bKY;
	}

	public String getBKQTY() {
		return BKQTY;
	}

	public void setBKQTY(String bKQTY) {
		BKQTY = bKQTY;
	}

	public String getBKE() {
		return BKE;
	}

	public void setBKE(String bKE) {
		BKE = bKE;
	}

	public String getBKQTE() {
		return BKQTE;
	}

	public void setBKQTE(String bKQTE) {
		BKQTE = bKQTE;
	}

	public String getBKTK() {
		return BKTK;
	}

	public void setBKTK(String bKTK) {
		BKTK = bKTK;
	}

	public String getYJSJXGZLY() {
		return YJSJXGZLY;
	}

	public void setYJSJXGZLY(String yJSJXGZLY) {
		YJSJXGZLY = yJSJXGZLY;
	}

	public String getYJSZDGZLY() {
		return YJSZDGZLY;
	}

	public void setYJSZDGZLY(String yJSZDGZLY) {
		YJSZDGZLY = yJSZDGZLY;
	}

	public String getYJSJXGZLE() {
		return YJSJXGZLE;
	}

	public void setYJSJXGZLE(String yJSJXGZLE) {
		YJSJXGZLE = yJSJXGZLE;
	}

	public String getYJSZDGZLE() {
		return YJSZDGZLE;
	}

	public void setYJSZDGZLE(String yJSZDGZLE) {
		YJSZDGZLE = yJSZDGZLE;
	}

	public String getGZLHJ() {
		return GZLHJ;
	}

	public void setGZLHJ(String gZLHJ) {
		GZLHJ = gZLHJ;
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
