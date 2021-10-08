package user.vo;

public class USer_FaqVo {
	private int fid;
	private String ftitle;
	private String fcontent;
	private int fhint;
	private int fpublic_private;
	private String aid;

	public USer_FaqVo(int fid, String ftitle, String fcontent, int fhint, int fpublic_private, String aid) {
		this.fid = fid;
		this.ftitle = ftitle;
		this.fcontent = fcontent;
		this.fhint = fhint;
		this.fpublic_private = fpublic_private;
		this.aid = aid;
	}

	public USer_FaqVo() {
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

	public int getFhint() {
		return fhint;
	}

	public void setFhint(int fhint) {
		this.fhint = fhint;
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
