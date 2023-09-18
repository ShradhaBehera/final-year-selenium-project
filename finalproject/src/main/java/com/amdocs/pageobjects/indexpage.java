package com.amdocs.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import finalproject.action;
import finalproject.base;

public class indexpage extends base {

	@FindBy(xpath="//*[@id=\"appContainer\"]/div[1]/div/header/div[1]/ul/li[1]/span")
	WebElement SignIn;
	public indexpage() {
		PageFactory.initElements(driver, this);
	}
	public SignInPage clickSignInBtn() throws Throwable{
		action.click(driver,SignIn);
		return new SignInPage();		
	}
}
