package model;

public class User {
	String uName, uEmail, uPassword, uIC;
	public boolean valid;
	

	public User(String uName, String uEmail, String uPassword, String uIC) {
		super();
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uIC = uIC;
	}
	
	public User() {}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuIC() {
		return uIC;
	}

	public void setuIC(String uIC) {
		this.uIC = uIC;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
		
	}

	public boolean isValid() {
		// TODO Auto-generated method stub
		return valid;
	}
	
}
