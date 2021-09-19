package com.amazon.pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AppleWatchesResultPage {
	
WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),\"Wearable Device Connectivity Technology\")]")
	WebElement wearableDeviceConnectivityTechnologyText;
	
	@FindBy(xpath = "//li[@aria-label=\"Bluetooth\"]/descendant::input")
	WebElement bluetoothCheckBox;
	
	@FindBy(xpath = "//li[@aria-label=\\\"Cellular\\\"]/descendant::input")
	WebElement CellularCheckBox;
	
	@FindBy(xpath = "//input[@name=\"submit.buy-now\"]")
	WebElement buyNowButton;
	
	
	
	public AppleWatchesResultPage(WebDriver driver) {           
        this.driver = driver; 
        PageFactory.initElements(driver, this);
}


	
	public void verifyAndValidateWearableDeviceConnectivityTechnologyText() {
		wearableDeviceConnectivityTechnologyText.isDisplayed();
		String wearableDeviceConnectivityTechnologyTextMessage = wearableDeviceConnectivityTechnologyText.getText();
		Assert.assertEquals(wearableDeviceConnectivityTechnologyTextMessage, "Wearable Device Connectivity Technology","Its not equal as expected");
	
	}
	
	public void verifyAndClickOnBluetoothCheckBox() {
		bluetoothCheckBox.isDisplayed();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", bluetoothCheckBox);

	
	}
	
	public void printAllBlueToothProducts() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		List<WebElement> allProduct = driver.findElements(By.xpath("//span[@class=\"a-size-base a-color-base a-text-normal\"]"));		
		for (WebElement webElement : allProduct) {
	            String name = webElement.getText();
	            System.out.println("All BlueTooth product------------------------"+name);
	        }
	
	}
	
	public void print5thFromProductListforBlueTooth(int product) {

		List<WebElement> allProduct = driver.findElements(By.xpath("//span[@class=\"a-size-base a-color-base a-text-normal\"]"));		
		
		System.out.println("5th Product from list webelement:" + allProduct.get(product).getText());

	
	}
	
	public void verifyAndClickOnCellularCheckBox() {
		CellularCheckBox.isDisplayed();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", CellularCheckBox);

	
	}
	
	public void printAllCellularProducts() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		List<WebElement> allProduct = driver.findElements(By.xpath("//span[@class=\"a-size-base a-color-base a-text-normal\"]"));		
		for (WebElement webElement : allProduct) {
	            String name = webElement.getText();
	            System.out.println("All Cellular product------------------------"+name);
	        }
	
	}
	
	public void print5thFromProductListForCellular(int product) {

		List<WebElement> allProduct = driver.findElements(By.xpath("//span[@class=\"a-size-base a-color-base a-text-normal\"]"));		
		
		System.out.println("5th Product from list webelement:" + allProduct.get(product).getText());

	
	}
	
	
	
	

}
