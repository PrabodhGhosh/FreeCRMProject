package com.crm.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.Base;

public class HomePage extends Base {

	@FindBy(xpath = "//td[@class='headertext']")
	WebElement userInfo;
	
	@FindBy(xpath = "//a[@title='Home']")
	WebElement homeLink;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContact;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getUserInfo() {
		driver.switchTo().frame("mainpanel");
		return userInfo.getText();
	}

	public ContactsPage clickContacts() {
		driver.switchTo().frame("mainpanel");
		contactsLink.click();
		return new ContactsPage();
	}


	public void hoverOnContacts() {
		driver.switchTo().frame("mainpanel");
		homeLink.click();
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
	}
	

	public void clickNewContact() {
		newContact.click();
	}

}
