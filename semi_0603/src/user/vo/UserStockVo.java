package user.vo;

public class UserStockVo {
	private int sid;
	private String sname;
	private String scolor;
	private String ssize;
	private int samount;

	public UserStockVo(int sid, String sname, String scolor, String ssize, int samount) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.scolor = scolor;
		this.ssize = ssize;
		this.samount = samount;
	}

	public UserStockVo() {
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

}
