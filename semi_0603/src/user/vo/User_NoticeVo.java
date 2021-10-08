package user.vo;

import java.sql.Date;

public class User_NoticeVo {
	private int fid;
	private String ftitle;
	private String fcontent;
	private String ffile;
	private Date frdate;
	private int fhit;
	private int fpublic_private;
	// 0: 공개 1: 비공개
	private String aid;

	public User_NoticeVo(int fid, String ftitle, String fcontent, String ffile, Date frdate, int fhit,
			int fpublic_private, String aid) {
		super();
		this.fid = fid;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.ffile = ffile;
		this.frdate = frdate;
		this.fhit = fhit;
		this.fpublic_private = fpublic_private;
		this.aid = aid;
	}

	public User_NoticeVo() {
		super();
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

	public String getFfile() {
		return ffile;
	}

	public void setFfile(String ffile) {
		this.ffile = ffile;
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
