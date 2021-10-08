package user.vo;

import java.sql.Date;

public class User_ProductReview {
	private String mid;
	private String sname;
	private String rtitle;
	private String rcontent;
	private String rphoto1;
	private Date rdate;
	private String scolor;
	private String ssize;
	public User_ProductReview(String mid, String sname, String rtitle, String rcontent, String rphoto1, Date rdate,
			String scolor, String ssize) {
		super();
		this.mid = mid;
		this.sname = sname;
		this.rtitle = rtitle;
		this.rcontent = rcontent;
		this.rphoto1 = rphoto1;
		this.rdate = rdate;
		this.scolor = scolor;
		this.ssize = ssize;
	}
	public User_ProductReview() {
		super();
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
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
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public String getScolor() {
		return scolor;
	}
	public void setScolor(String scolor) {
		this.scolor = scolor;
	}
	public String getSsize() {
		return ssize;
	}
	public void setSsize(String ssize) {
		this.ssize = ssize;
	}

}
