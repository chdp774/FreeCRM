package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.base;

public class HomePage extends base{
	
	@FindBy(xpath = "//div[@class='ui fluid container']//div[@id='top-header-menu']/div")
	WebElement logo;
	
	@FindBy(xpath = "//span[text() = 'Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath = "//span[text() = 'Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath = "//span[text() = 'Tasks']")
	WebElement tasksLink;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatehomePageLogo() {
		return logo.isDisplayed();
	}
	
	public String validateHomepageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage validateContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
}
