package admin.vo;

import java.sql.Date;

public class Admin_InboundVo {
	private int inid;
	private Date indate;
	private String inname;
	private int inprice;
	private int inamount;
	private String incolor;
	private String insize;
	private String incategory;
	public Admin_InboundVo() {}
	public Admin_InboundVo(int inid, Date indate, String inname, int inprice, int inamount, String incolor,
			String insize, String incategory) {
		super();
		this.inid = inid;
		this.indate = indate;
		this.inname = inname;
		this.inprice = inprice;
		this.inamount = inamount;
		this.incolor = incolor;
		this.insize = insize;
		this.incategory = incategory;
	}
	public int getInid() {
		return inid;
	}
	public void setInid(int inid) {
		this.inid = inid;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getInname() {
		return inname;
	}
	public void setInname(String inname) {
		this.inname = inname;
	}
	public int getInprice() {
		return inprice;
	}
	public void setInprice(int inprice) {
		this.inprice = inprice;
	}
	public int getInamount() {
		return inamount;
	}
	public void setInamount(int inamount) {
		this.inamount = inamount;
	}
	public String getIncolor() {
		return incolor;
	}
	public void setIncolor(String incolor) {
		this.incolor = incolor;
	}
	public String getInsize() {
		return insize;
	}
	public void setInsize(String insize) {
		this.insize = insize;
	}
	public String getIncategory() {
		return incategory;
	}
	public void setIncategory(String incategory) {
		this.incategory = incategory;
	}
	
}
