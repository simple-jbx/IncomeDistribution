package bean;

import annotation.Table;
import annotation.Column;

/**
 * 著作
 * @author simple
 *
 */

@Table(tableName = "t_zz")
public class ZZ {

	@Column(field = "id", type = "int(32)", primaryKey = true, defaultNull = false)
	private int ID;//id,主键
	
	@Column(field = "zztm", type = "varchar(100)")
	private String ZZTM;//著作题目
	
	@Column(field = "dyzz", type = "varchar(50)")
	private String DYZZ;//第一作者
	
	@Column(field = "zzpx", type = "varchar(20)")
	private String ZZPX;//作者排序
	
	@Column(field = "syzz", type = "varchar(300)")
	private String SYZZ;//所有作者
	
	@Column(field = "cbdw", type = "varchar(100)")
	private String CBDW;//出版单位
	
	@Column(field = "cbsj", type = "varchar(20)")
	private String CBSJ;//出版时间
	
	@Column(field = "xxsm", type = "varchar(100)")
	private String XXSM;//学校署名
	
	@Column(field = "zzlb", type = "varchar(50)")
	private String ZZLB;//著作类别
	
	@Column(field = "zzs", type = "varchar(20)")
	private String ZZS;//总字数
	
	@Column(field = "cbrs", type = "varchar(10)")
	private String CBRS;//参编人数
	
	@Column(field = "shzt", type = "varchar(20)")
	private String SHZT;//审核状态
	
	@Column(field = "sftj", type = "varchar(20)")
	private String SFTJ;//是否统计
	
	@Column(field = "isdel", type = "int(1)")
	private int ISDEL;//是否删除

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getZZTM() {
		return ZZTM;
	}

	public void setZZTM(String zZTM) {
		ZZTM = zZTM;
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

	public String getSYZZ() {
		return SYZZ;
	}

	public void setSYZZ(String sYZZ) {
		SYZZ = sYZZ;
	}

	public String getCBDW() {
		return CBDW;
	}

	public void setCBDW(String cBDW) {
		CBDW = cBDW;
	}

	public String getCBSJ() {
		return CBSJ;
	}

	public void setCBSJ(String cBSJ) {
		CBSJ = cBSJ;
	}

	public String getXXSM() {
		return XXSM;
	}

	public void setXXSM(String xXSM) {
		XXSM = xXSM;
	}

	public String getZZLB() {
		return ZZLB;
	}

	public void setZZLB(String zZLB) {
		ZZLB = zZLB;
	}

	public String getZZS() {
		return ZZS;
	}

	public void setZZS(String zZS) {
		ZZS = zZS;
	}

	public String getCBRS() {
		return CBRS;
	}

	public void setCBRS(String cBRS) {
		CBRS = cBRS;
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

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
