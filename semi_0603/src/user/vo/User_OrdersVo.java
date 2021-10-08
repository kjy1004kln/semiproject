package user.vo;

import java.sql.Date;

public class User_OrdersVo {
	public int orid;
	public Date ordate;
	public String orname;
	public String orphone;
	public String oraddress;
	public String orpost;
	public int orpayment;
	public int orinvoice;
	public int ordelpay;
	public String ordelivery;
	public String orcomplete;
	public String orcancle;
	public String ortotal;
	public String orpaymoney;
	public String mid;

	public User_OrdersVo(int orid, Date ordate, String orname, String orphone, String oraddress, String orpost,
			int orpayment, int orinvoice, int ordelpay, String ordelivery, String orcomplete, String orcancle,
			String ortotal, String orpaymoney, String mid) {
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
		this.ortotal = ortotal;
		this.orpaymoney = orpaymoney;
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

	public int getOrpayment() {
		return orpayment;
	}

	public void setOrpayment(int orpayment) {
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

	public String getOrtotal() {
		return ortotal;
	}

	public void setOrtotal(String ortotal) {
		this.ortotal = ortotal;
	}

	public String getOrpaymoney() {
		return orpaymoney;
	}

	public void setOrpaymoney(String orpaymoney) {
		this.orpaymoney = orpaymoney;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

}
