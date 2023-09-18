package com.amdocs.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import finalproject.action;
import finalproject.base;

public class cart extends base {
	@FindBy(xpath = "//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/div[9]/div[1]/div[1]/a/div/span[2]")
	WebElement goToBag;
	
	@FindBy(xpath = "//*[@id=\"dCartWrapper\"]/div[2]/div[2]/div[2]/div[2]/button")
	WebElement toShipping;
	
	@FindBy(xpath = "//*[@id=\"dAccountWrapper\"]/div[2]/div[2]")
	WebElement toPayment;
	
	
		
	public cart() {
		PageFactory.initElements(driver, this);
	}
	
	public checkout proceedToBuy() throws Throwable {
		Thread.sleep(2000);
		action.click(driver, goToBag);
		Thread.sleep(1000);
		action.click(driver, toShipping);
		Thread.sleep(500);
		action.click(driver, toPayment);
		Thread.sleep(500);
		return new checkout();
	}
}
