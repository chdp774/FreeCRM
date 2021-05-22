package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends base{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.validateLogin(prop.getProperty("userid"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void logoTest() {
		Assert.assertTrue(homepage.validatehomePageLogo());
	}
	
	@Test(priority = 2)
	public void titleTest() {
		String title = homepage.validateHomepageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Homepage title mismatch");
	}
	
	@Test(priority = 3)
	public void contactsLinkTest() {
		homepage.validateContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
