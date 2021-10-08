package user.vo;

public class User_GradeVo {
	public int gid;
	public String glevel;
	public int gbuy;
	public String mid;
	public User_GradeVo() {};
	public User_GradeVo(int gid, String glevel, int gbuy, String mid) {
		super();
		this.gid = gid;
		this.glevel = glevel;
		this.gbuy = gbuy;
		this.mid = mid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGlevel() {
		return glevel;
	}
	public void setGlevel(String glevel) {
		this.glevel = glevel;
	}
	public int getGbuy() {
		return gbuy;
	}
	public void setGbuy(int gbuy) {
		this.gbuy = gbuy;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
}
