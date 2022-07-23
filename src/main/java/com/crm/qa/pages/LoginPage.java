package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {

	// PageFactory

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPage()
	{
	    
		return driver.getTitle();
	}

	
	public HomePage Login(String user, String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		submitBtn.click();
		return new HomePage();
	}
}
