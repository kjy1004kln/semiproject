package admin.vo;

import java.sql.Date;

public class Admin_AdminVo {
	private String aid;
	private String apw;
	private String aname;
	private Date ardate;
	
	public Admin_AdminVo() {}
	public Admin_AdminVo(String aid, String apw, String aname, Date ardate) {
		super ();
		this.aid=aid;
		this.apw=apw;
		this.aname=aname;
		this.ardate=ardate;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getApw() {
		return apw;
	}
	public void setApw(String apw) {
		this.apw = apw;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Date getArdate() {
		return ardate;
	}
	public void setArdate(Date ardate) {
		this.ardate = ardate;
	}
	
}
