package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class TestLoginPage extends Base{
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	@BeforeMethod
	public void setUp()
	{
		initialzation();
		loginPage = new LoginPage();
	}
	
	@Test (priority = 1)
	
	public void validateTitle()
	{
		String actualTitle = loginPage.validateLoginPage();
		String expectedTitle = "Free CRM - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test (priority = 2)
	public void validateLogin()
	{
		 homePage = loginPage.Login(prop.getProperty("UserName"), prop.getProperty("Password"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
