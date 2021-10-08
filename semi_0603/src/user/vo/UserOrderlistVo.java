package user.vo;

import java.sql.Date;

public class UserOrderlistVo {
	private Date ordate;
	private int orid;
	private String pimage2;
	private String sname;
	private String odcolor;
	private String odsize;
	private int odcount;
	private int pprice;
	private String ordelivery;
	private String orcomplete;
	private String orcancle;
	private int odid;
	private int pid;
	private int sid;
	public UserOrderlistVo() {}
	public UserOrderlistVo(Date ordate, int orid, String pimage2, String sname, String odcolor, String odsize,
			int odcount, int pprice, String ordelivery, String orcomplete, String orcancle, int odid, int pid,
			int sid) {
		super();
		this.ordate = ordate;
		this.orid = orid;
		this.pimage2 = pimage2;
		this.sname = sname;
		this.odcolor = odcolor;
		this.odsize = odsize;
		this.odcount = odcount;
		this.pprice = pprice;
		this.ordelivery = ordelivery;
		this.orcomplete = orcomplete;
		this.orcancle = orcancle;
		this.odid = odid;
		this.pid = pid;
		this.sid = sid;
	}
	public Date getOrdate() {
		return ordate;
	}
	public void setOrdate(Date ordate) {
		this.ordate = ordate;
	}
	public int getOrid() {
		return orid;
	}
	public void setOrid(int orid) {
		this.orid = orid;
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
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getOrdelivery() {
		return ordelivery;
	}
	public void setOrdelivery(String ordelivery) {
		this.ordelivery = ordelivery;
	}
	public String getOrcomplete() {
		return orcomplete;
	}
	public void setOrcomplete(String orcomplete) {
		this.orcomplete = orcomplete;
	}
	public String getorcancle() {
		return orcancle;
	}
	public void setorcancle(String orcancle) {
		this.orcancle = orcancle;
	}
	public int getOdid() {
		return odid;
	}
	public void setOdid(int odid) {
		this.odid = odid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}

}
