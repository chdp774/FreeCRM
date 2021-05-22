package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.base;

public class CreateContactPage extends base{
	@FindBy(xpath = "//input[@name='first_name']")
	WebElement fname;
	
	@FindBy(xpath = "//input[@name='last_name']")
	WebElement lname;
	
	@FindBy(xpath = "//textarea[@name='description']")
	WebElement des;
	
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	public CreateContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ConfirmContactspage createContact(String fn, String ln, String d) {
		fname.sendKeys(fn);
		lname.sendKeys(ln);
		des.sendKeys(d);
		saveBtn.click();
		
		return new ConfirmContactspage();
	}
}
