package user.vo;

public class User_ProductListVo {
	//product���̺�: ��ǰ���̵�,����,������,��ǥ�̹���,�߰��̹���1,�߰��̹���2,�����,��ǰ�ȸ���
	private int pid;
	private int pprice;
	private int pdiscount;
	private String pimage1;
	//������̺�: �����̵�,��ǰ��,����,������,����
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
