package bean;

import annotation.Column;
import annotation.Table;
import config.DefalutValue;

@Table(tableName="t_kfzysjk")

public class KFZYSJK {
	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;
	
	@Column(field="zyid", type="char(32)", comment="资源ID")
	private String ZYID;
	
	@Column(field="zymc", type="varchar(50)", comment="资源名称")
	private String ZYMC;
	
	@Column(field="kfsj0", type="varchar(50)", comment="开放时间（始）")
	private String KFSJ0;

	@Column(field="kfsj1", type="varchar(50)", comment="开放时间（终）")
	private String KFSJ1;
	
	@Column(field="kfnx", type="varchar(50)", comment="开放年限")
	private String KFNX;
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;

	public KFZYSJK() {
		ID = DefalutValue.DEFAULT_VALUE_OF_ID();
		ZYID = DefalutValue.DEFAULT_STRING_VALUE;
		ZYMC = DefalutValue.DEFAULT_STRING_VALUE;
		KFSJ0 = DefalutValue.DEFAULT_STRING_VALUE;
		KFSJ1 = DefalutValue.DEFAULT_STRING_VALUE;
		KFNX = DefalutValue.DEFAULT_STRING_VALUE;
		ISDEL = DefalutValue.DEFAULT_INITIALIZATION_INT_VALUE;
	}
	
	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\":\"");
		builder.append(ID);
		builder.append("\", \"zyid\":\"");
		builder.append(ZYID);
		builder.append("\", \"zymc\":\"");
		builder.append(ZYMC);
		builder.append("\", \"kfsj0\":\"");
		builder.append(KFSJ0);
		builder.append("\", \"kfsj1\":\"");
		builder.append(KFSJ1);
		builder.append("\", \"kfnx\":\"");
		builder.append(KFNX);
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

	public String getZYID() {
		return ZYID;
	}

	public void setZYID(String zYID) {
		ZYID = zYID;
	}

	public String getZYMC() {
		return ZYMC;
	}

	public void setZYMC(String zYMC) {
		ZYMC = zYMC;
	}

	public String getKFSJ0() {
		return KFSJ0;
	}

	public void setKFSJ0(String kFSJ0) {
		KFSJ0 = kFSJ0;
	}

	public String getKFSJ1() {
		return KFSJ1;
	}

	public void setKFSJ1(String kFSJ1) {
		KFSJ1 = kFSJ1;
	}

	public String getKFNX() {
		return KFNX;
	}

	public void setKFNX(String kFNX) {
		KFNX = kFNX;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
