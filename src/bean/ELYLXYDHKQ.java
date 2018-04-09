package bean;

import annotation.Column;
import annotation.Table;

/**
 * 2016年学院大会考勤
 * @author simple
 *
 */

@Table(tableName = "t_elylxydhkq")
public class ELYLXYDHKQ {

	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id 主键
	
	@Column(field = "xh", type = "varchar(20)")
	private String XH;//序号
	
	@Column(field = "xm", type = "varchar(50)")
	private String XM;//姓名
	
	@Column(field = "yyswr", type = "varchar(100)")
	private String YYSWR;//1月15日
	
	@Column(field = "eyesyr", type = "varchar(100)")
	private String EYESYR;//2月21日
	
	@Column(field = "syssyr", type = "varchar(100)")
	private String SYSSYR;//10月31日
	
	@Column(field = "seyeser", type = "varchar(100)")
	private String SEYESER;//12月22日
	
	@Column(field = "hyzcs", type = "int(4)")
	private int HYZCS;//会议总次数
	
	@Column(field = "dhcs", type = "int(4)")
	private int DHCS;//到会次数

	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除
	
	public ELYLXYDHKQ() {
		ID = 0;
		XH = "";
		XM = "";
		YYSWR = "";
		EYESYR = "";
		SYSSYR = "";
		SEYESER = "";
		HYZCS = 0;
		DHCS = 0;
		ISDEL = 0;
		
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getXH() {
		return XH;
	}

	public void setXH(String xH) {
		XH = xH;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String xM) {
		XM = xM;
	}

	public String getYYSWR() {
		return YYSWR;
	}

	public void setYYSWR(String yYSWR) {
		YYSWR = yYSWR;
	}

	public String getEYESYR() {
		return EYESYR;
	}

	public void setEYESYR(String eYESYR) {
		EYESYR = eYESYR;
	}

	public String getSYSSYR() {
		return SYSSYR;
	}

	public void setSYSSYR(String sYSSYR) {
		SYSSYR = sYSSYR;
	}

	public String getSEYESER() {
		return SEYESER;
	}

	public void setSEYESER(String sEYESER) {
		SEYESER = sEYESER;
	}

	public int getHYZCS() {
		return HYZCS;
	}

	public void setHYZCS(int hYZCS) {
		HYZCS = hYZCS;
	}

	public int getDHCS() {
		return DHCS;
	}

	public void setDHCS(int dHCS) {
		DHCS = dHCS;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
