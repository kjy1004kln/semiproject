package user.vo;

public class User_OrdersDetailVo {
	private int odid;
	private String odcolor;
	private String odsize;
	private int odcount;
	private String odcupon;
	private int odmilege;
	private int orid;
	private int pid;

	public User_OrdersDetailVo(int odid, String odcolor, String odsize, int odcount, String odcupon, int odmilege,
			int orid, int pid) {
		super();
		this.odid = odid;
		this.odcolor = odcolor;
		this.odsize = odsize;
		this.odcount = odcount;
		this.odcupon = odcupon;
		this.odmilege = odmilege;
		this.orid = orid;
		this.pid = pid;
	}

	public User_OrdersDetailVo() {
		super();
	}

	public int getOdid() {
		return odid;
	}

	public void setOdid(int odid) {
		this.odid = odid;
	}

	public String getOdcolor() {
		return odcolor;
	}

	public void setOdcolor(String odcolor) {
		this.odcolor = odcolor;
	}

	public String getOdsize() {
		return odsize;
	}

	public void setOdsize(String odsize) {
		this.odsize = odsize;
	}

	public int getOdcount() {
		return odcount;
	}

	public void setOdcount(int odcount) {
		this.odcount = odcount;
	}

	public String getOdcupon() {
		return odcupon;
	}

	public void setOdcupon(String odcupon) {
		this.odcupon = odcupon;
	}

	public int getOdmilege() {
		return odmilege;
	}

	public void setOdmilege(int odmilege) {
		this.odmilege = odmilege;
	}

	public int getOrid() {
		return orid;
	}

	public void setOrid(int orid) {
		this.orid = orid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
