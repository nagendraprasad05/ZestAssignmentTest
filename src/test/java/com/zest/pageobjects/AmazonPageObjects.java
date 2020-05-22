package com.zest.pageobjects;

import org.openqa.selenium.By;
/**
 * @author B Nagendra Prasad
 * Zest Assignment
 *
 */
public class AmazonPageObjects {
	
	public By amazonSearchBox = By.xpath("//input[@id='twotabsearchtextbox']");
	public By amazonSubmit = By.xpath("//input[@type='submit']");
	public By amazonProductLink = By.xpath("//span[text()='Apple iPhone Xs Max (64GB) - Gold']");
	public By amazonPrice = By.xpath("//span[@id='priceblock_ourprice']");

}
