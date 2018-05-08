package bean;

import java.util.UUID;

import annotation.Column;
import annotation.Table;

@Table(tableName="t_jysgztjb")
public class JYSGZTJB {

	@Column(field="id", type="varchar(100)", primaryKey=true, defaultNull=false)
	private String ID;
	
	@Column(field="jysmc", type="varchar(100)")
	private String JYSMC;//教研室名称
	
	@Column(field="jcxm", type="varchar(20)")
	private String JCXM;//教材项目
	
	@Column(field="qykcxm", type="varchar(20)")
	private String QYKCXM;//全英课程项目
	
	@Column(field="sqxxxm", type="varchar(20)")
	private String SQXXXM;//暑期学校项目
	
	@Column(field="cxktxm", type="varchar(20)")
	private String CXKTXM;//创新课堂项目
	
	@Column(field="zhggxm", type="varchar(20)")
	private String ZHGGXM;//综合改革项目
	
	@Column(field="jxmscxxm", type="varchar(20)")
	private String JXMSCXXM;//教学模式创新项目
	
	@Column(field="sxddjs", type="varchar(20)")
	private String SXDDJS;//实习带队老师
	
	@Column(field="wksj", type="varchar(20)")
	private String WKSJ;//微课赛教
	
	@Column(field="hj", type="varchar(20)")
	private String HJ;//合计
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;
	
	public JYSGZTJB() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		JYSMC = "-";
		JCXM = "-";
		QYKCXM = "-";
		SQXXXM = "-";
		CXKTXM = "-";
		ZHGGXM = "-";
		JXMSCXXM = "-";
		SXDDJS = "-";
		WKSJ = "-";
		HJ = "-";
		ISDEL = 2;
	}
	
	public String toJson() {
		return "[{\"id\":\"" + ID + "\", \"jysmc\":\"" + JYSMC + "\", \"jcxm\":\"" + JCXM + "\", \"qykcxm\":\""
				+ QYKCXM + "\", \"sqxxxm\":\"" + SQXXXM + "\", \"cxktxm\":\"" + CXKTXM + "\", \"zhggxm\":\""
				+ ZHGGXM + "\", \"jxmscxxm\":\"" + JXMSCXXM + "\", \"sxddjs\":\"" + SXDDJS + "\", \"wksj\":\""
				+ WKSJ + "\", \"hj\":\"" + HJ + "\", \"isdel\":" + ISDEL + "}]";
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getJYSMC() {
		return JYSMC;
	}

	public void setJYSMC(String jYSMC) {
		JYSMC = jYSMC;
	}

	public String getJCXM() {
		return JCXM;
	}

	public void setJCXM(String jCXM) {
		JCXM = jCXM;
	}

	public String getQYKCXM() {
		return QYKCXM;
	}

	public void setQYKCXM(String qYKCXM) {
		QYKCXM = qYKCXM;
	}

	public String getSQXXXM() {
		return SQXXXM;
	}

	public void setSQXXXM(String sQXXXM) {
		SQXXXM = sQXXXM;
	}

	public String getCXKTXM() {
		return CXKTXM;
	}

	public void setCXKTXM(String cXKTXM) {
		CXKTXM = cXKTXM;
	}

	public String getZHGGXM() {
		return ZHGGXM;
	}

	public void setZHGGXM(String zHGGXM) {
		ZHGGXM = zHGGXM;
	}

	public String getJXMSCXXM() {
		return JXMSCXXM;
	}

	public void setJXMSCXXM(String jXMSCXXM) {
		JXMSCXXM = jXMSCXXM;
	}

	public String getSXDDJS() {
		return SXDDJS;
	}

	public void setSXDDJS(String sXDDJS) {
		SXDDJS = sXDDJS;
	}

	public String getWKSJ() {
		return WKSJ;
	}

	public void setWKSJ(String wKSJ) {
		WKSJ = wKSJ;
	}

	public String getHJ() {
		return HJ;
	}

	public void setHJ(String hJ) {
		HJ = hJ;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
