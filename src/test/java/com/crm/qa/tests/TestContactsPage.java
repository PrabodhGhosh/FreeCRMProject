package com.crm.qa.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.JSONDataProvider;


public class TestContactsPage extends Base{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@BeforeMethod
	public void setUp() {
		initialzation();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("UserName"), prop.getProperty("Password"));
		contactsPage= homePage.clickContacts();
	}
	
	@Test(priority = 1)

	public void validateUserInfoInContactsPage() {
		boolean isUserInfoDisplayed = contactsPage.isUserDisplayed();
		logger.info("User is displayed");
		Assert.assertEquals(isUserInfoDisplayed,true);
	}
	
	@Test(priority = 2,dataProvider = "dataproviderMethod", dataProviderClass = JSONDataProvider.class)

	public void createContact(Object testObject) {
		String fname =  (String) ((JSONObject) testObject).get("firstName");
		String lname =  (String) ((JSONObject) testObject).get("lastName");
		homePage.hoverOnContacts();
		homePage.clickNewContact();
		contactsPage.createNewContact(fname, lname);
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		driver.quit();
	}

}
