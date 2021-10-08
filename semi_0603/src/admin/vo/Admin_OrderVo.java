package admin.vo;

import java.sql.Date;

public class Admin_OrderVo {
	private int orid;
	private Date ordate;
	private String orname;
	private String orphone;
	private String oraddress;
	private String orpost;
	private String orpayment;
	private int orinvoice;
	private int ordelpay;
	private String ordelivery;
	private String orcomplete;
	private String orcancle;
	private String mid;
	public Admin_OrderVo(int orid, Date ordate, String orname, String orphone, String oraddress, String orpost,
			String orpayment, int orinvoice, int ordelpay, String ordelivery, String orcomplete, String orcancle,
			String mid) {
		super();
		this.orid = orid;
		this.ordate = ordate;
		this.orname = orname;
		this.orphone = orphone;
		this.oraddress = oraddress;
		this.orpost = orpost;
		this.orpayment = orpayment;
		this.orinvoice = orinvoice;
		this.ordelpay = ordelpay;
		this.ordelivery = ordelivery;
		this.orcomplete = orcomplete;
		this.orcancle = orcancle;
		this.mid = mid;
	}
	public int getOrid() {
		return orid;
	}
	public void setOrid(int orid) {
		this.orid = orid;
	}
	public Date getOrdate() {
		return ordate;
	}
	public void setOrdate(Date ordate) {
		this.ordate = ordate;
	}
	public String getOrname() {
		return orname;
	}
	public void setOrname(String orname) {
		this.orname = orname;
	}
	public String getOrphone() {
		return orphone;
	}
	public void setOrphone(String orphone) {
		this.orphone = orphone;
	}
	public String getOraddress() {
		return oraddress;
	}
	public void setOraddress(String oraddress) {
		this.oraddress = oraddress;
	}
	public String getOrpost() {
		return orpost;
	}
	public void setOrpost(String orpost) {
		this.orpost = orpost;
	}
	public String getOrpayment() {
		return orpayment;
	}
	public void setOrpayment(String orpayment) {
		this.orpayment = orpayment;
	}
	public int getOrinvoice() {
		return orinvoice;
	}
	public void setOrinvoice(int orinvoice) {
		this.orinvoice = orinvoice;
	}
	public int getOrdelpay() {
		return ordelpay;
	}
	public void setOrdelpay(int ordelpay) {
		this.ordelpay = ordelpay;
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
	public String getOrcancle() {
		return orcancle;
	}
	public void setOrcancle(String orcancle) {
		this.orcancle = orcancle;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
}
