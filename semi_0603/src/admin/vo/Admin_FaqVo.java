package admin.vo;

import java.sql.Date;

public class Admin_FaqVo {
	private int fid;
	private String ftitle;
	private String fcontent;
	private Date frdate;
	private int fhit;
	private int fpublic_private;
	private String aid;
	public Admin_FaqVo() {}
	public Admin_FaqVo(int fid,String ftitle,String fcontent,Date frdate,
							int fhit, int fpublic_private,String aid) {
		super();
		this.fid=fid;
		this.ftitle=ftitle;
		this.fcontent=fcontent;
		this.frdate=frdate;
		this.fhit=fhit;
		this.fpublic_private=fpublic_private;
		this.aid=aid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getFcontent() {
		return fcontent;
	}
	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}
	
	public Date getFrdate() {
		return frdate;
	}
	public void setFrdate(Date frdate) {
		this.frdate = frdate;
	}
	public int getFhit() {
		return fhit;
	}
	public void setFhit(int fhit) {
		this.fhit = fhit;
	}
	public int getFpublic_private() {
		return fpublic_private;
	}
	public void setFpublic_private(int fpublic_private) {
		this.fpublic_private = fpublic_private;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	
}
