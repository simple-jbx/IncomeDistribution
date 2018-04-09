package bean;

import annotation.Column;
import annotation.Table;

@Table(tableName = "t_hj")
public class HJ {

	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id，主键
	
	@Column(field = "jlmc", type = "varchar(300)")
	private String JLMC;//奖励名称
	
	@Column(field = "cgmc", type = "varchar(100)")
	private String CGMC;//成果名称
	
	@Column(field = "hjzz", type = "varchar(100)")
	private String HJZZ;//获奖作者
	
	@Column(field = "zzpx", type = "varchar(20)")
	private String ZZPX;//作者排序
	
	@Column(field = "fzjg", type = "varchar(100)")
	private String FZJG;//发证机关
	
	@Column(field = "hjrq", type = "varchar(20)")
	private String HJRQ;//获奖日期
	
	@Column(field = "xxsm", type = "varchar(100)")
	private String XXSM;//学校署名
	
	@Column(field = "hjjb", type = "varchar(50)")
	private String HJJB;//获奖级别
	
	@Column(field = "hjdj", type = "varchar(50)")
	private String HJDJ;//获奖等级
	
	@Column(field = "dwpm", type = "varchar(20)")
	private String DWPM;//单位排名
	
	@Column(field = "sftj", type = "varchar(20)")
	private String SFTJ;//是否统计
	
	@Column(field = "shzt", type = "varchar(50)")
	private String SHZT;
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public HJ() {
		ID = 0;
		JLMC = "";
		CGMC = "";
		HJZZ = "";
		ZZPX = "";
		FZJG = "";
		HJRQ = "";
		XXSM = "";
		HJJB = "";
		HJDJ = "";
		DWPM = "";
		SFTJ = "";
		SHZT = "";
		ISDEL = 0;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getJLMC() {
		return JLMC;
	}

	public void setJLMC(String jLMC) {
		JLMC = jLMC;
	}

	public String getCGMC() {
		return CGMC;
	}

	public void setCGMC(String cGMC) {
		CGMC = cGMC;
	}

	public String getHJZZ() {
		return HJZZ;
	}

	public void setHJZZ(String hJZZ) {
		HJZZ = hJZZ;
	}

	public String getZZPX() {
		return ZZPX;
	}

	public void setZZPX(String zZPX) {
		ZZPX = zZPX;
	}

	public String getFZJG() {
		return FZJG;
	}

	public void setFZJG(String fZJG) {
		FZJG = fZJG;
	}

	public String getHJRQ() {
		return HJRQ;
	}

	public void setHJRQ(String hJRQ) {
		HJRQ = hJRQ;
	}

	public String getXXSM() {
		return XXSM;
	}

	public void setXXSM(String xXSM) {
		XXSM = xXSM;
	}

	public String getHJJB() {
		return HJJB;
	}

	public void setHJJB(String hJJB) {
		HJJB = hJJB;
	}

	public String getHJDJ() {
		return HJDJ;
	}

	public void setHJDJ(String hJDJ) {
		HJDJ = hJDJ;
	}

	public String getDWPM() {
		return DWPM;
	}

	public void setDWPM(String dWPM) {
		DWPM = dWPM;
	}

	public String getSFTJ() {
		return SFTJ;
	}

	public void setSFTJ(String sFTJ) {
		SFTJ = sFTJ;
	}

	public String getSHZT() {
		return SHZT;
	}

	public void setSHZT(String sHZT) {
		SHZT = sHZT;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
