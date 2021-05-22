package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.base;
import com.crm.qa.pages.ConfirmContactspage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.until.Utility;

public class CreateContactsPageTest extends base{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	CreateContactPage createcontactspage;
	ConfirmContactspage confirmcontactspage;
	
	public CreateContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.validateLogin(prop.getProperty("userid"), prop.getProperty("password"));
		contactspage = homepage.validateContactsLink();
		createcontactspage = contactspage.validateContactCreateLink();
	}
	@DataProvider
	public Iterator<Object[]> getCRMData() {
		ArrayList<Object[]> fdata = Utility.excelData();
		return fdata.iterator();
	}
	
	@Test(dataProvider = "getCRMData")
	public void contactsTest(String ff, String ll, String dd) {
		confirmcontactspage = createcontactspage.createContact(ff, ll, dd);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	
}
