package admin.vo;

import java.sql.Date;

public class Admin_MembersVo {
	private String mid;
	private String mpw;
	private String mname;
	private String maddress;
	private String mpost;
	private String mphone;
	private Date mrdate;
	private Date mbirth;
	private int mdrop;
	private int mmileage;
	private String memail;
	private String addphone;
	private String addname;
	private String addtitle;
	
	public Admin_MembersVo() {}

	public Admin_MembersVo(String mid, String mpw, String mname, String maddress, String mpost, String mphone,
			Date mrdate, Date mbirth, int mdrop, int mmileage, String memail, String addphone, String addname,
			String addtitle) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.maddress = maddress;
		this.mpost = mpost;
		this.mphone = mphone;
		this.mrdate = mrdate;
		this.mbirth = mbirth;
		this.mdrop = mdrop;
		this.mmileage = mmileage;
		this.memail = memail;
		this.addphone = addphone;
		this.addname = addname;
		this.addtitle = addtitle;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMaddress() {
		return maddress;
	}

	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}

	public String getMpost() {
		return mpost;
	}

	public void setMpost(String mpost) {
		this.mpost = mpost;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public Date getMrdate() {
		return mrdate;
	}

	public void setMrdate(Date mrdate) {
		this.mrdate = mrdate;
	}

	public Date getMbirth() {
		return mbirth;
	}

	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}

	public int getMdrop() {
		return mdrop;
	}

	public void setMdrop(int mdrop) {
		this.mdrop = mdrop;
	}

	public int getMmileage() {
		return mmileage;
	}

	public void setMmileage(int mmileage) {
		this.mmileage = mmileage;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getAddphone() {
		return addphone;
	}

	public void setAddphone(String addphone) {
		this.addphone = addphone;
	}

	public String getAddname() {
		return addname;
	}

	public void setAddname(String addname) {
		this.addname = addname;
	}

	public String getAddtitle() {
		return addtitle;
	}

	public void setAddtitle(String addtitle) {
		this.addtitle = addtitle;
	}
	
}
