package model;

public class Course {
	int id;
	String ccode;
	String cname;
	String ename;
	String str;
	String category;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	int score;
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	int chour;	
	int lhour;
	int tchour;
	int sex;
	int tlhour;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getChour() {
		return chour;
	}
	public void setChour(int chour) {
		this.chour = chour;
	}
	public int getLhour() {
		return lhour;
	}
	public void setLhour(int lhour) {
		this.lhour = lhour;
	}
	public int getTchour() {
		return tchour;
	}
	public void setTchour(int tchour) {
		this.tchour = tchour;
	}
	public int getTlhour() {
		return tlhour;
	}
	public void setTlhour(int tlhour) {
		this.tlhour = tlhour;
	}
}
