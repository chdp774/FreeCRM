package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends base{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	CreateContactPage createcontactpage;
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.validateLogin(prop.getProperty("userid"), prop.getProperty("password"));
		contactspage = homepage.validateContactsLink();
		//contactspage = new ContactsPage();
		
	}
	
	@Test(priority=1)
	public void createContactTest() {
		createcontactpage = contactspage.validateContactCreateLink();
	}
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
