package com.amazon.pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InternationalBestSellersPage {
	
WebDriver driver;
	
	@FindBy(xpath = "//b[contains(text(),\"International Best Sellers \")]")
	WebElement internationalBestSellersText;
	
	@FindBy(xpath = "//div[contains(@class,\"search-result-card_style_apbSearchResultItem\")]")
	List<WebElement> bestSellersProducts;
	
	@FindBy(xpath = "//input[@name=\"submit.add-to-cart\"]")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//input[@name=\"submit.buy-now\"]")
	WebElement buyNowButton;
	
	
	
	public InternationalBestSellersPage(WebDriver driver) {           
        this.driver = driver; 
        PageFactory.initElements(driver, this);
}
	

	public WebElement getInternationalBestSellersText() {
		return internationalBestSellersText;
	}
	

	
	public void verifyAndValidateInternationalBestSellersText() {
		internationalBestSellersText.isDisplayed();
		String internationalBestSellersGetText = internationalBestSellersText.getText();
		Assert.assertEquals(internationalBestSellersGetText, "International Best Sellers","Its not equal as expected");
	
	}
	
	public void clickOnBestSellersProduct() {
		int productCount = bestSellersProducts.size();
		System.out.println("Total Product Count:"+ productCount);
		Assert.assertTrue(productCount>0);
		Assert.assertEquals(productCount, 12);
		bestSellersProducts.get(0).click();
	
	
	}
	
	
	public void verifyAddToCartButton() {

		addToCartButton.isDisplayed();
	
	}
	
	public void verifyBuyNowButton() {

		buyNowButton.isDisplayed();
	
	}


}
