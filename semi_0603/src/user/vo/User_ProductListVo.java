package user.vo;

public class User_ProductListVo {
	//product테이블: 상품아이디,가격,할인율,대표이미지,추가이미지1,추가이미지2,등록일,상품팔린수
	private int pid;
	private int pprice;
	private int pdiscount;
	private String pimage1;
	//재고테이블: 재고아이디,상품명,색상,사이즈,수량
	private String sname;

	public User_ProductListVo(int pid, int pprice, int pdiscount, String pimage1, String sname) {
		this.pid = pid;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.pimage1 = pimage1;
		this.sname = sname;
	}
	public User_ProductListVo() {
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
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
