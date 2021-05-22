package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.base;

public class LoginPage extends base{
	
	@FindBy(xpath = "//input[@name = 'email']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath = "//input[@name = 'password']")
	WebElement password;
	
	@FindBy(xpath = "//div[text() = 'Login']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
		
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public HomePage validateLogin(String ui, String pwd) {
		username.sendKeys(ui);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
}
