package mini;

import java.io.Serializable;

public class Member implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5774590674849211103L;
	private String id;
	private String pwd;
	private String name;
	private String adrr;
	private String birthDate;
	private String gender;
	private String signupDate;
	private String revDate;
	private String revTime;
	private int price;
	
	
	public Member(String id, String pwd, String name, String adrr, String birthDate, String gender, String signupDate,
			String revDate, String revTime, int price) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.adrr = adrr;
		this.birthDate = birthDate;
		this.gender = gender;
		this.signupDate = signupDate;
		this.revDate = revDate;
		this.revTime = revTime;
		this.price = price;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAdrr() {
		return adrr;
	}


	public void setAdrr(String adrr) {
		this.adrr = adrr;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getSignupDate() {
		return signupDate;
	}


	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}


	public String getRevDate() {
		return revDate;
	}


	public void setRevDate(String revDate) {
		this.revDate = revDate;
	}


	public String getRevTime() {
		return revTime;
	}


	public void setRevTime(String revTime) {
		this.revTime = revTime;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", adrr=" + adrr + ", birthDate=" + birthDate
				+ ", gender=" + gender + ", signupDate=" + signupDate + ", revDate=" + revDate + ", revTime=" + revTime
				+ ", price=" + price + "]";
	}
	
	
	
	
	
	
	
	
	

}
