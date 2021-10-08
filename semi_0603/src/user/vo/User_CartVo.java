package user.vo;

public class User_CartVo {
	private int wid;
	private String ccolor;
	private String csize;
	private int camount;
	private String mid;
	private int pid;

	public User_CartVo(int wid, String ccolor, String csize, int camount, String mid, int pid) {
		super();
		this.wid = wid;
		this.ccolor = ccolor;
		this.csize = csize;
		this.camount = camount;
		this.mid = mid;
		this.pid = pid;
	}

	public User_CartVo() {
		super();
	}

	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public String getCcolor() {
		return ccolor;
	}

	public void setCcolor(String ccolor) {
		this.ccolor = ccolor;
	}

	public String getCsize() {
		return csize;
	}

	public void setCsize(String csize) {
		this.csize = csize;
	}

	public int getCamount() {
		return camount;
	}

	public void setCamount(int camount) {
		this.camount = camount;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
