package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class TestHomePage extends Base {

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		initialzation();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("UserName"), prop.getProperty("Password"));
	}

	@Test(priority = 1)

	public void validateUserInfo() {
		String UserInfo = homePage.getUserInfo();
		Assert.assertEquals(UserInfo, "  User: Tester Ghosh");
	}

	
	@Test(priority = 2)

	public void clickContacts() {
		homePage.clickContacts();
	}
	
	@Test(priority = 3)

	public void hoverOnContacts() {
		homePage.hoverOnContacts();
		homePage.clickNewContact();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
