package bean;

import java.util.UUID;

import annotation.Column;
import annotation.Table;

/**
 * 科研数据库
 * @author simple
 *
 */

@Table(tableName="t_kysjk", tableComment="科研数据库")
public class KYSJK {
	
	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false, comment="id主键")
	private String ID;
	
	@Column(field="rydm", type="varchar(50)", comment="人员代码")
	private String RYDM;
	
	@Column(field="xm", type="varchar(50)", comment="姓名")
	private String XM;
	
	@Column(field="zc", type="varchar(50)", comment="职称")
	private String ZC;
	
	@Column(field="lwdf", type="varchar(20)", comment="论文得分")
	private String LWDF;
	
	@Column(field="xmdf", type="varchar(20)", comment="项目得分")
	private String XMDF;
	
	@Column(field="zzdf", type="varchar(20)", comment="著作得分")
	private String ZZDF;
	
	@Column(field="zldf", type="varchar(20)", comment="专利得分")
	private String ZLDF;
	
	@Column(field="dfhj", type="varchar(20)", comment="得分合计")
	private String DFHJ;
	
	@Column(field="bzf", type="varchar(20)", comment="标准分")
	private String BZF;
	
	@Column(field="cefz", type="varchar(20)", comment="超额分值")
	private String CEFZ;
	
	@Column(field="kyjcfs", type="varchar(20)", comment="科研基础分值")
	private String KYJCFS;
	
	@Column(field="cejdf", type="varchar(20)", comment="超额绝对分")
	private String CEJDF;
	
	@Column(field="kyjcjj", type="varchar(20)", comment="超额基础奖金")
	private String KYJCJJ;
	
	@Column(field="kycejj", type="varchar(20)", comment="科研超额奖金")
	private String KYCEJJ;
	
	@Column(field="kyjlhj", type="varchar(20)", comment="科研奖励合计")
	private String KYJLHJ;
	
	@Column(field="nd", type="varchar(10)", comment="年度")
	private String ND;
	
	@Column(field="isdel", type="int(1)", comment="删除标记")
	private int ISDEL;
	
	public KYSJK() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		RYDM = "-";
		XM = "-";
		ZC = "-";
		LWDF = "-";
		XMDF = "-";
		ZZDF = "-";
		ZLDF = "-";
		DFHJ = "-";
		BZF = "-";
		CEFZ = "-";
		KYJCFS = "-";
		CEJDF = "-";
		KYJCJJ = "-";
		KYCEJJ = "-";
		KYJLHJ = "-";
		ND = "-";
		ISDEL = 2;
	}

	/**
	 * 将对象转换为Json字符串
	 * @return
	 */
	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\" : \"");
		builder.append(ID);
		builder.append("\", \"rydm\" : \"");
		builder.append(RYDM);
		builder.append("\", \"xm\" : \"");
		builder.append(XM);
		builder.append("\", \"zc\" : \"");
		builder.append(ZC);
		builder.append("\", \"lwdf\" : \"");
		builder.append(LWDF);
		builder.append("\", \"xmdf\" : \"");
		builder.append(XMDF);
		builder.append("\", \"zzdf\" : \"");
		builder.append(ZZDF);
		builder.append("\", \"zldf\" : \"");
		builder.append(ZLDF);
		builder.append("\", \"dfhj\" : \"");
		builder.append(DFHJ);
		builder.append("\", \"bzf\" : \"");
		builder.append(BZF);
		builder.append("\", \"cefz\" : \"");
		builder.append(CEFZ);
		builder.append("\", \"kyjcfs\" : \"");
		builder.append(KYJCFS);
		builder.append("\", \"cejdf\" : \"");
		builder.append(CEJDF);
		builder.append("\", \"kyjcjj\" : \"");
		builder.append(KYJCJJ);
		builder.append("\", \"kycejj\" : \"");
		builder.append(KYCEJJ);
		builder.append("\", \"kyjlhj\" : \"");
		builder.append(KYJLHJ);
		builder.append("\", \"nd\" : \"");
		builder.append(ND);
		builder.append("\", \"isdel\" : ");
		builder.append(ISDEL);
		builder.append("}]");
		return builder.toString();
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * @return the rYDM
	 */
	public String getRYDM() {
		return RYDM;
	}

	/**
	 * @param rYDM the rYDM to set
	 */
	public void setRYDM(String rYDM) {
		RYDM = rYDM;
	}

	/**
	 * @return the xM
	 */
	public String getXM() {
		return XM;
	}

	/**
	 * @param xM the xM to set
	 */
	public void setXM(String xM) {
		XM = xM;
	}

	/**
	 * @return the zC
	 */
	public String getZC() {
		return ZC;
	}

	/**
	 * @param zC the zC to set
	 */
	public void setZC(String zC) {
		ZC = zC;
	}

	/**
	 * @return the lWDF
	 */
	public String getLWDF() {
		return LWDF;
	}

	/**
	 * @param lWDF the lWDF to set
	 */
	public void setLWDF(String lWDF) {
		LWDF = lWDF;
	}

	/**
	 * @return the xMDF
	 */
	public String getXMDF() {
		return XMDF;
	}

	/**
	 * @param xMDF the xMDF to set
	 */
	public void setXMDF(String xMDF) {
		XMDF = xMDF;
	}

	/**
	 * @return the zZDF
	 */
	public String getZZDF() {
		return ZZDF;
	}

	/**
	 * @param zZDF the zZDF to set
	 */
	public void setZZDF(String zZDF) {
		ZZDF = zZDF;
	}

	/**
	 * @return the zLDF
	 */
	public String getZLDF() {
		return ZLDF;
	}

	/**
	 * @param zLDF the zLDF to set
	 */
	public void setZLDF(String zLDF) {
		ZLDF = zLDF;
	}

	/**
	 * @return the dFHJ
	 */
	public String getDFHJ() {
		return DFHJ;
	}

	/**
	 * @param dFHJ the dFHJ to set
	 */
	public void setDFHJ(String dFHJ) {
		DFHJ = dFHJ;
	}

	/**
	 * @return the bZF
	 */
	public String getBZF() {
		return BZF;
	}

	/**
	 * @param bZF the bZF to set
	 */
	public void setBZF(String bZF) {
		BZF = bZF;
	}

	/**
	 * @return the cEFZ
	 */
	public String getCEFZ() {
		return CEFZ;
	}

	/**
	 * @param cEFZ the cEFZ to set
	 */
	public void setCEFZ(String cEFZ) {
		CEFZ = cEFZ;
	}

	/**
	 * @return the kYJCFS
	 */
	public String getKYJCFS() {
		return KYJCFS;
	}

	/**
	 * @param kYJCFS the kYJCFS to set
	 */
	public void setKYJCFS(String kYJCFS) {
		KYJCFS = kYJCFS;
	}

	/**
	 * @return the cEJDF
	 */
	public String getCEJDF() {
		return CEJDF;
	}

	/**
	 * @param cEJDF the cEJDF to set
	 */
	public void setCEJDF(String cEJDF) {
		CEJDF = cEJDF;
	}

	/**
	 * @return the kYJCJJ
	 */
	public String getKYJCJJ() {
		return KYJCJJ;
	}

	/**
	 * @param kYJCJJ the kYJCJJ to set
	 */
	public void setKYJCJJ(String kYJCJJ) {
		KYJCJJ = kYJCJJ;
	}

	/**
	 * @return the kYCEJJ
	 */
	public String getKYCEJJ() {
		return KYCEJJ;
	}

	/**
	 * @param kYCEJJ the kYCEJJ to set
	 */
	public void setKYCEJJ(String kYCEJJ) {
		KYCEJJ = kYCEJJ;
	}

	/**
	 * @return the kYJLHJ
	 */
	public String getKYJLHJ() {
		return KYJLHJ;
	}

	/**
	 * @param kYJLHJ the kYJLHJ to set
	 */
	public void setKYJLHJ(String kYJLHJ) {
		KYJLHJ = kYJLHJ;
	}

	/**
	 * @return the nD
	 */
	public String getND() {
		return ND;
	}

	/**
	 * @param nD the nD to set
	 */
	public void setND(String nD) {
		ND = nD;
	}

	/**
	 * @return the iSDEL
	 */
	public int getISDEL() {
		return ISDEL;
	}

	/**
	 * @param iSDEL the iSDEL to set
	 */
	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}