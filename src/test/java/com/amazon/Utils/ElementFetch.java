package com.amazon.Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.amazon.test.BaseTest;

public class ElementFetch{
	
	public WebElement getWebElement(String identifierType ,String identifierValue) {
		switch (identifierType) {
		case "ID":
			return BaseTest.driver.findElement(By.id(identifierValue));
		case "XPATH":
			return BaseTest.driver.findElement(By.id(identifierValue));

		case "CSS":
			return BaseTest.driver.findElement(By.id(identifierValue));

		case "NAME":
			return BaseTest.driver.findElement(By.id(identifierValue));

       default:
		}
		return null;
		
	}
	
	public List<WebElement> getListWebElement(String identifierType ,String identifierValue) {
		switch (identifierType) {
		case "ID":
			return BaseTest.driver.findElements(By.id(identifierValue));
		case "XPATH":
			return BaseTest.driver.findElements(By.id(identifierValue));

		case "CSS":
			return BaseTest.driver.findElements(By.id(identifierValue));

		case "NAME":
			return BaseTest.driver.findElements(By.id(identifierValue));

       default:
		}
		return null;
		
	}

}
