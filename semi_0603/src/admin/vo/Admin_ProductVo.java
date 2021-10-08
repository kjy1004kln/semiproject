package admin.vo;

import java.sql.Date;

public class Admin_ProductVo {
	private int pid;
	private int pprice;
	private int pdiscount;
	private String pimage1;
	private String pimage2;
	private Date prdate;
	private int psell;
	private int sid;
	public Admin_ProductVo() {}
	public Admin_ProductVo(int pid, int pprice, int pdiscount, String pimage1, String pimage2,
			Date prdate, int psell, int sid) {
		super();
		this.pid = pid;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pimage1 = pimage1;
		this.pimage2 = pimage2;
		this.prdate = prdate;
		this.psell = psell;
		this.sid = sid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getPdiscount() {
		return pdiscount;
	}
	public void setPdiscount(int pdiscount) {
		this.pdiscount = pdiscount;
	}
	public String getPimage1() {
		return pimage1;
	}
	public void setPimage1(String pimage1) {
		this.pimage1 = pimage1;
	}
	public String getPimage2() {
		return pimage2;
	}
	public void setPimage2(String pimage2) {
		this.pimage2 = pimage2;
	}
	public Date getPrdate() {
		return prdate;
	}
	public void setPrdate(Date prdate) {
		this.prdate = prdate;
	}
	public int getPsell() {
		return psell;
	}
	public void setPsell(int psell) {
		this.psell = psell;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
}
