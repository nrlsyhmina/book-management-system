package model;

public class Publisher {
	String pName, pCity, pState, pIC, uIC;

	public Publisher(String pIC, String pName, String pCity, String pState, String uIC) {
		super();
		this.pName = pName;
		this.pCity = pCity;
		this.pState = pState;
		this.pIC = pIC;
		this.uIC = uIC;
	}
	
	public Publisher() {}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpCity() {
		return pCity;
	}

	public void setpCity(String pCity) {
		this.pCity = pCity;
	}

	public String getpState() {
		return pState;
	}

	public void setpState(String pState) {
		this.pState = pState;
	}

	public String getpIC() {
		return pIC;
	}

	public void setpIC(String pIC) {
		this.pIC = pIC;
	}

	public String getuIC() {
		return uIC;
	}

	public void setuIC(String uIC) {
		this.uIC = uIC;
	}
	
	
}
