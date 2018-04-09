package bean;

import annotation.Table;
import annotation.Column;

@Table(tableName = "t_lw")
public class LW {
	
	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id 主键
	
	@Column(field = "lwtm", type = "varchar(100)")
	private String LWTM;//论文题目
	
	@Column(field = "dyzz", type = "varchar(50)")
	private String DYZZ;//第一作者
	
	@Column(field = "zzsx", type = "varchar(200)")
	private String ZZSX;//作者属性
	
	@Column(field = "zzpx", type = "varchar(20)")
	private String ZZPX;//作者排序
	
	@Column(field = "syzz", type = "varchar(100)")
	private String SYZZ;//所有作者
	
	@Column(field = "zzrs", type = "varchar(10)")
	private String ZZRS;//作者人数
	
	@Column(field = "fbhcbsj", type = "varchar(20)")
	private String FBHCBSJ;//发表或出版时间
	
	@Column(field = "fbkwhlwj", type = "varchar(100)")
	private String FBKWHLWJ;//发表刊物或论文集
	
	@Column(field = "lwjb", type = "varchar(20)")
	private String LWJB;//论文级别
	
	@Column(field = "xxsm", type = "varchar(100)")
	private String XXSM;//学校署名
	
	@Column(field = "shzt", type = "varchar(50)")
	private String SHZT;//审核状态
	
	@Column(field = "sftj", type = "varchar(10)")
	private String SFTJ;//是否统计
	
	@Column(field = "kydf", type = "double(10, 2)")
	private double KYDF;//科研得分
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getLWTM() {
		return LWTM;
	}

	public void setLWTM(String lWTM) {
		LWTM = lWTM;
	}

	public String getDYZZ() {
		return DYZZ;
	}

	public void setDYZZ(String dYZZ) {
		DYZZ = dYZZ;
	}

	public String getZZSX() {
		return ZZSX;
	}

	public void setZZSX(String zZSX) {
		ZZSX = zZSX;
	}

	public String getZZPX() {
		return ZZPX;
	}

	public void setZZPX(String zZPX) {
		ZZPX = zZPX;
	}

	public String getSYZZ() {
		return SYZZ;
	}

	public void setSYZZ(String sYZZ) {
		SYZZ = sYZZ;
	}

	public String getZZRS() {
		return ZZRS;
	}

	public void setZZRS(String zZRS) {
		ZZRS = zZRS;
	}

	public String getFBHCBSJ() {
		return FBHCBSJ;
	}

	public void setFBHCBSJ(String fBHCBSJ) {
		FBHCBSJ = fBHCBSJ;
	}

	public String getFBKWHLWJ() {
		return FBKWHLWJ;
	}

	public void setFBKWHLWJ(String fBKWHLWJ) {
		FBKWHLWJ = fBKWHLWJ;
	}

	public String getLWJB() {
		return LWJB;
	}

	public void setLWJB(String lWJB) {
		LWJB = lWJB;
	}

	public String getXXSM() {
		return XXSM;
	}

	public void setXXSM(String xXSM) {
		XXSM = xXSM;
	}

	public String getSHZT() {
		return SHZT;
	}

	public void setSHZT(String sHZT) {
		SHZT = sHZT;
	}

	public String getSFTJ() {
		return SFTJ;
	}

	public void setSFTJ(String sFTJ) {
		SFTJ = sFTJ;
	}

	public double getKYDF() {
		return KYDF;
	}

	public void setKYDF(double kYDF) {
		KYDF = kYDF;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
