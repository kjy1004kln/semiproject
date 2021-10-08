package user.vo;

import java.sql.Date;

public class User_ReviewVo {
	public String sname;
	public String rtitle;
	public String pimage2;
	public String rcontent;
	public String rphoto1;
	public String mid;
	public Date rrdate;
	public User_ReviewVo() {}
	public User_ReviewVo(String sname, String rtitle, String pimage2, String rcontent, String rphoto1, String mid,
			Date rrdate) {
		super();
		this.sname = sname;
		this.rtitle = rtitle;
		this.pimage2 = pimage2;
		this.rcontent = rcontent;
		this.rphoto1 = rphoto1;
		this.mid = mid;
		this.rrdate = rrdate;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public String getPimage2() {
		return pimage2;
	}
	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRphoto1() {
		return rphoto1;
	}
	public void setRphoto1(String rphoto1) {
		this.rphoto1 = rphoto1;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Date getRrdate() {
		return rrdate;
	}
	public void setRrdate(Date rrdate) {
		this.rrdate = rrdate;
	}
	
}
