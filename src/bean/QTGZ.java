package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;

@Table(tableName="t_qtgz", tableComment="其它规则")
public class QTGZ {

	@Column(field="id", type="char(32)", primaryKey=true, defaultNull=false)
	private String ID;//id
	
	@Column(field="xm", type="varchar(50)", comment="项目")
	private String XM;
	
	@Column(field="je", type="varchar(20)", comment="金额")
	private String JE;//金额
	
	@Column(field="fl", type="varchar(50)", comment="分类")
	private String FL;//分类
	
	@Column(field="mc", type="varchar(50)", comment="名称")
	private String MC;//名称
	
	@Column(field="isdel", type="int(1)")
	private int ISDEL;//是否删除
	
	public QTGZ() {
		ID = UUID.randomUUID().toString().replaceAll("-", "");
		XM = "-";
		JE = "-";
		FL = "-";
		MC = "-";
		ISDEL = 2;
	}
	
	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"id\" : \"");
		builder.append(ID);
		builder.append("\", \"xm\" : \"");
		builder.append(XM);
		builder.append("\", \"je\" : \"");
		builder.append(JE);
		builder.append("\", \"fl\" : \"");
		builder.append(FL);
		builder.append("\", \"mc\" : \"");
		builder.append(MC);
		builder.append("\", \"isdel\" : ");
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

	public String getXM() {
		return XM;
	}

	public void setXM(String xM) {
		XM = xM;
	}

	public String getJE() {
		return JE;
	}

	public void setJE(String jE) {
		JE = jE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}

	public String getFL() {
		return FL;
	}

	public void setFL(String fL) {
		FL = fL;
	}

	public String getMC() {
		return MC;
	}

	public void setMC(String mC) {
		MC = mC;
	}
}
