package com.amdocs.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import finalproject.action;
import finalproject.base;
import com.amdocs.pageobjects.HomePage;
import com.amdocs.pageobjects.cart;

public class HomePage extends base {


	@FindBy(xpath = "//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/div/input")
    WebElement searchBox;
    @FindBy(xpath = "//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/form/div/button/span")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"products\"]/div[3]/div[1]/div/div[1]/a/div/div[1]/div[1]/img")
    WebElement firstItem;
    @FindBy(xpath = "//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/div[9]/div[1]/div[1]/div/span[2]")
    WebElement addToBag;
    @FindBy(xpath = "//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/div[2]/a/div")
    WebElement Cart;
    @FindBy(xpath = "//*[@id=\"appContainer\"]/div[1]/div/header/div[3]/div[2]/div[1]/a/img")
    WebElement wishList;
    @FindBy(xpath = "//*[@id=\"appContainer\"]/div[1]/div/header/div[1]/ul/li[3]/a")
    WebElement signOut;
    @FindBy(xpath = "//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/div[6]/div[2]/div/div/div[3]/div")
	WebElement size8;
	@FindBy(xpath = "//*[@id=\"appContainer\"]/div[2]/div/div/div[2]/div/div[3]/div/div[6]/div[2]/div/div/div[4]/div")
	WebElement size9;
    
    
    public HomePage() {
        PageFactory.initElements(HomePage.driver, (Object)this);
    }
    
    public void SearchProduct( String prod) throws Throwable {
        action.type(searchBox, prod);
        action.click(driver, searchButton);
    }
    
    public cart SelectProduct() throws Exception {
        action.click(driver, firstItem);
        action.Wait(driver, 5);
        ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        action.Wait(driver, 5);
        action.click(driver, size9);
        Thread.sleep(1500);
        action.click(driver, addToBag);
        return new cart();
    }
}
