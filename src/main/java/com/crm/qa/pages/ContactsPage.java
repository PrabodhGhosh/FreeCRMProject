package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class ContactsPage extends Base{
	
	@FindBy (xpath= "//*[contains(text(),'Tester')]")
	WebElement user;
	
	@FindBy (id= "first_name")
	WebElement firstName;
	
	@CacheLookup
	@FindBy (id= "surname")
	WebElement lastName;
	
	@FindBy (xpath= "//input[@value='Save']")
	WebElement saveBtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isUserDisplayed()
	{
		return user.isDisplayed();
	}
	
	public void createNewContact(String fname, String lname)
	{
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		saveBtn.click();
	}

}
