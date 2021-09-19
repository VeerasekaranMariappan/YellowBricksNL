package com.amazon.pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	
	
	WebDriver driver;
	
	@FindBy(xpath = "//a[@href=\"/ref=nav_logo\"]")
	WebElement amazonLogo;
	
	@FindBy(xpath = "//h2[span[contains(text(),'Amazon Top Sellers')]]")
	WebElement amazonTopSellers;
	
	@FindBy(xpath = "//a[@aria-label=\"Amazon Top Sellers - Shop now\"]")
	WebElement amazonTopSellersShopnowLink;
	
	@FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
	WebElement searchTextBox;
	
	@FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]")
	WebElement searchSubmitButton;
	
	@FindBy(xpath = "//div[@data-component-type=\"s-search-result\"]")
	List<WebElement> searchResultForAppleWatches;
	
	
	
	public HomePage(WebDriver driver) {           
        this.driver = driver; 
        PageFactory.initElements(driver, this);
}
	

	public WebElement getAmazonLogo() {
		return amazonLogo;
	}
	
	public WebElement getAmazonTopSellers() {
		return amazonTopSellers;
	}
	
	public WebElement getAmazonTopSellersShopnowLink() {
		return amazonTopSellersShopnowLink;
	}
	
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	
	public void verifyAmazonLogo() {
		amazonLogo.isDisplayed();
	
	}
	
	public void verifyAndValidateAmazonTopSellers() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3100)", "");
		amazonTopSellers.isDisplayed();
		String amazonTopSellersText = amazonTopSellers.getText();
		Assert.assertEquals(amazonTopSellersText, "Amazon Top Sellers","Its not equal as expected");
		
	
	}
	
	public void verifyAndClickOnAmazonTopSellersShopnowLink() {

		amazonTopSellersShopnowLink.isDisplayed();
		amazonTopSellersShopnowLink.click();

	}
	
	public void verifySearchTextBox() {
		searchTextBox.isDisplayed();
	
	}
	
	public void SearchOnAppleWatch() {
		searchTextBox.sendKeys("Apple Watches");
		searchSubmitButton.click();
		
	}
	
	public void clickOnSearchButton() {
		searchSubmitButton.click();
		
	}


	public void verifyAppleWatchesCountGreaterThan10Results() {
		int productCount = searchResultForAppleWatches.size();
		System.out.println("Total Product Count:"+ productCount);
		Assert.assertTrue(productCount>10);
		//Assert.assertEquals(productCount, 22);
		searchResultForAppleWatches.get(5).click();
	
	}
}
