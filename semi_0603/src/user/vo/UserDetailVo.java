package user.vo;

public class UserDetailVo {
	private int sid;
	private String sname;
	private String scolor;
	private String ssize;
	private int samount;
	private String pimage2;

	public UserDetailVo(int sid, String sname, String scolor, String ssize, int samount, String pimage2) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.scolor = scolor;
		this.ssize = ssize;
		this.samount = samount;
		this.pimage2 = pimage2;
	}

	public UserDetailVo() {
		super();
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public int getSamount() {
		return samount;
	}

	public void setSamount(int samount) {
		this.samount = samount;
	}

	public String getPimage2() {
		return pimage2;
	}

	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}

}
