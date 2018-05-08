package bean;

import annotation.Column;
import annotation.Table;
import java.util.UUID;
/**
 * 用户角色
 * @author simple
 *
 */

@Table(tableName = "t_yhjs")
public class YHJS {
	
	@Column(field = "yhjsid", type = "char(32)", primaryKey = true, defaultNull = false)
	private String YHJSID;//用户角色ID
	
	@Column(field = "yhrydm", type = "char(32)")
	private String YHRYDM;//用户代码
	
	@Column(field = "jsid", type = "char(32)")
	private String JSID;//角色ID
	
	@Column(field = "yhjsnote", type = "text")
	private String YHJSNOTE;//用户角色注释

	@Column(field = "isdel", type="int(1)")
	private int ISDEL;//是否删除

	public YHJS() {
		YHJSID = UUID.randomUUID().toString().replaceAll("-", "");
		YHRYDM = "-";
		JSID = "-";
		YHJSNOTE = "-";
		ISDEL = 2;
	}
	
	
	public String toJSON() {
		StringBuilder builder = new StringBuilder();
		builder.append("[{\"yhjsid\":\"");
		builder.append(YHJSID);
		builder.append("\", \"yhid\":\"");
		builder.append(YHRYDM);
		builder.append("\", \"jsid\":\"");
		builder.append(JSID);
		builder.append("\", \"yhjsNOTE\":\"");
		builder.append(YHJSNOTE);
		builder.append("\", \"isdel\":");
		builder.append(ISDEL);
		builder.append("}]");
		return builder.toString();
	}



	public String getYHJSID() {
		return YHJSID;
	}

	public void setYHJSID(String yHJSID) {
		YHJSID = yHJSID;
	}

	public String getYHRYDM() {
		return YHRYDM;
	}

	public void setYHRYDM(String yHRYDM) {
		YHRYDM = yHRYDM;
	}

	public String getJSID() {
		return JSID;
	}

	public void setJSID(String jSID) {
		JSID = jSID;
	}

	public String getYHJSNOTE() {
		return YHJSNOTE;
	}

	public void setYHJSNOTE(String yHJSNOTE) {
		YHJSNOTE = yHJSNOTE;
	}

	public int getISDEL() {
		return ISDEL;
	}

	public void setISDEL(int iSDEL) {
		ISDEL = iSDEL;
	}
}
