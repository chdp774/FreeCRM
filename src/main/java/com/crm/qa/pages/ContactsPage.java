package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.base;

public class ContactsPage extends base {
	
	@FindBy(xpath = "//div[@class= 'item']//a//button")
	WebElement createBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public CreateContactPage validateContactCreateLink() {
		createBtn.click();
		return new CreateContactPage();
	}
	
	
}
