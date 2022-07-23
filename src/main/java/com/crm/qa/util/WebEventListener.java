package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.crm.qa.base.Base;

public class WebEventListener extends Base implements  WebDriverListener{
	
	@Override
    public void beforeGet(WebDriver driver, String url) {
      System.out.println("About to open a page "+	 url);
    }


	public void onError(java.lang.Object target, java.lang.reflect.Method method, java.lang.Object[] args, java.lang.reflect.InvocationTargetException e) {
		System.out.println("Exception occured: " + e);
		
	}

	
}
