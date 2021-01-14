package model;

import java.util.Date;

public class Author {
	private  String aName, aGender, uIC, aIC;
	private Date aDOB;
	
	public Author(String aIC, String aName, String aGender, Date aDOB, String uIC) {
		this.aName = aName;
		this.aGender = aGender;
		this.uIC = uIC;
		this.aIC = aIC;
		this.aDOB = aDOB;
	}
	
	public Author() {}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaGender() {
		return aGender;
	}

	public void setaGender(String aGender) {
		this.aGender = aGender;
	}

	public String getuIC() {
		return uIC;
	}

	public void setuIC(String uIC) {
		this.uIC = uIC;
	}

	public String getaIC() {
		return aIC;
	}

	public void setaIC(String aIC) {
		this.aIC = aIC;
	}

	public Date getaDOB() {
		return aDOB;
	}

	public void setaDOB(Date aDOB) {
		this.aDOB = aDOB;
	}
	
	
	
	
}
