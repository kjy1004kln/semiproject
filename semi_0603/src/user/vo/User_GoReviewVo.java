package user.vo;

import java.sql.Date;

public class User_GoReviewVo {

	private String pimage2;
	private String sname;
	private String ssize;
	private String odcolor;
	private Date ordate;
	private String mname;
	public User_GoReviewVo() {}
	public User_GoReviewVo(String pimage2, String sname, String ssize, String odcolor, Date ordate, String mname) {
		super();
		this.pimage2 = pimage2;
		this.sname = sname;
		this.ssize = ssize;
		this.odcolor = odcolor;
		this.ordate = ordate;
		this.mname = mname;
	}
	public String getPimage2() {
		return pimage2;
	}
	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsize() {
		return ssize;
	}
	public void setSsize(String ssize) {
		this.ssize = ssize;
	}
	public String getOdcolor() {
		return odcolor;
	}
	public void setOdcolor(String odcolor) {
		this.odcolor = odcolor;
	}
	public Date getOrdate() {
		return ordate;
	}
	public void setOrdate(Date ordate) {
		this.ordate = ordate;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
}
