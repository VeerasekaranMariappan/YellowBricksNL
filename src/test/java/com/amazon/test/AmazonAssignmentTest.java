package com.amazon.test;

import org.testng.annotations.Test;

import com.amazon.pageObjects.AppleWatchesResultPage;
import com.amazon.pageObjects.HomePage;
import com.amazon.pageObjects.InternationalBestSellersPage;

public class AmazonAssignmentTest extends BaseTest {
	
	HomePage HomePage;
	InternationalBestSellersPage internationalBestSellersPage;
	AppleWatchesResultPage appleWatchesResultPage;
	
	/*
	 * 1. Open any browser of your choice (Mozilla Firefox, Chrome, Internet Explorer or Safari).
	 *  Write the code in such a way that based on argument passed respective browser is selected.
       2. Browse to https://www.amazon.com// website.
       3. Validate the header of section with text ‘Amazon Top Sellers’ and on click traverses to the next page
        (perform any validation of your choice on this resulting page)
	 */
	
	@Test
	public void testCase1() {
		HomePage = new HomePage(driver);
		internationalBestSellersPage = new InternationalBestSellersPage(driver);
		
		//Verify Amazon Logo in Home Page
		HomePage.verifyAmazonLogo();
		
		//Verifying the Amazon Top Sellers in the Home page
		HomePage.verifyAndValidateAmazonTopSellers();
		
		//Clicking on Amazon Top Sellers shop now link
		HomePage.verifyAndClickOnAmazonTopSellersShopnowLink();
		
		
		
		//Verify International Best Sellers Text in the page
		internationalBestSellersPage.verifyAndValidateInternationalBestSellersText();
		
		// Click on first product in the page
		internationalBestSellersPage.clickOnBestSellersProduct();
		
		//Verify Add to cart button in the page
		internationalBestSellersPage.verifyAddToCartButton();
		
		//Verify Buy now button in the page
		internationalBestSellersPage.verifyBuyNowButton();

	}
	
	/*
	 * 1. Open any browser of your choice (Mozilla Firefox, Chrome, Internet Explorer or Safari). 
	 * Write the code in such a way that based on argument passed respective browser is selected.
       2. Browse to https://www.amazon.com// website.
       3. Enter a product in the search box on the homepage (say Apple Watches).
       4. Click the Search button.
       5. Verify you get more than 10 results
	 */
	@Test
	public void testCase2() {
		HomePage = new HomePage(driver);
		internationalBestSellersPage = new InternationalBestSellersPage(driver);
		
		//Verify the search box in the home page
		HomePage.verifySearchTextBox();
		
		//Entering "Apple Watches" text into the search box
		HomePage.SearchOnAppleWatch();
		
		// Clicking on Search button
		HomePage.clickOnSearchButton();
		
		// Checking whether teh search results is greater than 10
		HomePage.verifyAppleWatchesCountGreaterThan10Results();


	}
	
	/*
	 * 1. Open any browser of your choice (Mozilla Firefox, Chrome, Internet Explorer or Safari). 
	 * Write the code in such a way that based on argument passed respective browser is selected.
       2. Browse to https https://www.amazon.com// website.
       3. Enter a product in the search box on the homepage (say Apple Watches).
       4. Click the Search button. 5. In the results page, select category of Wearable Computer Connectivity Technology as Bluetooth in available options
       6. Write a method to print all products from 1st page along with scroll down (Note: Items per page needs to be 25).
       7. Write a method to print Nth product say 5th Product. (This should be a generic method)
       8. Perform steps 5, 6 and 7 for category Wearable Computer Connectivity Technology as cellular
	 */
	
	@Test
	public void testCase3() {
		HomePage = new HomePage(driver);
		internationalBestSellersPage = new InternationalBestSellersPage(driver);
		appleWatchesResultPage = new AppleWatchesResultPage(driver);
		
		//Verify the Search Text box
		HomePage.verifySearchTextBox();
		
		//Enter "Apple Watches" text in the search box
		HomePage.SearchOnAppleWatch();
		
		//Clicking on Search button
		HomePage.clickOnSearchButton();
		
		// Checking whether teh search results is greater than 10
		HomePage.verifyAppleWatchesCountGreaterThan10Results();
		
		//Verifying and validating the text "Wearable Device Connectivity Technology"
		appleWatchesResultPage.verifyAndValidateWearableDeviceConnectivityTechnologyText();
		
		
		/*
		 * Blue Tooth
		 */
		//Clicking on Blue Tooth Check box
		appleWatchesResultPage.verifyAndClickOnBluetoothCheckBox();
		
		//Printing all the Blue Tooth products 
		appleWatchesResultPage.printAllBlueToothProducts();
		
		//Print the nth 5 th index products 
		appleWatchesResultPage.print5thFromProductListforBlueTooth(5);
		
		
		/*
		 * Cellular
		 */
		//Clicking on Cellular Check box
		appleWatchesResultPage.verifyAndClickOnCellularCheckBox();
		//Printing all the Cellular products 
		appleWatchesResultPage.printAllCellularProducts();
		//Print the nth 5 th index products 
		appleWatchesResultPage.print5thFromProductListForCellular(5);

	}

}
