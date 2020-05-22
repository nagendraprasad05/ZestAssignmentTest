package com.zest.testscripts;

import org.testng.annotations.Test;

import com.zest.pageobjects.AmazonPageObjects;
import com.zest.pageobjects.FlipkartPageObjects;
import com.zest.utils.TestBase;

import org.testng.annotations.BeforeTest;

import java.util.Set;

import org.testng.annotations.AfterTest;

/**
 * @author B Nagendra Prasad
 * Zest Assignment
 *
 */
public class PriceComparisionTest extends TestBase {

	AmazonPageObjects ao = new AmazonPageObjects();
	FlipkartPageObjects fo = new FlipkartPageObjects();

	@BeforeTest
	public void beforeTest() {
		openBrowser("chrome");
	}

	@Test(description = "comparing prices on Amazon and Flipkart")
	public void priceCompareTest() {
		float amazonPrice = getItemPriceOnAmazon();
		float flipkartPrice = getItemPriceOnFlipkart();

		System.out.println("Item Price on Amazon is : "+amazonPrice);
		System.out.println("Item Price on Flipkart is : "+flipkartPrice);

		if(amazonPrice > flipkartPrice){
			System.out.println("Item Price on Amazon is greater than Flipkart");
		}
		else if(amazonPrice < flipkartPrice){
			System.out.println("Item Price on Flipkart is greater than Amazon");
		}
		else{
			System.out.println("Item Price is SAME on Amazon and Flipkart");
		}
	}

	public float getItemPriceOnAmazon()
	{
		openURL("https://www.amazon.in/");
		enterText(ao.amazonSearchBox, "iphone xs max (64gb) gold");
		click(ao.amazonSubmit);
		click(ao.amazonProductLink);

		Set<String> activewindows = driver.getWindowHandles();
		Object[] windows = activewindows.toArray();
		switchToWindow(windows[1].toString());

		return convertPrice(getElementText(ao.amazonPrice));


	}

	public float getItemPriceOnFlipkart()
	{
		navigateToUrl("https://www.flipkart.com/");

		if(isElementPresent(fo.flipkartPopUp))
		{
			click(fo.flipkartPopUp);
		}
		enterText(fo.flipkartSearchBox, "iphone xs max (64gb) gold");
		click(fo.flipkartSubmit);
		click(fo.flipkartProductLink);

		Set<String> activewindows1 = driver.getWindowHandles();
		Object[] windows1 = activewindows1.toArray();

		switchToWindow(windows1[2].toString());

		return convertPrice(getElementText(fo.flipkartPrice));
	}


	@AfterTest
	public void afterTest() {
		quitBrowser();
	}



}
