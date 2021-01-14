package model;

import java.util.Date;

public class Book {
	int bPage;
	String bTitle, bEdition, bFiction, bLanguage, pIC, uIC, isbn;
	Date bDate;
	public Book(int bPage, String bTitle, String bEdition, String bFiction, String bLanguage, String pIC, String uIC,
			String isbn, Date bDate) {
		this.bPage = bPage;
		this.bTitle = bTitle;
		this.bEdition = bEdition;
		this.bFiction = bFiction;
		this.bLanguage = bLanguage;
		this.pIC = pIC;
		this.uIC = uIC;
		this.isbn = isbn;
		this.bDate = bDate;
	}
	public Book() {}
	
	public int getbPage() {
		return bPage;
	}
	public void setbPage(int bPage) {
		this.bPage = bPage;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbEdition() {
		return bEdition;
	}
	public void setbEdition(String bEdition) {
		this.bEdition = bEdition;
	}
	public String getbFiction() {
		return bFiction;
	}
	public void setbFiction(String bFiction) {
		this.bFiction = bFiction;
	}
	public String getbLanguage() {
		return bLanguage;
	}
	public void setbLanguage(String bLanguage) {
		this.bLanguage = bLanguage;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	
	
}
