package com.zest.utils;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author B Nagendra Prasad
 * Zest Assignment
 *
 */
public class TestBase { 
	protected WebDriver driver;

	public void openBrowser(String browserName) 
	{
		if(browserName == "chrome")
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName == "firefox")
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void openURL(String url) 
	{
		driver.get(url);
	}

	public void switchToWindow(String windowname)
	{
		driver.switchTo().window(windowname);
	}

	public boolean isElementPresent(By loc)
	{
		return driver.findElement(loc).isDisplayed();
	}

	public void navigateToUrl(String url)
	{
		driver.navigate().to(url);
	}
	public float convertPrice(String price)
	{
		
		price = price.replaceAll(",", "").replace(" ", "");
		String regex="([0-9]+[.]*[0-9]*)";

		Pattern pattern=Pattern.compile(regex);
		java.util.regex.Matcher matcher=pattern.matcher(price);

		while(matcher.find())
		{
			price = matcher.group();
			break;
		}

		return Float.parseFloat(price);

	}

	public String getElementText(By loc)
	{
		return driver.findElement(loc).getText();
	}


	public void enterText(By loc, String data) 
	{
		driver.findElement(loc).sendKeys(data);
	}

	public void click(By loc) 
	{
		driver.findElement(loc).click();
	}

	public void quitBrowser()
	{
		driver.quit();
	}

}
